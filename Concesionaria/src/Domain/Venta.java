package Domain;

import Utils.IDataTableRecord;

public class Venta implements IDataTableRecord {
    private boolean entregado;
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

    public void setPlanCuotas(Integer[] planCuotas) {
        this.planCuotas = planCuotas;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public Integer[] getPlanCuotas() {
        return planCuotas;
    }

    public static Venta create(){
        return new Venta();
    }

    @Override
    public String getDataTableRecord() {
        return "Método de pago: "+ getMetodoDePago()+ ", Precio final:" + getPrecioFinal();
    }

    public void mostrarDetalle(){
        System.out.println ("Detalles de la venta");
        System.out.println("Método de pago: "+getMetodoDePago());
        System.out.println("Precio final:"+getPrecioFinal());
        System.out.println("Cuotas:" +getPlanCuotas());
        System.out.println("Comprador: "+getComprador());
        System.out.println("Vendedor: "+getVendedor());
        getVehiculo().mostrarDetalle();



    }
}

