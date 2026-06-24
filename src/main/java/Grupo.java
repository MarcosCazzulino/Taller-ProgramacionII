import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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

    public List<Seleccion> getSelecciones() { return selecciones; }
    public void setSelecciones(List<Seleccion> selecciones){ this.selecciones=selecciones; }

    public void mostrarTablaPosiciones() {
        List<Seleccion> tabla = new ArrayList<>(this.selecciones);

        Collections.sort(tabla, new Comparator<Seleccion>() {
            @Override
            public int compare(Seleccion s1, Seleccion s2) {
                return compararSelecciones(s1, s2);
            }
        });
        System.out.println("TABLA DE POSICIONES - GRUPO " + this.identificacion);

        int posicion = 1;
        for (Seleccion s : tabla) {
            System.out.println(posicion + "° " + s.getNombreFederacion() + " - " + obtenerPuntos(s) + " pts");
            posicion++;
        }
    }

    public int compararSelecciones(Seleccion s1, Seleccion s2) {
        return Integer.compare(obtenerPuntos(s2), obtenerPuntos(s1));
    }
}