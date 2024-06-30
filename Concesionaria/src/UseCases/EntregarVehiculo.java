package UseCases;

import Domain.Concesionaria;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntregarVehiculo implements IOpcionMenuSeleccionable {
    private static boolean primeraVez;
    @Override
    public void execute(Concesionaria concesionaria) {
        List<Venta> ventas = new ArrayList<>(concesionaria.getVentas().stream().filter(x -> !x.isEntregado()).toList());
        String opcion = "";
        primeraVez = true;
        while (true) {
            System.out.println("Entrega de Vehiculos");
            System.out.println("Ventas no Entregadas:");
            int contador = 1;
            for(Venta v : ventas) {
                System.out.println(contador +") "+ v.getDataTableRecord());
                contador++;
            }

            System.out.println("Selecciona una plan de Pago: ");

            try {
                opcion = leerOpcion();
                if (opcion.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return;
                }

                int numero = Integer.parseInt(opcion);
                if (0 < numero && numero <= ventas.size()) {
                    ventas.get(numero-1).setEntregado(true);
                    return;
                }
                else{
                    System.out.println(datoInvalido(opcion));
                }

            }
            catch (Exception e) {
                System.out.println(datoInvalido(opcion));
            }

        }
    }

    private static String leerOpcion() {
        Scanner lectura = new Scanner(System.in);
        if (primeraVez) {
            primeraVez = false;
        } else {
            System.out.println("Ingrese \"cancelar\" para finalizar la operación");
        }
        System.out.print("Ingrese el número de la opción: ");
        return lectura.nextLine();
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Entregar Vehiculo";
    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
