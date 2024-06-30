package Domain.PlanesDePago;

import Domain.Venta;

public class PagoContado implements IPlanPagos {
    @Override
    public void ejecutarPlanPagos(Venta venta) {
        double precioFinal = venta.getVehiculo().getPrecio();
        venta.setPrecioFinal(precioFinal);
        venta.setMetodoDePago(getName());
        venta.setEntregado(true);
        venta.setPlanCuotas(new Integer[]{(int) precioFinal});
    }

    @Override
    public boolean condicion(Venta venta) {
        return true;
    }

    @Override
    public String getName() {
        return "Pago al Contado";
    }
}

