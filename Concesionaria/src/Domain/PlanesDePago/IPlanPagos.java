package Domain.PlanesDePago;

import Domain.Venta;

//modifica metodo de pago, precioFinal y el array de planCuotas
public interface IPlanPagos {
    void ejecutarPlanPagos(Venta venta);
    boolean condicion(Venta venta);
    String getName();
}
