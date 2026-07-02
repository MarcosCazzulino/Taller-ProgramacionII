import java.util.ArrayList;
/**
 * Crea las sedes de los partidos del mundial
 */
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

    //Metodo para saber la capacidad total para de una sede
    public int capacidadSede(){
        int totalCapacidad=0;
        for(Estadio estad: estadios){
            totalCapacidad+=estad.getCapacidad();
        }
        return totalCapacidad;
    }
    //Metodo para saber la cantidad de partidos por ciudad;
    public int cantidadPartidosPorCiudad(){
        int cantidadPartidos=0;
        for(Estadio estad: estadios){
            cantidadPartidos+=estad.cantidadPartidos();
        }
        return cantidadPartidos;
    }
}
