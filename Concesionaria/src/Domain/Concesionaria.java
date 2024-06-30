package Domain;

import java.util.HashSet;

public class Concesionaria {
    private HashSet<Vehiculo> vehiculos = new HashSet<>();
    private HashSet<Venta> ventas = new HashSet<>();

    public HashSet<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public HashSet<Venta> getVentas() {
        return ventas;
    }
}
