import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partido {
    private Date fecha;
    private Time horario;
    private int duracion;
    private int tiempoAdicional;
    private Fase fase;
    private Estadio estadio;
    private List<Participacion> participaciones;
    private List<Arbitraje> arbitrajes;

    public Partido() {
        this(null, null, 0, 0, null);
    }

    public Partido(Date fecha, Time horario, int duracion, int tiempoAdicional, Fase fase) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.fase = fase;
        this.participaciones = new ArrayList<Participacion>();
        this.arbitrajes = new ArrayList<Arbitraje>();
    }

    public void agregarParticipacion(Participacion participacion) {
        if (this.participaciones.size() < 2) {
            this.participaciones.add(participacion);
        } else {
            System.out.println("Ya hay dos selecciones en el partido");
        }
    }

    public List<Participacion> getParticipaciones() { return participaciones; }
    public void setParticipaciones(List<Participacion> participaciones) { this.participaciones = participaciones; }

    public List<Arbitraje> getArbitrajes() { return arbitrajes; }
    public void setArbitrajes(List<Arbitraje> arbitrajes) { this.arbitrajes = arbitrajes; }

    public Estadio getEstadio() { return estadio; }
    public void setEstadio(Estadio estadio) { this.estadio = estadio; }

    public Date getFecha() { return this.fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHorario() { return this.horario; }
    public void setHorario(Time horario) { this.horario = horario; }

    public int getDuracion() { return this.duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public int getTiempoAdicional() { return this.tiempoAdicional; }
    public void setTiempoAdicional(int tiempoAdicional) { this.tiempoAdicional = tiempoAdicional; }
}