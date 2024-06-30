package Domain;

import Utils.InputFile;

public class Moto extends Vehiculo{

    private int cilindrada;

    /*
    public Moto(String color, String marca, String modelo, int anio, String patente, int km, double precio, int cilindrada) {
        super(color, marca, modelo, anio, patente, km, precio);
        this.cilindrada = cilindrada;
    }*/

    protected Moto() {

    }

    public int getCilindrada() {
        return cilindrada;
    }

    public static Moto create(){
        Moto moto = new Moto();

        Integer anio = InputFile.obtenerDato("año:", Integer.class);
        if (anio == null) {
            return null;
        }
        moto.anio = anio;

        //completar con todas las propiedades

        return moto;
    }
}
