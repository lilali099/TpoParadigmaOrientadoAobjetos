package UseCases;

import Domain.Concecionaria;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

public class CrearVenta implements IOpcionMenuSeleccionable {
    @Override
    public void execute(Concecionaria concecionaria) {
        System.out.println("Generar Venta");
        Venta venta = Venta.create(concecionaria.getVehiculos().stream().toList());

        if (venta != null) {
            concecionaria.getVentas().add(venta);
            concecionaria.getVehiculos().remove(venta.getVehiculo());
            venta.mostrarDetalle();
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Generar Nueva Venta";
    }
}
