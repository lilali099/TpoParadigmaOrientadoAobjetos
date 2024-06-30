package UseCases;

import Domain.Concecionaria;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

public class GenerarVentasMenu implements IOpcionMenuSeleccionable {
    @Override
    public void execute(Concecionaria concecionaria) {
        System.out.println("Generar Venta");
        Venta venta = Venta.create();

        if (venta != null) {
            concecionaria.getTransacciones().add(venta);
        }
        //mostrar venta
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Generar Nueva Venta";
    }
}
