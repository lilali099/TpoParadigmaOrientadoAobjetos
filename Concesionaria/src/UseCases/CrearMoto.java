package UseCases;

import Domain.Concesionaria;
import Domain.Moto;
import Utils.IOpcionMenuSeleccionable;

public class CrearMoto implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concesionaria concesionaria) {
        Moto moto = Moto.create();

        if (moto != null) {
            concesionaria.getVehiculos().add(moto);
            moto.mostrarDetalle();
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Moto";
    }
}
