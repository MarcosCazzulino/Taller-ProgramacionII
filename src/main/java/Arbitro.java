public class Arbitro extends Persona {
    private int aniosExperiencia;
    // Lista de arbitrajes
    // País

    public Arbitro() {
        super("", 0);
        this.aniosExperiencia = 0;
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
}
