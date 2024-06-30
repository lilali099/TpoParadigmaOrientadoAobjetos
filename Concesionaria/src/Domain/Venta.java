package Domain;

import UseCases.ObtenerVehiculo;
import Utils.IDataTableRecord;
import Utils.InputFile;

import java.util.List;

public class Venta implements IDataTableRecord {
    private boolean entregado;
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

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
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
        String comprador = InputFile.obtenerDatoString("Ingrese el nombre del comprador");
        if (comprador == null) {
            return null;
        }
        venta.setComprador(comprador);        venta.setVehiculo(vehiculoList.get(vehiculoNumero));
        String vendedor = InputFile.obtenerDatoString("Ingrese el nombre del vendedor");
        if (vendedor == null) {
            return null;
        }
        venta.setVendedor(vendedor);

        return venta;
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

