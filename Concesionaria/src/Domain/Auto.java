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

        Integer chasis = InputFile.obtenerDato("chasis", Integer.class);
        if (chasis == null) {
            return null;
        }
        auto.setChasis(chasis);

        Integer cantidadDePuertas = InputFile.obtenerDato("cantidad de puertas", Integer.class);
        if (cantidadDePuertas == null) {
            return null;
        }
        auto.setCantidadDePuertas(cantidadDePuertas);

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
