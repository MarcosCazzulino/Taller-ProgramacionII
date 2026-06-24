import java.util.ArrayList;
import java.util.List;

public class Estadio {
    private String nombre;
    private int capacidad;
    private Sede sede;
    private List<Partido> partidos;

    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos= new ArrayList<Partido>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }

    public List<Partido> getPartidos(){ return this.partidos; }
    public void setPartidos(List<Partido> partidos){ this.partidos= partidos; }
    public void agregarPartido(Partido partido) { this.partidos.add(partido); }
    public int cantidadPartidos(){
        return  partidos.size();
    }
}
