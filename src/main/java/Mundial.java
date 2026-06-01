import java.util.ArrayList;
import java.util.List;

public class Mundial {
    private Sede sede;
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private List<Sede> sedes;
    private List<Grupo> grupos;

    Mundial(Sede sede, int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.sede = sede;
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<Sede>();
        this.grupos = new ArrayList<Grupo>();
    }

    int getAnio() { return anio; }
    void setAnio(int anio) { this.anio = anio; }

    Sede getSede() { return sede; }
    void setSede(Sede sede) { this.sede = sede; }

    String getMascota() { return mascota; }
    void setMascota(String mascota) { this.mascota = mascota; }

    int getFechaDesde() { return fechaDesde; }
    void setFechaDesde(int fechaDesde) { this.fechaDesde = fechaDesde; }

    int getFechaHasta() { return fechaHasta; }
    void setFechaHasta(int fechaHasta) { this.fechaHasta = fechaHasta; }
}
