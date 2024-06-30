package Domain.PlanesDePago;

import Domain.Venta;

public class PlanAhorro implements IPlanPagos {
    @Override
    public void ejecutarPlanPagos(Venta venta) {
        double precioVehiculo = venta.getVehiculo().getPrecio();
        double pagoInicial = precioVehiculo * 0.5;
        double restante = precioVehiculo - pagoInicial;

        venta.setPrecioFinal(precioVehiculo);
        venta.setMetodoDePago(getName());

        Integer[] cuotas = new Integer[65]; // 1 pago inicial + 64 cuotas
        cuotas[0] = (int) pagoInicial;
        int pagoMensual = (int) (restante / 64);
        for (int i = 1; i <= 64; i++) {
            cuotas[i] = pagoMensual;
        }
        venta.setPlanCuotas(cuotas);
    }

    @Override
    public boolean condicion(Venta venta) {
        return true;
    }

    @Override
    public String getName() {
        return "Plan Ahorro";
    }
}
