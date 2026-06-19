public class CuerpoTecnico extends Persona {
    private Rol rol;

    public CuerpoTecnico() {
        super("", 0);
        this.rol = null;
    }

    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    public Rol getRol() { return this.rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}