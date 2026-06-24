import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    private String bandera;
    private ArrayList<Arbitro> arbitros;
    private Seleccion seleccion;
    private List<Sede> sedes;

    public Pais(){ this("",""); }

    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this(nombre, bandera);
        this.seleccion = seleccion;
    }

    public Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.arbitros = new ArrayList<Arbitro>();
        this.sedes= new ArrayList<Sede>();
    }

    public String getBandera() { return bandera; }
    public void setBandera(String bandera) { this.bandera = bandera; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Arbitro> getArbitros(){ return arbitros; }
    public void setArbitros(ArrayList<Arbitro> arbitros){ this.arbitros= arbitros; }
    public void agregarArbitro( Arbitro arbitro){ arbitros.add(arbitro); }

    public void setSedes(List<Sede> sedes){ this.sedes= sedes; }
    public List<Sede> getSedes(){ return this.sedes; }
    public void agregarSede(Sede sede){ this.sedes.add(sede); }
}