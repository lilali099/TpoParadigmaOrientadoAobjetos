package UseCases;

import Domain.Concesionaria;
import Utils.IOpcionMenuSeleccionable;

public class EntregarVehiculo implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concesionaria concesionaria) {

    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Entregar Vehiculo";
    }
}
