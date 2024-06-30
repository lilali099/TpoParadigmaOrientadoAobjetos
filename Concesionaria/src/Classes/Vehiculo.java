package Classes;

public abstract class Vehiculo {
    String color;
    String marca;
    String modelo;
    int anio;
    String patente;
    int km;
    double precio;

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
}

