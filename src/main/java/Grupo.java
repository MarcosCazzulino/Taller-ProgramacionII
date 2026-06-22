import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private List<Seleccion> selecciones;
    private Fase fase;

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.selecciones = new ArrayList<Seleccion>();
        this.fase= fase;
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

    public void setFase(Fase fase) { this.fase= fase; }
    public Fase getFase(){ return this.fase; } 

    public void setSelecciones(List<Seleccion> selecciones){ this.selecciones= selecciones; }
    public List<Seleccion> getSelecciones() { return selecciones; }
}
