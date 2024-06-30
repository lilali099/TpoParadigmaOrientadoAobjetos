package Domain.PlanesDePago.;

public class PagoContado implements IPlanPagos {
    @Override
    public void ejecutarPlanPagos(Venta venta) {
        double precioFinal = venta.getVehiculo().getPrecio();
        venta.setPrecioFinal(precioFinal);
        venta.setMetodoDePago("Pago al Contado");

        venta.setPlanCuotas(new Integer[]{(int) precioFinal});
    }

    @Override
    public boolean condicion(Venta venta) {
        return true;
    }
}

