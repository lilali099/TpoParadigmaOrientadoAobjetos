package UseCases;

import Domain.Auto;
import Domain.Concecionaria;
import Domain.Moto;
import Domain.Vehiculo;
import Utils.IOpcionFiltradoSeleccionable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ObtenerVehiculo {
    private final List<IOpcionFiltradoSeleccionable<Vehiculo>> filtros = new ArrayList<>(){};
    private final List<IOpcionFiltradoSeleccionable<Vehiculo>> ordenado = new ArrayList<>(){};
    private final Scanner lectura = new Scanner(System.in);

    private IOpcionFiltradoSeleccionable<Vehiculo> filtroActual = null;
    private IOpcionFiltradoSeleccionable<Vehiculo> ordenamientoActual = null;

    public int execute(Concecionaria concecionaria) {
        filtros.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Vehiculo> execute(List<Vehiculo> data) {
                data = data.stream().filter(v -> v instanceof Auto).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Filtrado por Autos";
            }
        });

        filtros.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Vehiculo> execute(List<Vehiculo> data) {
                data = data.stream().filter(v -> v instanceof Moto).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Filtrado por Motos";
            }
        });

        ordenado.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Vehiculo> execute(List<Vehiculo> data) {
                Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getPrecio);
                data = data.stream().sorted(comparator).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "PRECIO ASC";
            }
        });

        ordenado.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Vehiculo> execute(List<Vehiculo> data) {
                Comparator<Vehiculo> comparator = Comparator.comparing(Vehiculo::getPrecio).reversed();
                data = data.stream().sorted(comparator).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "PRECIO DESC";
            }
        });

        while (true) {
            List<Vehiculo> vehiculos = new ArrayList<>(){};
            vehiculos.addAll(concecionaria.getVehiculos());
            if (filtroActual != null){
                vehiculos = filtroActual.execute(vehiculos);
            }
            if (ordenamientoActual != null){
                vehiculos = ordenamientoActual.execute(vehiculos);
            }

            mostrarVehiculos(vehiculos);

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
                    return obtenerVehiculo(vehiculos);
                case 4:
                    return -1; // Salir
                default:
                    System.out.println(datoInvalido(opcion));
                    break;
            }
        }
    }

    private void mostrarVehiculos(List<Vehiculo> vehiculos) {
        System.out.println(GetTitulo());
        int contador = 1;
        for(Vehiculo v : vehiculos) {
            mostrarVehiculo(v, contador);
            contador++;
        }
    }

    private void mostrarOpciones() {
        System.out.println("1) " + (filtroActual == null ? "Filtrar" : "Reiniciar Filtro"));
        System.out.println("2) " + (ordenamientoActual == null ? "Ordenar" : "Reiniciar Ordenamiento"));
        System.out.println("3) Mostrar Detalle");
        System.out.println("4) Volver");
    }

    private void gestionarFiltros() {
        if (filtroActual != null) {
            filtroActual = null;
        } else {
            int contador = 1;
            filtros.forEach(x -> System.out.println(contador + ") "+ x.tituloMenuSeleccioble()));

            System.out.println(contador + ") Volver");

            String opcion = leerOpcion();
            int numero = Integer.parseInt(opcion);

            if (0 < numero && numero <= filtros.size()) {
                filtroActual = filtros.get(numero);
            }
            else if (numero == filtros.size() + 1) {
                filtroActual = null;
            }
            else{
                System.out.println(datoInvalido(opcion));
            }
        }
    }

    private void gestionarOrdenamiento() {
        if (ordenamientoActual != null) {
            ordenamientoActual = null;
        } else {
            int contador = 1;
            ordenado.forEach(x -> System.out.println(contador + ") "+ x.tituloMenuSeleccioble()));

            System.out.println(contador + ") Volver");

            String opcion = leerOpcion();
            int numero = Integer.parseInt(opcion);

            if (0 < numero && numero <= ordenado.size()) {
                ordenamientoActual = ordenado.get(numero -1);
            }
            else if (numero == ordenado.size() + 1) {
                ordenamientoActual = null;
            }
            else{
                System.out.println(datoInvalido(opcion));
            }
        }
    }

    private int obtenerVehiculo(List<Vehiculo> vehiculos) {
        String opcion = leerOpcion();
        int numero = Integer.parseInt(opcion);

        if (0 < numero && numero <= vehiculos.size()) {
            return numero-1;
        }
        System.out.println(datoInvalido(opcion));
        return -1;
    }

    private String GetTitulo() {
        String titulo = "Menu Ventas";
        if (filtroActual != null) {
            titulo += ", " + filtroActual.tituloMenuSeleccioble();
        }
        if (ordenamientoActual != null) {
            titulo += ", " + ordenamientoActual.tituloMenuSeleccioble();
        }
        return titulo;
    }

    private String leerOpcion() {
        System.out.print("Ingrese el numero de la opción: ");
        return lectura.nextLine();
    }

    private void mostrarVehiculo(Vehiculo vehiculo, int contador) {
        System.out.println(contador + ") Propiedades importantes");
    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
