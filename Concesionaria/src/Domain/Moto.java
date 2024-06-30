package Domain;

import Utils.InputFile;

import java.util.function.Predicate;

public class Moto extends Vehiculo{
    private String tipoMoto;
    private int cilindrada;

    protected Moto() {

    }
    public int getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    public String getTipoMoto() {
        return tipoMoto;
    }
    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public static Moto create(){
        Moto moto = new Moto();

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
        moto.setAnio(anio);

        String tipoMoto = InputFile.obtenerDatoString("el tipo de moto");
        if (tipoMoto == null) {
            return null;
        }
        moto.setTipoMoto(tipoMoto);

        Predicate<String> validacionPositivo = input -> {
            try {
                return Integer.parseInt(input) > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Integer cilindrada = InputFile.obtenerDatoInteger("la cilindrada","No puede ser negativo o 0", validacionPositivo);
        if (cilindrada == null) {
            return null;
        }
        moto.setCilindrada(cilindrada);

        String color = InputFile.obtenerDatoString("el color");
        if (color == null) {
            return null;
        }
        moto.setColor(color);

        String marca  = InputFile.obtenerDatoString("la marca");
        if (marca == null) {
            return null;
        }
        moto.setMarca(marca);

        String modelo = InputFile.obtenerDatoString("el modelo");
        if (modelo == null) {
            return null;
        }
        moto.setModelo(modelo);

        String patente = InputFile.obtenerDatoString("la patente");
        if (patente == null) {
            return null;
        }
        moto.setPatente(patente);

        Integer km = InputFile.obtenerDatoInteger("el kilometraje","No puede ser negativo o 0", validacionPositivo);
        if (km == null) {
            return null;
        }
        moto.setKm(km);

        Double precio = InputFile.obtenerDatoDouble("el precio","No puede ser negativo o 0", validacionPositivo);
        if (precio == null) {
            return null;
        }
        moto.setPrecio(precio);

        return moto;
    }

    @Override
    public String getDataTableRecord() {
        return "Tipo: Moto, Marca: "+ getMarca() +", Modelo: "+ getModelo() + ", Año: "+ getAnio() + ", Color: "+ getColor()+ ",Precio: "+ getPrecio();

    }

    @Override
    public void mostrarDetalle() {
        System.out.println ("Detalles de la moto");
        System.out.println ("Color: " +getColor());
        System.out.println ("Marca: " +getMarca());
        System.out.println ("Modelo: " +getModelo());
        System.out.println ("Año: " + getAnio());
        System.out.println ("Patente: " +getPatente());
        System.out.println ("Kilometros: " +getKm());
        System.out.println("Tipo de moto" + getTipoMoto());
        System.out.println("Cantidad de CC" + getCilindrada());
        System.out.println ("Precio: " +getPrecio());
    }
}
