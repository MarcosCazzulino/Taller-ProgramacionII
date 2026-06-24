import java.util.ArrayList;
import java.util.List;

public class Jugador extends Persona {
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private List<Evento> eventos;

    public Jugador(){ this("", 0, 0, null, 0, 0); }

    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<Evento>();
    }

    public int getDorsal() { return dorsal; }
    public void setDorsal(int dorsal) { this.dorsal = dorsal; }

    public Posicion getPosicion() { return posicion; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }

    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public float getAltura() { return altura; }
    public void setAltura(float altura) { this.altura = altura; }

    public List<Evento> getEventos(){ return this.eventos;}

    public void agregarEvento(Evento evento) {
        if (evento != null) {
            this.eventos.add(evento);
            if (evento.getJugador() != this) {
                evento.setJugador(this);
            }
        }
    }

    public void informeDiscJugador(){
        int amarillas=0, rojas=0;
        for (Evento e: this.eventos){
            if (e.getTipo()==TipoEvento.TARJETA_AMARILLA || e.getTipo()==TipoEvento.DOBLE_AMARILLA){
                amarillas++;
            } else if (e.getTipo()==TipoEvento.TARJETA_ROJA) {
                rojas++;
            }
        }
        System.out.println(this.getNombre() + ":");
        if (amarillas>0){
            System.out.println("Tiene " + amarillas + " tarjetas amarillas.");
        } else {
            System.out.println("No tiene tarjetas amarillas.");
        }
        if (rojas>0){
            System.out.println("Tiene " + rojas + " tarjetas rojas");
        } else {
            System.out.println("No tiene tarjetas rojas.");
        }
    }
}