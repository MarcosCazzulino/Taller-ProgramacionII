import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private List<Seleccion> selecciones;

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<Seleccion>();
        this.fase=fase;
    }
    
    public void agregarSeleccion(Seleccion s) {
        if (this.selecciones.size() < 4) {
            this.selecciones.add(s);
        } else {
            System.out.println("El grupo ya tiene el máximo de selecciones permitidas.");
        }
    }

    public int obtenerPuntos(Seleccion s) {
        // (Victoria = 3 puntos, Empate = 1 punto, Derrota = 0 puntos).
        return 0;
    }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Seleccion> getSelecciones() { return selecciones; }
    public void setSelecciones(List<Seleccion> selecciones){ this.selecciones=selecciones; }
    public void agregarSeleccion(Seleccion seleccion) { this.selecciones.add(seleccion); }
}
