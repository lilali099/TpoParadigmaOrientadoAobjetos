package UseCases;

import Domain.Concecionaria;
import Domain.Auto;
import Utils.IOpcionMenuSeleccionable;

public class CrearAuto implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {
        Auto auto = Auto.create();

        if (auto != null) {
            concecionaria.getVehiculos().add(auto);
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Auto";
    }
}
