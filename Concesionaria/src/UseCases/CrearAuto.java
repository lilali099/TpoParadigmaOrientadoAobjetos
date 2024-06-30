package UseCases;

import Classes.Concecionaria;
import Classes.Auto;
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
