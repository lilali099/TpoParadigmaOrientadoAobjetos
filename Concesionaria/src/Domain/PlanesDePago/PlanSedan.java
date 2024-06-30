package Domain.PlanesDePago.;

import Domain.Auto;
import Domain.IPlanPagos;
import Domain.Moto;
import Domain.Venta;

public class PlanSedan implements IPlanPagos {
    @Override
    public void ejecutarPlanPagos(Venta venta) {
        double precioVehiculo = venta.getVehiculo().getPrecio();
        double pagoInicial = precioVehiculo * 0.4;
        double restante = precioVehiculo - pagoInicial;

        venta.setPrecioFinal(precioVehiculo);
        venta.setMetodoDePago("Plan Sedan");

        Integer[] cuotas = new Integer[19]; // 1 pago inicial + 18 cuotas
        cuotas[0] = (int) pagoInicial;
        int pagoMensual = (int) (restante / 18);
        for (int i = 1; i <= 18; i++) {
            cuotas[i] = pagoMensual;
        }
        venta.setPlanCuotas(cuotas);
    }

    @Override
    public boolean condicion(Venta venta) {
        return venta.getVehiculo() instanceof Auto;
    }
}
