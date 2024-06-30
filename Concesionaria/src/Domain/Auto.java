package Domain;

import Utils.InputFile;

public class Auto extends Vehiculo{
    public int getChasis() {
        return chasis;
    }

    private int chasis;
    private int cantidadDePuertas;

    public void setCantidadDePuertas(int cantidadDePuertas) {
        this.cantidadDePuertas = cantidadDePuertas;
    }

    public void setChasis(int chasis) {
        this.chasis = chasis;
    }


    protected Auto(){

    };

    public int getCantidadDePuertas() {
        return cantidadDePuertas;
    }

    public static Auto create(){
        Auto auto = new Auto();

        Integer chasis = InputFile.obtenerDatoInteger("chasis");
        if (chasis == null) {
            return null;
        }
        auto.setChasis(chasis);

        Integer cantidadDePuertas = InputFile.obtenerDatoInteger("cantidad de puertas");
        if (cantidadDePuertas == null) {
            return null;
        }
        auto.setCantidadDePuertas(cantidadDePuertas);

        String color = InputFile.obtenerDatoString("el color");
        if (color == null) {
            return null;
        }
        auto.setColor(color);

        String marca  = InputFile.obtenerDatoString("la marca");
        if (marca == null) {
            return null;
        }
        auto.setMarca(marca);

        String modelo = InputFile.obtenerDatoString("el modelo");
        if (modelo == null) {
            return null;
        }
        auto.setModelo(modelo);

        String patente = InputFile.obtenerDatoString("la patente");
        if (patente == null) {
            return null;
        }
        auto.setPatente(patente);

        Integer anio = InputFile.obtenerDatoInteger("el año");
        if (anio == null) {
            return null;
        }
        auto.setAnio(anio);

        Integer km = InputFile.obtenerDatoInteger("el kilometraje");
        if (km == null) {
            return null;
        }
        auto.setKm(km);

        Double precio = InputFile.obtenerDatoDouble("el precio");
        if (precio == null) {
            return null;
        }
        auto.setPrecio(precio);

        return auto;
    }


    @Override
    public String getDataTableRecord() {
        return "";
    }

    @Override
    public void mostrarDetalle() {
        System.out.println ("Detalles del auto");
        System.out.println("Chasis: "+getChasis());
        System.out.println ("Color: " +getColor());
        System.out.println ("Marca: " +getMarca());
        System.out.println ("Modelo: " +getModelo());
        System.out.println ("Año: " + getAnio());
        System.out.println ("Patente: " +getPatente());
        System.out.println ("Kilometros: " +getKm());
        System.out.println ("Precio: " +getPrecio());
        System.out.println ("Cantidad de puertas: " +getCantidadDePuertas());
    }
}
