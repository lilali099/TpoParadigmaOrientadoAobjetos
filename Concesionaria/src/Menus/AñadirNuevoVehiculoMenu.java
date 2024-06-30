package Menus;

import Classes.Concecionaria;
import UseCases.CrearAuto;
import UseCases.CrearMoto;
import Utils.IOpcionMenuSeleccionable;
import Utils.SelectMenu;

import java.util.LinkedList;
import java.util.List;

public class AñadirNuevoVehiculoMenu implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {
        List<IOpcionMenuSeleccionable> opcionesMenuVentas = new LinkedList<>();
        opcionesMenuVentas.add(new CrearAuto());
        opcionesMenuVentas.add(new CrearMoto());

        SelectMenu.generarMenu(concecionaria,"Seleccionar Tipo de Vehiculo", opcionesMenuVentas);
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Añadir Nuevo Vehiculo";
    }
}
