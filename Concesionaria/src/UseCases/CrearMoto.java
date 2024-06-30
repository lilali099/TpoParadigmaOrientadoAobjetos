package UseCases;

import Classes.Concecionaria;
import Classes.Moto;
import Classes.Vehiculo;
import Utils.IOpcionMenuSeleccionable;

import java.util.HashSet;

public class CrearMoto implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {
        Moto moto = Moto.create();

        if (moto != null) {
            concecionaria.getVehiculos().add(moto);
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Moto";
    }
}
