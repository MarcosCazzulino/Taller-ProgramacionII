public class Participacion {
    private boolean esLocal;
    private Partido partido;
    private Seleccion seleccion;

    public Participacion() {
        this.esLocal = false;
        this.partido = null;
        this.seleccion = null;
    }

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

    public int cantidadGoles() { return 0; }
    public int cantidadTarjAmarillas() { return 0; }
    public int cantidadTarjRojas() { return 0; }
}