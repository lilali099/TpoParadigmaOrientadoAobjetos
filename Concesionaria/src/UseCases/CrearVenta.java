package UseCases;

import Domain.Concesionaria;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

public class CrearVenta implements IOpcionMenuSeleccionable {
    @Override
    public void execute(Concesionaria concesionaria) {
        System.out.println("Generar Venta");
        Venta venta = Venta.create(concesionaria.getVehiculos().stream().toList());

        if (venta != null) {
            concesionaria.getVentas().add(venta);
            concesionaria.getVehiculos().remove(venta.getVehiculo());
            venta.mostrarDetalle();
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Generar Nueva Venta";
    }
}
