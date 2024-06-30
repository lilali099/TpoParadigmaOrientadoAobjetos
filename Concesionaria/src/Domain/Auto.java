package Domain;

import Utils.InputFile;

public class Auto extends Vehiculo{
    private int chasis;
    private int cantidadDePuertas;

    public void setcantidadDePuertas(int cantidadDePuertas) {
        this.cantidadDePuertas = cantidadDePuertas;
    }

    public void setChasis(int chasis) {
        this.chasis = chasis;
    }


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
        auto.setChasis(chasis);

        //completar con todas las propiedades

        Integer cantidadDePuertas = InputFile.obtenerDato("Ingrese la cantidad de puertas", Integer.class);
        if (cantidadDePuertas == null) {
            return null;
        }
        auto.setcantidadDePuertas(cantidadDePuertas);

        String color = InputFile.obtenerDato("Ingrese el color", String.class);
        if (color == null) {
            return null;
        }
        auto.setColor(color);

        String marca  = InputFile.obtenerDato("Ingrese la marca", String.class);
        if (marca == null) {
            return null;
        }
        auto.setMarca(marca);

        String modelo = InputFile.obtenerDato("Ingrese el modelo", String.class);
        if (modelo == null) {
            return null;
        }
        auto.setModelo(modelo);

        String patente = InputFile.obtenerDato("Ingrese la patente", String.class);
        if (patente == null) {
            return null;
        }
        auto.setPatente(patente);

        Integer anio = InputFile.obtenerDato("Ingrese el año", Integer.class);
        if (anio == null) {
            return null;
        }
        auto.setAnio(anio);

        Integer km = InputFile.obtenerDato("Ingrese el kilometraje", Integer.class);
        if (km == null) {
            return null;
        }
        auto.setKm(km);

        Double precio = InputFile.obtenerDato("Ingrese el precio", Double.class);
        if (precio == null) {
            return null;
        }
        auto.setPrecio(precio);



        return auto;
    }







}
