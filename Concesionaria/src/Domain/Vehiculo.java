package Domain;

public abstract class Vehiculo {
    private String color;
    private String marca;
    private String modelo;
    private int anio;
    private String patente;
    private int km;
    private double precio;

    /*
    public Vehiculo(String color, String marca, String modelo, int anio, String patente, int km, double precio) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.km = km;
        this.precio = precio;
    }*/
    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public int getKm() {
        return km;
    }

    public double getPrecio() {
        return precio;
    }

    public String getPatente (){return patente;}

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract void mostrarDetalle ();


}

