package UseCases;

import Domain.Concesionaria;
import Utils.IOpcionMenuSeleccionable;
import Utils.SelectMenu;

import java.util.LinkedList;
import java.util.List;

public class AñadirNuevoVehiculoMenu implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concesionaria concesionaria) {
        List<IOpcionMenuSeleccionable> opcionesMenuVentas = new LinkedList<>();
        opcionesMenuVentas.add(new CrearAuto());
        opcionesMenuVentas.add(new CrearMoto());

        SelectMenu.generarMenu(concesionaria,"Seleccionar Tipo de Vehículo", opcionesMenuVentas);
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Nuevo Vehículo";
    }
}
