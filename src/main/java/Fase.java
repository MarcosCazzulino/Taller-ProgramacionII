import java.util.ArrayList;
import java.util.List;

public class Fase {
    private NombreFase nombre;
    private List<Partido> partidos;
    private List<Grupo> grupos;

    public Fase() {
        this(null);
    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.partidos = new ArrayList<Partido>();
        this.grupos= new ArrayList<Grupo>();
    }

    public Fase(NombreFase nombre, List<Partido> partidos, List<Grupo> grupos){ 
        this.nombre= nombre;
        this.partidos= partidos;
        this.grupos= grupos;
    }
    
    public void setPartidos(List<Partido> partidos) { this.partidos = partidos; }
    public List<Partido> getPartidos(){ return this.partidos; } 
    public void agregarPartido(Partido partido) { this.partidos.add(partido); }
    public void setNombre(NombreFase nombre) { this.nombre = nombre; }
    public NombreFase getNombre() { return this.nombre; }

    public void setGrupos(List<Grupo> grupos){ this.grupos=grupos; } 
    public List<Grupo> getGrupos(){ return this.grupos; }
    public void agregarGrupo(Grupo grupo) { this.grupos.add(grupo); }
    //Metodo para en clase gestora hacer una restriccion a la hora de agregar partidos a una fase.
    public int cantidadMaximaPartidos() {
        switch (nombre) {
            case DIECISEISAVOS: return 16;
            case OCTAVOS: return 8;
            case CUARTOS: return 4;
            case SEMIFINAL: return 2;
            case FINAL: return 1;
            default: return 0;
        }
    }}
