import java.util.ArrayList;
import java.util.List;

public class Seleccion {
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private Grupo grupo;
    private Pais pais;
    private List<DirectorTecnico> directorTecnico;
    private List<CuerpoTecnico> cuerpoTecnico;
    private List<Jugador> jugadores;
    private List<Participacion> participaciones;

    public Seleccion() {
        this("", "", "", false, 0, null, null);
    }

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo, int rankingFIFA, Grupo grupo, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.grupo= grupo;
        this.pais= pais;
        this.directorTecnico= new ArrayList<DirectorTecnico>();
        this.cuerpoTecnico = new ArrayList<CuerpoTecnico>();
        this.jugadores = new ArrayList<Jugador>();
        this.participaciones = new ArrayList<Participacion>();
    }

    public List<DirectorTecnico> getDirectorTecnico() { return this.directorTecnico; }
    public void setDirectorTecnico(ArrayList<DirectorTecnico> directorTecnico) { this.directorTecnico = directorTecnico; }
    public void agregarDT(DirectorTecnico dt){ this.directorTecnico.add(dt); }

    public void setJugadores(ArrayList<Jugador> jugadores) { this.jugadores= jugadores;}
    public List<Jugador> getJugadores() { return jugadores; }
    public void agregarJugador(Jugador j) { this.jugadores.add(j); }

    public void setParticipaciones(ArrayList<Participacion> participaciones) { this.participaciones= participaciones; }
    public List<Participacion> getParticipaciones() { return participaciones; }
    public void agregarParticipacion(Participacion p) { this.participaciones.add(p); }

    public List<CuerpoTecnico> getCuerpoTecnico(){ return this.cuerpoTecnico; }
    public void setCuerpoTecnico(List<CuerpoTecnico> cuerpoTecnico) { this.cuerpoTecnico = cuerpoTecnico; }
    public void agregarCuerpoTecnico(CuerpoTecnico cuerpTec) { this.cuerpoTecnico.add(cuerpTec); }

    public String getNombreFederacion() { return this.nombreFederacion; }
    public void setNombreFederacion(String nombreFederacion) { this.nombreFederacion = nombreFederacion; }

    public String getCamisetaPrincipal() { return this.camisetaPrincipal; }
    public void setCamisetaPrincipal(String camisetaPrincipal) { this.camisetaPrincipal = camisetaPrincipal; }

    public String getCamisetaSecundaria() { return this.camisetaSecundaria; }
    public void setCamisetaSecundaria(String camisetaSecundaria) { this.camisetaSecundaria = camisetaSecundaria; }

    public boolean isCabezaGrupo() { return this.cabezaGrupo; }
    public void setCabezaGrupo(boolean cabezaGrupo) { this.cabezaGrupo = cabezaGrupo; }

    public int getRankingFIFA() { return this.rankingFIFA; }
    public void setRankingFIFA(int rankingFIFA) { this.rankingFIFA = rankingFIFA; }

    public void setGrupo(Grupo grupo) { this.grupo= grupo; }
    public Grupo getGrupo(){ return this.grupo; }

    public void setPais(Pais pais) { this.pais= pais; }
    public Pais getPais(){ return this.pais; } 
                                                 
    public boolean tienePartidosAsignados() { return !this.participaciones.isEmpty(); }
    
    public int calcularPuntosGrupo() {
        int puntos = 0;

        for (Participacion p : participaciones) {
            Partido partido = p.getPartido();

            // Solo cuenta los partidos de fase de grupos
            if (partido.getFase().getNombre() != NombreFase.GRUPOS) {
                continue;
            }

            int golesMiSeleccion = p.cantidadGoles();

            for (Participacion rival : partido.getParticipaciones()) {
                if (rival.getSeleccion() != this) {
                    int golesRival = rival.cantidadGoles();

                    if (golesMiSeleccion > golesRival) {
                        puntos += 3;
                    } else if (golesMiSeleccion == golesRival) {
                        puntos += 1;
                    }
                    break; // ya encontre al rival
                }
            }
        }
        return puntos;
    }

    public NombreFase instanciaAlcanzada() {
        NombreFase instancia = NombreFase.GRUPOS;

        for (Participacion p : this.participaciones) {
            instancia = p.getPartido().getFase().getNombre();
        }
        return instancia;
    }

    public void resultadosSeleccion(){
        System.out.println("Selección: "+ this.nombreFederacion);
        System.out.println("Puntaje: "+ this.calcularPuntosGrupo());
        System.out.println("Instancia: "+ this.instanciaAlcanzada());
    }

    public void informeDiscSelec(){
        for (Jugador j: this.jugadores){
            int amarillas = 0, rojas= 0;
            for (Evento e: j.getEventos()){
                if (e.getTipo()==TipoEvento.TARJETA_AMARILLA || e.getTipo()==TipoEvento.DOBLE_AMARILLA){
                    amarillas++;
                } else if (e.getTipo()==TipoEvento.TARJETA_ROJA) {
                    rojas++;
                }
            }
            if (amarillas>0 && rojas>0){
                System.out.println(j.getNombre() + ": " + amarillas + " amarillas, " + rojas + " rojas.");
            } else if (amarillas>0 && rojas==0) {
                System.out.println(j.getNombre() + ": " + amarillas + " amarillas.");
            } else if (amarillas==0 && rojas>0) {
                System.out.println(j.getNombre() + ": " + rojas + " rojas.");
            } else {
                System.out.println(j.getNombre() + ": sin tarjetas");
            }
        }
    }
}
