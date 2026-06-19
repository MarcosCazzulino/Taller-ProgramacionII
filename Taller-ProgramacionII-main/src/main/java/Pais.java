import java.util.ArrayList;
import java.util.List;
public class Pais {
    private String nombre;
    private String bandera;
    private ArrayList<Arbitro> arbitros;
    // Lista de árbitros

    public Pais(String nombre, String bandera) {

        this.arbitros = new ArrayList<Arbitro>();
        this.nombre = nombre;
        this.bandera = bandera;
    }

    public String getBandera() { return bandera; }
    public void setBandera(String bandera) { this.bandera = bandera; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Arbitro> getArbitros(){
        return arbitros;
    }
    public void agregarArbitro( Arbitro arbitro){
        arbitros.add(arbitro);
    }
}
//a