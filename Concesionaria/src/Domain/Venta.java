package Domain;

import UseCases.ObtenerVehiculo;
import Utils.IDataTableRecord;

import java.util.List;

public class Venta implements IDataTableRecord {
    public boolean entregado;
    private String metodoDePago;
    private double precioFinal;

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

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

    public static Venta create(List<Vehiculo> vehiculoList){
        Venta venta = new Venta();

        int vehiculoNumero = ObtenerVehiculo.execute(vehiculoList);
        if (vehiculoNumero == -1) {
            return null;
        }
        venta.setVehiculo(vehiculoList.get(vehiculoNumero));

        return venta;
    }

    @Override
    public String getDataTableRecord() {
        return "";
    }

    public void mostrarDetalle(){

    }
}

