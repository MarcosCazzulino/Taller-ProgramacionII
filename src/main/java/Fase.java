import java.util.ArrayList;
import java.util.List;

public class Fase {
    private NombreFase nombre;
    private List<Partido> partidos;

    public Fase() {
        this(null);
    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.partidos = new ArrayList<Partido>();
    }

    public void setPartidos(List<Partido> partidos) { this.partidos = partidos; }
    public void agregarPartido(Partido partido) { this.partidos.add(partido); }

    public void setNombre(NombreFase nombre) { this.nombre = nombre; }
    public NombreFase getNombre() { return this.nombre; }
}