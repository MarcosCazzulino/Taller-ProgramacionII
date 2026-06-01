public class Sede {
    public Pais pais;
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;

    Sede(Pais pais, String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
    }

    String getCiudad() { return ciudad; }
    void setCiudad(String ciudad) { this.ciudad = ciudad; }

    float getAlturaNivelMar() { return alturaNivelMar; }
    void setAlturaNivelMar(float alturaNivelMar) { this.alturaNivelMar = alturaNivelMar; }

    String getClima() { return clima; }
    void setClima(String clima) { this.clima = clima; }

    String getZonaHoraria() { return zonaHoraria; }
    void setZonaHoraria(String zonaHoraria) { this.zonaHoraria = zonaHoraria; }
}
