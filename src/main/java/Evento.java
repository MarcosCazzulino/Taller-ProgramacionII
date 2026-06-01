public class Evento {
    private TipoEvento tipo;
    private int minuto;
    private Partido partido;
    private Jugador jugador;

    public Evento() {
        this(TipoEvento.GOL, 0, null, null);
    }

    public Evento(TipoEvento tipo, int minuto, Partido partido, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.partido = partido;
        this.jugador = jugador;
    }

    public TipoEvento getTipo() { return tipo; }
    public void setTipo(TipoEvento tipo) { this.tipo = tipo; }

    public int getMinuto() { return minuto; }
    public void setMinuto(int minuto) { this.minuto = minuto; }

    public Partido getPartido() { return partido; }
    public void setPartido(Partido partido) { this.partido = partido; }

    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }
}