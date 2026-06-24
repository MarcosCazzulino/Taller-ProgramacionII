import java.util.*;

public class GestionMundial {
    private List<Partido> partidos;
    private List<Seleccion> selecciones;

    public GestionMundial() {
        this.partidos = new ArrayList<>();
        this.selecciones = new ArrayList<>();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public List<Seleccion> getSelecciones() {
        return selecciones;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void setSelecciones(List<Seleccion> selecciones) {
        this.selecciones = selecciones;
    }

    public void agregarPartido(Partido p) {
        this.partidos.add(p);
    }

    public void agregarSeleccion(Seleccion s) {
        this.selecciones.add(s);
    }

    public void rankingGoleadores(){
        Map<Jugador, Integer> goleadores = new HashMap<>();
        Map<Jugador, String> seleccionDeJugador = new HashMap<>();

        for (Partido partido : this.partidos) {
            for (Evento evento : partido.getEventos()) {
                if (evento.getTipo() == TipoEvento.GOL || evento.getTipo() == TipoEvento.PENAL_CONVERTIDO) {
                    Jugador jugador = evento.getJugador();
                    goleadores.put(jugador, goleadores.getOrDefault(jugador, 0) + 1);

                    if (!seleccionDeJugador.containsKey(jugador)) {
                        String nombreSeleccion = "Desconocida";
                        for (Participacion p : partido.getParticipaciones()) {
                            Seleccion s = p.getSeleccion();
                            if (s.getJugadores() != null && s.getJugadores().contains(jugador)) {
                                nombreSeleccion = s.getNombreFederacion();
                                break;
                            }
                        }
                        seleccionDeJugador.put(jugador, nombreSeleccion);
                    }
                }
            }
        }

        List<Map.Entry<Jugador, Integer>> ranking = new ArrayList<>(goleadores.entrySet());
        Collections.sort(ranking, new Comparator<Map.Entry<Jugador, Integer>>() {
            @Override
            public int compare(Map.Entry<Jugador, Integer> entry1, Map.Entry<Jugador, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        System.out.println("------- TABLA DE GOLEADORES -------");
        int puesto = 1;
        for (Map.Entry<Jugador, Integer> entrada : ranking) {
            Jugador jug = entrada.getKey();
            int goles = entrada.getValue();

            String nombreSeleccion = seleccionDeJugador.get(jug);

            System.out.println(puesto + ". " + jug.getNombre() + " (" + nombreSeleccion + ") - " + goles);
            puesto++;
        }
        System.out.println("-----------------------------------");
    }
}
