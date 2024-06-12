public class Moto extends Vehiculo{

    private int cilindrada;

    public Moto(String color, String marca, String modelo, int anio, String patente, int km, double precio, int cilindrada) {
        super(color, marca, modelo, anio, patente, km, precio);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
