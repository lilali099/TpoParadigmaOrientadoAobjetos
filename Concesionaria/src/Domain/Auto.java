package Domain;

import Utils.InputFile;

import java.util.function.Predicate;

public class Auto extends Vehiculo{
    public String getChasis() {
        return chasis;
    }

    private String chasis;
    private int cantidadDePuertas;

    public void setCantidadDePuertas(int cantidadDePuertas) {
        this.cantidadDePuertas = cantidadDePuertas;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }


    protected Auto(){

    };

    public int getCantidadDePuertas() {
        return cantidadDePuertas;
    }

    public static Auto create(){
        Auto auto = new Auto();

        Predicate<String> validacionChasis = input -> !input.trim().isEmpty();
        String chasis = InputFile.obtenerDatoString("el chasis", "No puede estar vacio", validacionChasis);
        if (chasis == null) {
            return null;
        }
        auto.setChasis(chasis);

        Predicate<String> validacionPositivo = input -> {
            try {
                return Integer.parseInt(input) > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Integer cantidadDePuertas = InputFile.obtenerDatoInteger("la cantidad de puertas", "No puede ser negativo o 0", validacionPositivo);
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


        Predicate<String> validacionAño = input -> {
            try {
                return Integer.parseInt(input) > 1900 && Integer.parseInt(input) < 2024;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Integer anio = InputFile.obtenerDatoInteger("el año", "El año es incorrecto", validacionAño);
        if (anio == null) {
            return null;
        }
        auto.setAnio(anio);

        Integer km = InputFile.obtenerDatoInteger("el kilometraje", "No puede ser negativo o 0", validacionPositivo);
        if (km == null) {
            return null;
        }
        auto.setKm(km);

        Double precio = InputFile.obtenerDatoDouble("el precio", "No puede ser negativo o 0", validacionPositivo);
        if (precio == null) {
            return null;
        }
        auto.setPrecio(precio);

        return auto;
    }


    @Override
    public String getDataTableRecord() {
        return "Tipo: Auto, Marca: "+ getMarca() +", Modelo: "+ getModelo() +", Año: "+ getAnio() +", Color: "+ getColor()+ ", Precio: "+ getPrecio();
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
