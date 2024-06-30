package Domain;

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

        Integer cantidadDePuertas = InputFile.obtenerDato("cantidad de puertas:", Integer.class);
        if (cantidadDePuertas == null) {
            return null;
        }
        auto.cantidadDePuertas = cantidadDePuertas;

        String color = InputFile.obtenerDato("color", String.class);
        if (color == null) {
            return null;
        }
        auto.setColor(color);;

        String marca  = InputFile.obtenerDato("marca", String.class);
        if (marca == null) {
            return null;
        }
        auto.setMarca(marca);

        String modelo = InputFile.obtenerDato("modelo", String.class);
        if (modelo == null) {
            return null;
        }
        auto.setModelo(modelo);

        String patente = InputFile.obtenerDato("patent", String.class);
        if (patente == null) {
            return null;
        }
        auto.setPatente(patente);

        return auto;
    }







}
