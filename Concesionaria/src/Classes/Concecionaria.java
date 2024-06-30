package Classes;

import java.util.HashSet;

public class Concecionaria {
    private HashSet<Vehiculo> vehiculos = new HashSet<>();
    private HashSet<Venta> transacciones = new HashSet<>();

    public HashSet<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public HashSet<Venta> getTransacciones() {
        return transacciones;
    }
}
