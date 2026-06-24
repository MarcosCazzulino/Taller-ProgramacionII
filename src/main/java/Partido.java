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
    private List<Evento> eventos;

    public Partido() {
        this(null, null, 0, 0, null, null);
    }

    public Partido(Date fecha, Time horario, int duracion, int tiempoAdicional, Fase fase, Estadio estadio) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.fase = fase;
        this.estadio= estadio;
        this.participaciones = new ArrayList<Participacion>();
        this.arbitrajes = new ArrayList<Arbitraje>();
        this.eventos = new ArrayList<Evento>();
    }

    public void agregarParticipacion(Participacion participacion) {
        if (this.participaciones.size() < 2) {
            this.participaciones.add(participacion);
        } else {
            System.out.println("Ya hay dos selecciones en el partido");
        }
    }
    public List<Participacion> getParticipaciones() { return participaciones; }
    public void setParticipaciones(List<Participacion> participaciones) {
        if (participaciones.size() <= 2) {
            this.participaciones = participaciones;
        } else {
            System.out.println("En un partido pueden participar máximo 2 selecciones");
        }
    }

    public List<Arbitraje> getArbitrajes() { return arbitrajes; }
    public void setArbitrajes(List<Arbitraje> arbitrajes) { this.arbitrajes = arbitrajes; }
    public void agregarArbitraje(Arbitraje arbitraje) { this.arbitrajes.add(arbitraje); }

    public Estadio getEstadio() { return estadio; }
    public void setEstadio(Estadio estadio) { this.estadio = estadio; }

    public List<Evento> getEventos() { return eventos; }
    public void setEventos(List<Evento> eventos) { this.eventos = eventos; }

    public void agregarEvento(TipoEvento tipo, int minuto, Jugador jugador) {
        boolean estaJugando = false;

        for (Participacion p : this.participaciones) {
            Seleccion s = p.getSeleccion();
            if (s.getJugadores() != null && s.getJugadores().contains(jugador)) {
                estaJugando = true;
                break;
            }
        }
        if (estaJugando) {
            this.eventos.add(new Evento(tipo, minuto, jugador));
        } else {
            throw new IllegalArgumentException("El jugador " + jugador.getNombre() + " no participa en este partido");
        }
    }

    public Date getFecha() { return this.fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHorario() { return this.horario; }
    public void setHorario(Time horario) { this.horario = horario; }

    public int getDuracion() { return this.duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public int getTiempoAdicional() { return this.tiempoAdicional; }
    public void setTiempoAdicional(int tiempoAdicional) { this.tiempoAdicional = tiempoAdicional; }

    public void setFase(Fase fase) { this.fase= fase; }
    public Fase getFase(){ return this.fase; }

    public void mostrarAlineaciones() {
        System.out.println("------ ALINEACIONES -------");
        for (Participacion p : this.participaciones) {
            Seleccion sele = p.getSeleccion();
            System.out.println("");
            System.out.println(sele.getNombreFederacion() + ":");
            for (Jugador j : sele.getJugadores()) {
                System.out.println(j.getDorsal() + "- " + j.getNombre() + "    " + j.getPosicion());
            }
        }
    }

    public void mostrarEventos(){
        System.out.println("------ EVENTOS -------");
        for (Evento e : this.eventos){
            System.out.println(e.getMinuto() + "' - "+ e.getTipo() + " - " + e.getJugador().getNombre());
        }
    }

    public void mostrarResultado(){ System.out.println(this.participaciones.get(0).getSeleccion().getNombreFederacion() + " " + this.participaciones.get(0).cantidadGoles() + "-" + this.participaciones.get(1).cantidadGoles() + " " + this.participaciones.get(1).getSeleccion().getNombreFederacion()); }
    public boolean tieneSeleccionesSuficientes() {
        return this.participaciones.size() == 2;
    }

    public boolean esValidoArbitraje(){
        boolean arbPrincipal = false;
        boolean asistente1 = false;
        boolean asistente2 = false;
        boolean cuartoArb = false;
        boolean varPrincipal = false;
        boolean varAsistente = false;
        for (Arbitraje a : this.arbitrajes) {
            if (a.getRol() == CategoriaArbitro.PRINCIPAL) arbPrincipal = true;
            if (a.getRol() == CategoriaArbitro.ASISTENTE1) asistente1 = true;
            if (a.getRol() == CategoriaArbitro.ASISTENTE2) asistente2 = true;
            if (a.getRol() == CategoriaArbitro.CUARTOARBITRO) cuartoArb = true;
            if (a.getRol() == CategoriaArbitro.VARPRINCIPAL) varPrincipal = true;
            if (a.getRol() == CategoriaArbitro.VARASISTENTE) varAsistente = true;
        }
        return arbPrincipal && asistente1 && asistente2 && cuartoArb && varPrincipal && varAsistente;
    }
    public void fichaTecnica(){
        this.mostrarAlineaciones();
        System.out.println("");
        System.out.println("");
        this.mostrarEventos();
        System.out.println("");
        System.out.println("");
        this.mostrarResultado();
    }
}