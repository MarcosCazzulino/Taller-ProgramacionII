import java.util.*;

public class GestionMundial {
    private List<Fase> fases;
    private List<Grupo> grupos;
    private List<Partido> partidos;
    private List<Seleccion> selecciones;

    public GestionMundial() {
        this.partidos = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.fases=new ArrayList<>();
        this.grupos=new ArrayList<>();
    }

    public List<Fase> getFases(){
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases;
    }


    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
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

    public void resultadosSeleccion(Seleccion s){
        if (!this.selecciones.contains(s)) {
            throw new IllegalArgumentException("Esta selección no participa en el Mundial");
        }

        int puntos = 0;
        if (s.getGrupo() != null) {
            puntos = s.getGrupo().obtenerPuntos(s);
        }

        NombreFase instanciaAlcanzada = s.instanciaAlcanzada();
        System.out.println("----------------------------");
        System.out.println("Selección: " + s.getNombreFederacion());
        System.out.println("Fase de Grupos: " + puntos + " pts");
        System.out.println("Instancia: "+ s.instanciaAlcanzada());
    }

    public void informeDiscSelec(Seleccion s){
        if (!this.selecciones.contains(s)) {
            throw new IllegalArgumentException("Esta selección no forma parte del mundial");
        }

        System.out.println("------ Informe Disciplinario de " + s.getNombreFederacion() + " ------");
        if (s.getJugadores().isEmpty()) {
            System.out.println("No hay jugadores cargados en el plantel");
            return;
        }

        for (Jugador j : s.getJugadores()){
            int amarillas = 0, rojas= 0;

            for (Evento e: j.getEventos()){
                if (e.getTipo() == TipoEvento.TARJETA_AMARILLA || e.getTipo() == TipoEvento.DOBLE_AMARILLA){
                    amarillas++;
                }

                if (e.getTipo() == TipoEvento.DOBLE_AMARILLA || e.getTipo() == TipoEvento.TARJETA_ROJA) {
                    rojas++;
                }
            }

            if (amarillas > 0 && rojas > 0){
                System.out.println("- " + j.getNombre() + "(Nro. " + j.getDorsal() + "): " + amarillas + " amarillas | " + rojas + " rojas.");
            } else if (amarillas > 0 && rojas == 0) {
                System.out.println("- " + j.getNombre() + "(Nro. " + j.getDorsal() + "): " + amarillas + " amarillas.");
            } else if (amarillas == 0 && rojas > 0) {
                System.out.println("- " + j.getNombre() + "(Nro. " + j.getDorsal() + "): " + rojas + " rojas.");
            } else {
                System.out.println("- " + j.getNombre() + "(Nro. " + j.getDorsal() + "): " + " sin tarjetas.");
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void estadisticasSede(Sede sede) {
        if (sede == null) {
            throw new IllegalArgumentException("La sede no puede ser nula");
        }

        System.out.println("------ Estadísticas de Sede ------");
        System.out.println("Ciudad: " + sede.getCiudad());
        System.out.println("Capacidad: " + sede.capacidadSede() + " espectadores");
        System.out.println("Partidos jugados: " + sede.cantidadPartidosPorCiudad());
        System.out.println("----------------------------------");
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

    public void registrarEvento(Partido partido, TipoEvento tipo, int minuto, Jugador jugador) {
        if (!this.partidos.contains(partido)) {
            throw new IllegalArgumentException("El partido no está registrado en el fixture del mundial");
        }

        try {
            partido.agregarEvento(tipo, minuto, jugador);
            System.out.println("| " + minuto + "' · " + tipo + " - " + jugador.getNombre() + " |");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar el evento: " + e.getMessage());
        }
    }

    public void registrarSeleccion(Seleccion s) {
        if (s != null && !this.selecciones.contains(s)) {
            this.selecciones.add(s);
            System.out.println(s.getNombreFederacion() + " ha sido registrada en el Mundial");
        }
    }

    public void agregarJugadorASeleccion(Seleccion s, Jugador jug) {
        if (!this.selecciones.contains(s)) {
            throw new IllegalArgumentException("Esta selección no está registrada en el Mundial");
        }

        for (Seleccion selec : this.selecciones) {
            if (selec.getJugadores() != null && selec.getJugadores().contains(jug)) {
                throw new IllegalArgumentException("Este jugador ya forma parte de la Selección");
            }
        }

        s.agregarJugador(jug);
        System.out.println(jug.getNombre() + " se ha integrado al plantel de " + s.getNombreFederacion());
    }

    public void agregarDTASeleccion(Seleccion s, DirectorTecnico dt) {
        if (!this.selecciones.contains(s)) {
            throw new IllegalArgumentException("Esta selección no forma parte del Mundial");
        }

        s.agregarDT(dt);
        System.out.println(dt.getNombre() + " es ahora el DT de " + s.getNombreFederacion());
    }

    public void agregarCuerpoTecnico(Seleccion s, CuerpoTecnico ct) {
        if (!this.selecciones.contains(s)) {
            throw new IllegalArgumentException("Esta selección no forma parte del mundial");
        }

        s.agregarCuerpoTecnico(ct);
        System.out.println(ct.getNombre() + " (" + ct.getRol() + ") se incorporó al cuerpo técnico de " + s.getNombreFederacion());
    }

    //Configurar los grupos y fases de eliminacion asi como planificar los partidos
    public void configurarFasesEliminacion(){
        fases.add(new Fase(NombreFase.DIECISEISAVOS));
        fases.add(new Fase(NombreFase.OCTAVOS));
        fases.add(new Fase(NombreFase.CUARTOS));
        fases.add(new Fase(NombreFase.SEMIFINAL));
        fases.add(new Fase(NombreFase.FINAL));
    }

    public void planificarPartido(Fase fase, Partido partido) {
        if (!partido.esValidoArbitraje()) {
            throw new IllegalStateException("El equipo de arbitrajes es inválido");
        }

        if (!partido.tieneSeleccionesSuficientes()) {
            throw new IllegalStateException("Cantidad de selecciones insuficientes para disputar el partido");
        }

        if (fase.getPartidos().size() < fase.cantidadMaximaPartidos()) {
            fase.agregarPartido(partido);
            partido.setFase(fase);
            this.partidos.add(partido);
        } else {
            throw new IllegalStateException("Esta fase ya alcanzó el máximo de partidos");
        }
    }
}
