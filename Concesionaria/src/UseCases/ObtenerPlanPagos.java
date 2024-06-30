package UseCases;

import Domain.*;
import Domain.PlanesDePago.PagoContado;
import Domain.PlanesDePago.PlanAhorro;
import Domain.PlanesDePago.PlanMotoDeportiva;
import Domain.PlanesDePago.PlanSedan;
import Utils.IOpcionFiltradoSeleccionable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ObtenerPlanPagos {

    public static Venta execute(Venta venta) {
        String opcion = "";
        while (true) {
            List<IPlanPagos> planesPago = new ArrayList<>(){};

            planesPago.add(new PagoContado());
            planesPago.add(new PlanAhorro());
            planesPago.add(new PlanMotoDeportiva());
            planesPago.add(new PlanSedan());

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
        System.out.print("Ingrese el número de la opción: ");
        return lectura.nextLine();
    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
