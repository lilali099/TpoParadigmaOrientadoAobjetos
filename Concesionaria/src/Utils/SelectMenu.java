package Utils;

import Domain.Concecionaria;

import java.util.List;
import java.util.Scanner;

public class SelectMenu {
    public static void generarMenu(
            Concecionaria concecionaria,
            String menuTitulo,
            List<IOpcionMenuSeleccionable> menuSeleccionableList){
        generarMenu(concecionaria, menuTitulo, menuSeleccionableList, true);
    }

    public static void generarMenu(
            Concecionaria concecionaria,
            String menuTitulo,
            List<IOpcionMenuSeleccionable> menuSeleccionableList,
            boolean botonSalir)
    {
        if (menuSeleccionableList.isEmpty()){
            return;
        }
        Scanner lectura = new Scanner(System.in);
        //se mantiene como texto para luego convertirlo a numero para poder mostrarlo en caso de que se equivoque
        String opcion = "";
        while (true){
            try {
                System.out.println(menuTitulo);
                System.out.println("Selecciona una opción: ");
                int menuOpcion = 1;
                for (IOpcionMenuSeleccionable menuSeleccionable : menuSeleccionableList) {
                    System.out.println(menuOpcion + ")" + menuSeleccionable.tituloMenuSeleccioble());
                    menuOpcion++;
                }

                if (botonSalir){
                    System.out.println(menuOpcion + ")Volver");
                }

                System.out.println("Ingrese el numero de la opción: ");
                opcion = lectura.nextLine();

                int numero = Integer.parseInt(opcion);

                if (numero <= menuSeleccionableList.size()){
                    menuSeleccionableList.get(numero - 1).execute(concecionaria);
                    break;
                }
                else if (numero == menuSeleccionableList.size() + 1 && botonSalir){
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
