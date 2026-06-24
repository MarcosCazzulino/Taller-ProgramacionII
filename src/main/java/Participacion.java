public class Participacion {
    private boolean esLocal;
    private Partido partido;
    private Seleccion seleccion;

    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion = seleccion;
    }

    public boolean isEsLocal() { return esLocal; }
    public void setEsLocal(boolean esLocal) { this.esLocal = esLocal; }

    public Partido getPartido() { return partido; }
    public void setPartido(Partido partido) { this.partido = partido; }

    public Seleccion getSeleccion() { return seleccion; }
    public void setSeleccion(Seleccion seleccion) { this.seleccion = seleccion; }

    public int cantidadGoles() {
        int goles = 0;

        for (Evento e : this.partido.getEventos()) {
            if (e.getTipo() == TipoEvento.GOL || e.getTipo() == TipoEvento.PENAL_CONVERTIDO) {
                if (e.getJugador().getSeleccion() == this.seleccion) {
                    goles++;
                }
            }
        }

        return goles;
    }

    public int cantidadTarjAmarillas() {
        int amarillas = 0;

        for (Evento e : this.partido.getEventos()) {
            if (e.getTipo() == TipoEvento.TARJETA_AMARILLA || e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                if (e.getJugador().getSeleccion() == this.seleccion) {
                    amarillas++;
                }
            }
        }

        return amarillas;
    }

    public int cantidadTarjRojas() {
        int rojas = 0;

        for (Evento e : this.partido.getEventos()) {
            if (e.getTipo() == TipoEvento.TARJETA_ROJA || e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                if (e.getJugador().getSeleccion() == this.seleccion) {
                    rojas++;
                }
            }
        }

        return rojas;
    }
}