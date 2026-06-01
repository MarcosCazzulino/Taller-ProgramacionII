public class Jugador extends Persona {
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private Seleccion seleccion;

    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura, Seleccion seleccion) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.seleccion = seleccion;
    }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public Posicion getPosicion() { return posicion; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public float getAltura() { return altura; }
    public void setAltura(float altura) { this.altura = altura; }

    public Seleccion getSeleccion() { return seleccion; }
    public void setSeleccion(Seleccion seleccion) { this.seleccion = seleccion; }
}