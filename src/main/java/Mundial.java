import java.util.ArrayList;
import java.util.List;

public class Mundial {
    private Sede sede;
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private List<Sede> sedes;

    public Mundial(Sede sede, int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.sede = sede;
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<Sede>();
    }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }

    public String getMascota() { return mascota; }
    public void setMascota(String mascota) { this.mascota = mascota; }

    public int getFechaDesde() { return fechaDesde; }
    public void setFechaDesde(int fechaDesde) { this.fechaDesde = fechaDesde; }

    public int getFechaHasta() { return fechaHasta; }
    public void setFechaHasta(int fechaHasta) { this.fechaHasta = fechaHasta; }

    public List<Sede> getSedes(){ return this.sedes; } 
    public void setSedes(List<Sede> sedes){ this.sedes= sedes; } 
}
