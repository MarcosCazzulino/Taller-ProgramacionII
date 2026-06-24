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

    public void setGrupos(List<Grupo> grupos){ this.grupos= grupos; }
    public void agregarGrupo(Grupo grupo) { this.grupos.add(grupo); }
    public List<Grupo> getGrupos(){ return this.grupos; } 
    
    public void setPartidos(List<Partido> partidos) { this.partidos = partidos; }
    public void agregarPartido(Partido partido) { this.partidos.add(partido); }
    public List<Partido> getPartidos(){ return this.partidos; }

    public void setNombre(NombreFase nombre) { this.nombre = nombre; }
    public NombreFase getNombre() { return this.nombre; }
}
