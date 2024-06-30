package UseCases;

import Domain.Concecionaria;
import Domain.Moto;
import Utils.IOpcionMenuSeleccionable;

public class CrearMoto implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {
        Moto moto = Moto.create();

        if (moto != null) {
            concecionaria.getVehiculos().add(moto);
            moto.mostrarDetalle();
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Moto";
    }
}
