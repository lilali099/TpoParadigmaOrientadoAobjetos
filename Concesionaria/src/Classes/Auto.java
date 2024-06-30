package Classes;

import Utils.InputFile;

public class Auto extends Vehiculo{
    private int chasis;
    private int cantidadDePuertas;

    protected Auto(){

    };
    /*
    public Auto(String color, String marca, String modelo, int anio, String patente, int km, double precio, int cantidadDePuertas) {
        super(color, marca, modelo, anio, patente, km, precio);
        this.cantidadDePuertas= cantidadDePuertas;
    }*/

    public int getCantidadDePuertas() {
        return cantidadDePuertas;
    }

    public void setCantidadDePuertas(int cantidadDePuertas) {
        this.cantidadDePuertas = cantidadDePuertas;
    }

    public static Auto create(){
        Auto auto = new Auto();

        Integer chasis = InputFile.obtenerDato("chasis:", Integer.class);
        if (chasis == null) {
            return null;
        }
        auto.chasis = chasis;

        //completar con todas las propiedades

        return auto;
    }
}
