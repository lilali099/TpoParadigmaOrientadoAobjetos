package Menus;

import Utils.IOpcionMenuSeleccionable;

public class GenerarVentasMenu implements IOpcionMenuSeleccionable {
    @Override
    public void Execute() {
        System.out.println("Generar Ventas");
    }

    @Override
    public String TituloMenuSeleccioble() {
        return "Generar Nueva Venta";
    }
}
