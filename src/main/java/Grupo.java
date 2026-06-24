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
        // Si la selección no se encuentra en este grupo, retorna 0
        if (!this.selecciones.contains(s)) {
            return 0;
        }

        int puntos = 0;
        for (Participacion partSelActual : s.getParticipaciones()) {
            Partido partido = partSelActual.getPartido();

            // Se valida que el partido pertenezca a esta fase
            if (partido.getFase() == this.fase) {
                Participacion participacionRival = null;
                for (Participacion pRival : partido.getParticipaciones()) {
                    // Se valida que no sea la misma selección
                    if (pRival.getSeleccion() != s) {
                        participacionRival = pRival;
                        break;
                    }
                }

                if (participacionRival != null) {
                    int golesSelActual = partSelActual.cantidadGoles();
                    int golesRival = participacionRival.cantidadGoles();

                    if (golesSelActual > golesRival) {
                        puntos += 3;
                    } else if (golesSelActual == golesRival) {
                        puntos += 1;
                    }
                }
            }
        }
        return puntos;
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
