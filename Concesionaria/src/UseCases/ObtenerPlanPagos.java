package UseCases;

import Domain.*;
import Domain.PlanesDePago.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObtenerPlanPagos {

    private static boolean primeraVez;
    public static Venta execute(Venta venta) {
        String opcion = "";
        primeraVez = true;
        while (true) {
            List<IPlanPagos> planesPago = new ArrayList<>(){};

            planesPago.add(new PagoContado());
            planesPago.add(new PlanAhorro());
            planesPago.add(new PlanMotoDeportiva());
            planesPago.add(new PlanSedan());

            planesPago = planesPago.stream().filter(x -> x.condicion(venta)).toList();

            mostrarPlanes(planesPago);

            System.out.println("Selecciona una plan de Pago: ");

            try {
                opcion = leerOpcion();
                if (opcion.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }

                int numero = Integer.parseInt(opcion);
                if (0 < numero && numero <= planesPago.size()) {
                    planesPago.get(numero-1).ejecutarPlanPagos(venta);
                    return venta;
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

    private static void mostrarPlanes(List<IPlanPagos> planesPago) {
        System.out.println("Planes de Pago Disponibles");
        int contador = 1;
        for(IPlanPagos p : planesPago) {
            System.out.println(contador +") "+ p.getName());
            contador++;
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

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
