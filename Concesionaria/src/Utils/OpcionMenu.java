package Utils;

import java.util.List;
import java.util.Scanner;

public class OpcionMenu {
    public static void EjecutarMenu(String menuTitulo, List<IOpcionMenuSeleccionable> menuSeleccionableList){
        Scanner lectura = new Scanner(System.in);
        if (menuSeleccionableList.isEmpty()){
            return;
        }
        //se mantiene como texto para luego convertirlo a numero para poder mostrarlo en caso de que se equivoque
        String opcion = "";
        while (true){
            try {
                System.out.println(menuTitulo);
                System.out.println("Selecciona una opción: ");
                int menuOpcion = 1;
                for (IOpcionMenuSeleccionable menuSeleccionable : menuSeleccionableList) {
                    System.out.println(menuOpcion + ")" + menuSeleccionable.TituloMenuSeleccioble());
                    menuOpcion++;
                }

                System.out.println("Ingrese el numero de la opción: ");
                opcion = lectura.nextLine();

                int numero = Integer.parseInt(opcion);

                if (numero <= menuSeleccionableList.size()){
                    menuSeleccionableList.get(numero - 1).Execute();
                    break;
                }
                else{
                    System.out.println(datoInvalido(opcion));
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(opcion));
            }
        }
    }

    private static String datoInvalido(String value){
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
