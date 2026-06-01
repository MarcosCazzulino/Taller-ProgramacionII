public class Arbitraje {
    private CategoriaArbitro rol;
    private Partido partido;
    private Arbitro arbitro;

    public Arbitraje() {
        this(CategoriaArbitro.PRINCIPAL, null, null);
    }

    public Arbitraje(CategoriaArbitro rol, Partido partido, Arbitro arbitro) {
        this.rol = rol;
        this.partido = partido;
        this.arbitro = arbitro;
    }

    public CategoriaArbitro getRol() { return rol; }
    public void setRol(CategoriaArbitro rol) { this.rol = rol; }

    public Partido getPartido() { return partido; }
    public void setPartido(Partido partido) { this.partido = partido; }

    public Arbitro getArbitro() { return arbitro; }
    public void setArbitro(Arbitro arbitro) { this.arbitro = arbitro; }
}