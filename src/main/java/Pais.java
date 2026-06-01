public class Pais {
    private String nombre;
    private String bandera;

    Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    String getBandera() { return bandera; }
    void setBandera(String bandera) { this.bandera = bandera; }

    String getNombre() { return nombre; }
    void setNombre(String nombre) { this.nombre = nombre; }
}