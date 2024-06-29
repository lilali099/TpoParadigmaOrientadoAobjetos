package Classes;

public class Transaccion {
    public boolean entregado;
    private String metodoDePago;
    public boolean accionDeVehiculo;
    private Vehiculo vehiculo;
    private MediosDePago mediosDePago;
    private String comprador;
    private String vendedor;

    public Transaccion(String metodoDePago, Vehiculo vehiculo, MediosDePago mediosDePago, String comprador, String vendedor) {
        this.metodoDePago = metodoDePago;
        this.vehiculo = vehiculo;
        this.mediosDePago = mediosDePago;
        this.comprador = comprador;
        this.vendedor = vendedor;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public MediosDePago getMediosDePago() {
        return mediosDePago;
    }

    public String getComprador() {
        return comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setMediosDePago(MediosDePago mediosDePago) {
        this.mediosDePago = mediosDePago;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}

