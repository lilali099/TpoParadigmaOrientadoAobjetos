package Classes;

public interface IPlanPagos {
    Integer[] obtenerPlanPagos(Vehiculo vehiculo);
    void aplicarPago(Vehiculo vehiculo);
}
