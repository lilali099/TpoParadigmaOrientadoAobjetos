package Domain;

import Utils.InputFile;

public class Moto extends Vehiculo{
    private int tipoMoto;
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
    public int getTipoMoto() {
        return tipoMoto;
    }
    public void setTipoMoto(int tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public static Moto create(){
        Moto moto = new Moto();

        Integer anio = InputFile.obtenerDato("el Año", Integer.class);
        if (anio == null) {
            return null;
        }
        moto.setAnio(anio);

        //completar con todas las propiedades
        Integer tipoMoto = InputFile.obtenerDato("el Tipo de moto", Integer.class);
        if (tipoMoto == null) {
            return null;
        };
        moto.setTipoMoto(tipoMoto);

        Integer cilindrada = InputFile.obtenerDato("la Cilindrada", Integer.class);
        if (cilindrada == null) {
            return null;
        };
        moto.setCilindrada(cilindrada);

        String color = InputFile.obtenerDato("el Color", String.class);
        if (color == null) {
            return null;
        };
        moto.setColor(color);

        String marca  = InputFile.obtenerDato("la Marca", String.class);
        if (marca == null) {
            return null;
        };
        moto.setMarca(marca);

        String modelo = InputFile.obtenerDato("el Modelo", String.class);
        if (modelo == null) {
            return null;
        };
        moto.setModelo(modelo);

        String patente = InputFile.obtenerDato("la Patente", String.class);
        if (patente == null) {
            return null;
        };
        moto.setPatente(patente);

        Integer km = InputFile.obtenerDato("el Kilometraje", Integer.class);
        if (km == null) {
            return null;
        };
        moto.setKm(km);

        Double precio = InputFile.obtenerDato("el Precio", Double.class);
        if (precio == null) {
            return null;
        }
        moto.setPrecio(precio);

        return moto;
    }

    @Override
    public String getDataTableRecord() {
        return "Tipo: Moto, Marca: "+ getMarca() +", Modelo: "+ getModelo() + ", Año: "+ getAnio() + ", Color: "+ getColor();

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
