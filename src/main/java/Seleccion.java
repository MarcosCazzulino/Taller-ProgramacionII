import java.util.ArrayList;
import java.util.List;

public class Seleccion {
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private DirectorTecnico directorTecnico;
    private List<CuerpoTecnico> cuerpoTecnico;
    private List<Jugador> jugadores;
    private List<Participacion> participaciones;

    public Seleccion() {
        this("", "", "", false, 0);
    }

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo, int rankingFIFA) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.cuerpoTecnico = new ArrayList<CuerpoTecnico>();
        this.jugadores = new ArrayList<Jugador>();
        this.participaciones = new ArrayList<Participacion>();
    }

    public DirectorTecnico getDirectorTecnico() { return directorTecnico; }
    public void setDirectorTecnico(DirectorTecnico directorTecnico) { this.directorTecnico = directorTecnico; }

    public List<Jugador> getJugadores() { return jugadores; }
    public void agregarJugador(Jugador j) { this.jugadores.add(j); }

    public List<Participacion> getParticipaciones() { return participaciones; }
    public void agregarParticipacion(Participacion p) { this.participaciones.add(p); }

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
}
