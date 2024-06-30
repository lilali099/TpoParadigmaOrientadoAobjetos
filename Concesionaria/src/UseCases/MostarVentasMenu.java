package UseCases;

import Domain.Auto;
import Domain.Concecionaria;
import Domain.Moto;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

import java.util.*;
import java.util.stream.Collectors;

public class MostarVentasMenu implements IOpcionMenuSeleccionable {

    private enum Filtro {
        TODOS, AUTOS, MOTOS, ENTREGADOS
    }

    private enum Ordenamiento {
        PRECIO_ASC, PRECIO_DESC, CLIENTE_ASC, CLIENTE_DESC
    }

    private Scanner lectura = new Scanner(System.in);
    private Filtro filtroActual = Filtro.TODOS;
    private Ordenamiento ordenamientoActual = null;

    @Override
    public void execute(Concecionaria concecionaria) {
        while (true) {
            List<Venta> ventasFiltradas = aplicarFiltros(concecionaria.getTransacciones().stream().toList());
            ventasFiltradas = aplicarOrdenamiento(ventasFiltradas);

            mostrarVentas(ventasFiltradas);

            mostrarOpciones();
            String opcion = leerOpcion();
            int numero = Integer.parseInt(opcion);

            switch (numero) {
                case 1:
                    gestionarFiltros();
                    break;
                case 2:
                    gestionarOrdenamiento();
                    break;
                case 3:
                    mostrarDetalle();
                    break;
                case 4:
                    return; // Salir
                default:
                    System.out.println(datoInvalido(opcion));
                    break;
            }
        }
    }

    private List<Venta> aplicarFiltros(List<Venta> ventas) {
        switch (filtroActual) {
            case AUTOS:
                return ventas.stream().filter(v -> v.getVehiculo() instanceof Auto).collect(Collectors.toList());
            case MOTOS:
                return ventas.stream().filter(v -> v.getVehiculo() instanceof Moto).collect(Collectors.toList());
            case ENTREGADOS:
                return ventas.stream().filter(Venta::isEntregado).collect(Collectors.toList());
            case TODOS:
            default:
                return new ArrayList<>(ventas);
        }
    }

    private List<Venta> aplicarOrdenamiento(List<Venta> ventas) {
        if (ordenamientoActual == null) {
            return ventas;
        }

        Comparator<Venta> comparator = null;
        switch (ordenamientoActual) {
            case PRECIO_ASC:
                comparator = Comparator.comparing(Venta::getPrecioFinal);
                break;
            case PRECIO_DESC:
                comparator = Comparator.comparing(Venta::getPrecioFinal).reversed();
                break;
            case CLIENTE_ASC:
                comparator = Comparator.comparing(Venta::getComprador);
                break;
            case CLIENTE_DESC:
                comparator = Comparator.comparing(Venta::getComprador).reversed();
                break;
        }

        return ventas.stream().sorted(comparator).collect(Collectors.toList());
    }

    private void mostrarVentas(List<Venta> ventas) {
        System.out.println(GetTitulo());
        int contador = 1;
        for(Venta v : ventas) {
            mostrarVenta(v, contador);
            contador++;
        }
    }

    private void mostrarOpciones() {
        System.out.println("1) " + (filtroActual == Filtro.TODOS ? "Filtrar" : "Reiniciar Filtro"));
        System.out.println("2) " + (ordenamientoActual == null ? "Ordenar" : "Reiniciar Ordenamiento"));
        System.out.println("3) Mostrar Detalle");
        System.out.println("4) Volver");
    }

    private void gestionarFiltros() {
        if (filtroActual != Filtro.TODOS) {
            filtroActual = Filtro.TODOS;
        } else {
            System.out.println("1) Filtrar por Autos");
            System.out.println("2) Filtrar por Motos");
            System.out.println("3) Filtrar por Entregados");
            System.out.println("4) Volver");

            String opcion = leerOpcion();
            int numero = Integer.parseInt(opcion);

            switch (numero) {
                case 1:
                    filtroActual = Filtro.AUTOS;
                    break;
                case 2:
                    filtroActual = Filtro.MOTOS;
                    break;
                case 3:
                    filtroActual = Filtro.ENTREGADOS;
                    break;
                case 4:
                    break;
                default:
                    System.out.println(datoInvalido(opcion));
                    break;
            }
        }
    }

    private void gestionarOrdenamiento() {
        if (ordenamientoActual != null) {
            ordenamientoActual = null;
        } else {
            System.out.println("1) Ordenar por precio ASC");
            System.out.println("2) Ordenar por precio DESC");
            System.out.println("3) Ordenar por cliente ASC");
            System.out.println("4) Ordenar por cliente DESC");

            String opcion = leerOpcion();
            int numero = Integer.parseInt(opcion);

            switch (numero) {
                case 1:
                    ordenamientoActual = Ordenamiento.PRECIO_ASC;
                    break;
                case 2:
                    ordenamientoActual = Ordenamiento.PRECIO_DESC;
                    break;
                case 3:
                    ordenamientoActual = Ordenamiento.CLIENTE_ASC;
                    break;
                case 4:
                    ordenamientoActual = Ordenamiento.CLIENTE_DESC;
                    break;
                default:
                    System.out.println(datoInvalido(opcion));
                    break;
            }
        }
    }

    private void mostrarDetalle() {
        // Implementa la lógica para mostrar el detalle de una venta
    }

    private String GetTitulo() {
        String titulo = "Menu Ventas";
        if (filtroActual != Filtro.TODOS) {
            titulo += ", filtrado por " + filtroActual.name();
        }
        if (ordenamientoActual != null) {
            titulo += ", ordenado por " + ordenamientoActual.name();
        }
        return titulo;
    }

    private String leerOpcion() {
        System.out.print("Ingrese el numero de la opción: ");
        return lectura.nextLine();
    }

    private void mostrarVenta(Venta venta, int numero) {
        // Implementa la lógica para mostrar la venta de forma resumida
    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Ventas";
    }
}
