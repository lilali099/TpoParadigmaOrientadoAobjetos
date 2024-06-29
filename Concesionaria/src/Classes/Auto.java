package Classes;

public class Auto extends Vehiculo{
    private int chasis;
    private int cantidadDePuertas;


    public Auto(String color, String marca, String modelo, int anio, String patente, int km, double precio, int cantidadDePuertas) {
        super(color, marca, modelo, anio, patente, km, precio);
        this.cantidadDePuertas= cantidadDePuertas;
    }

    public int getCantidadDePuertas() {
        return cantidadDePuertas;
    }

    public void setCantidadDePuertas(int cantidadDePuertas) {
        this.cantidadDePuertas = cantidadDePuertas;
    }
}
