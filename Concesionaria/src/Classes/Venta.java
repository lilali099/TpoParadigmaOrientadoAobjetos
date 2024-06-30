package Classes;

public class Venta {
    public boolean entregado;
    private String metodoDePago;
    private double precioFinal;
    private Vehiculo vehiculo;
    private String comprador;
    private String vendedor;
    private Integer[] planCuotas;

    protected Venta(){

    }

    public boolean isEntregado() {
        return entregado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getComprador() {
        return comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public Integer[] getPlanCuotas() {
        return planCuotas;
    }

    public static Venta create(){
        return new Venta();
    }
}

