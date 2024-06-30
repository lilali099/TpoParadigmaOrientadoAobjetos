package Domain.PlanesDePago;

import Domain.IPlanPagos;
import Domain.Moto;
import Domain.Venta;

public class PlanMotoDeportiva implements IPlanPagos {
    @Override
    public void ejecutarPlanPagos(Venta venta) {
        double precioFinal = venta.getVehiculo().getPrecio();
        venta.setPrecioFinal(precioFinal);
        venta.setMetodoDePago(getName());

        Integer[] cuotas = new Integer[12];
        int pagoMensual = (int) (precioFinal / 12);

        for (int i = 0; i < 12; i++) {
            cuotas[i] = pagoMensual;
        }
        venta.setPlanCuotas(cuotas);
    }

    @Override
    public boolean condicion(Venta venta) {
        return venta.getVehiculo() instanceof Moto;
    }

    @Override
    public String getName() {
        return "Plan Moto Deportiva";
    }
}
