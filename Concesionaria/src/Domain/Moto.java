package Domain;

import Utils.InputFile;

public class Moto extends Vehiculo{
    private String tipoMoto;
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

        Integer anio = InputFile.obtenerDatoInteger("Año");
        if (anio == null) {
            return null;
        }
        moto.setAnio(anio);

        //completar con todas las propiedades
        String tipoMoto = InputFile.obtenerDatoString("Tipo de moto");
        if (tipoMoto == null) {
            return null;
        };
        moto.setTipoMoto(tipoMoto);

        Integer cilindrada = InputFile.obtenerDatoInteger("Cilindrada de la moto");
        if (cilindrada == null) {
            return null;
        };
        moto.setCilindrada(cilindrada);

        String color = InputFile.obtenerDatoString("Color");
        if (color == null) {
            return null;
        };
        moto.setColor(color);

        String marca  = InputFile.obtenerDatoString("Marca");
        if (marca == null) {
            return null;
        };
        moto.setMarca(marca);

        String modelo = InputFile.obtenerDatoString("Modelo");
        if (modelo == null) {
            return null;
        };
        moto.setModelo(modelo);

        String patente = InputFile.obtenerDatoString("Patente");
        if (patente == null) {
            return null;
        };
        moto.setPatente(patente);

        Integer km = InputFile.obtenerDatoInteger("Kilometraje");
        if (km == null) {
            return null;
        };
        moto.setKm(km);

        Double precio = InputFile.obtenerDatoDouble("Precio");
        if (precio == null) {
            return null;
        }
        moto.setPrecio(precio);

        return moto;
    }

    @Override
    public String getDataTableRecord() {
        return "";
    }

    @Override
    public void mostrarDetalle() {

    }
}
