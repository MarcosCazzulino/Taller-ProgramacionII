public abstract class Persona {
    private String nombre;
    private int fecNacimiento;

    Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    String getNombre() { return nombre; }
    void setNombre(String nombre) { this.nombre = nombre; }

    int getFecNacimiento() { return fecNacimiento; }
    void setFecNacimiento(int fecNacimiento) { this.fecNacimiento = fecNacimiento; }
}