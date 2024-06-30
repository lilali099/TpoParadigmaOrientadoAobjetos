import Domain.*;
import UseCases.*;
import Utils.IOpcionMenuSeleccionable;
import Utils.SelectMenu;

import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Concecionaria concecionaria = new Concecionaria();

        List<IOpcionMenuSeleccionable> opcionesMenuPrincipal = new LinkedList<>();
        opcionesMenuPrincipal.add(new AñadirNuevoVehiculoMenu());
        opcionesMenuPrincipal.add(new CrearVenta());
        opcionesMenuPrincipal.add(new MostarVentasMenu());
        opcionesMenuPrincipal.add(new MostrarCatalogoMenu());
        opcionesMenuPrincipal.add(new MostarInformeVentas());
        opcionesMenuPrincipal.add(new IOpcionMenuSeleccionable() {
            @Override
            public void execute(Concecionaria concecionaria) {
                System.out.println("Gracias por Utilizar");
                System.out.println("Programa Realizado por: ");
                System.out.println("Ingresar Nombres");
                System.exit(0);
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Terminar Programa";
            }
        });

        while (true){
            SelectMenu.generarMenu(concecionaria,"Menu Principal", opcionesMenuPrincipal, false);
        }
    }

}