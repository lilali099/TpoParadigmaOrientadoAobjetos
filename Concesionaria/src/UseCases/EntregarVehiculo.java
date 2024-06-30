package UseCases;

import Domain.Concecionaria;
import Utils.IOpcionMenuSeleccionable;

public class EntregarVehiculo implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {

    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Entregar Vehiculo";
    }
}
