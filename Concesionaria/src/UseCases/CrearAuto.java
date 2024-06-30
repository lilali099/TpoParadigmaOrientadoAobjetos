package UseCases;

import Domain.Concesionaria;
import Domain.Auto;
import Utils.IOpcionMenuSeleccionable;

public class CrearAuto implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concesionaria concesionaria) {
        Auto auto = Auto.create();

        if (auto != null) {
            concesionaria.getVehiculos().add(auto);
            auto.mostrarDetalle();
        }
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Auto";
    }
}
