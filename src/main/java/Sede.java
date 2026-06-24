import java.util.ArrayList;

public class Sede {
    public Pais pais;
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private ArrayList<Estadio> estadios;

    public Sede(Pais pais, String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.estadios= new ArrayList<Estadio>();
        this.pais = pais;
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
    }

    public void setEstadios(ArrayList<Estadio> estadios) { this.estadios = estadios; }
    public ArrayList<Estadio> getEstadios(){ return this.estadios; }
    public void agregarEstadio(Estadio estadio){ this.estadios.add(estadio); }
    //public int cantidadPartidos(){ return partidos.size(); }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public float getAlturaNivelMar() { return alturaNivelMar; }
    public void setAlturaNivelMar(float alturaNivelMar) { this.alturaNivelMar = alturaNivelMar; }

    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }

    public String getZonaHoraria() { return zonaHoraria; }
    public void setZonaHoraria(String zonaHoraria) { this.zonaHoraria = zonaHoraria; }

    public void setPais(Pais pais) { this.pais= pais; }
    public Pais getPais() { return this.pais; }
}