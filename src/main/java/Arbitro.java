import java.util.ArrayList;
import java.util.List;

public class Arbitro extends Persona {
    private int aniosExperiencia;
    private Pais pais;
    private List<Arbitraje> arbitrajes;

    public Arbitro() {
        super("", 0);
        this.pais = null;
        this.aniosExperiencia = 0;
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        super(nombre, fecNacimiento);
        this.pais = pais;
        this.aniosExperiencia = aniosExperiencia;
        this.arbitrajes = new ArrayList<Arbitraje>();
    }

    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public void setArbitrajes(List<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }
}
