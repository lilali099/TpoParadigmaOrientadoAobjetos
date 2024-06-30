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
    private static final List<IOpcionFiltradoSeleccionable<Vehiculo>> filtros = new ArrayList<>(){};
    private static final List<IOpcionFiltradoSeleccionable<Vehiculo>> ordenado = new ArrayList<>(){};
    private static final Scanner lectura = new Scanner(System.in);

    private static IOpcionFiltradoSeleccionable<Vehiculo> filtroActual = null;
    private static IOpcionFiltradoSeleccionable<Vehiculo> ordenamientoActual = null;

    public static int execute(List<Vehiculo> vehiculosOriginal) {
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
                return "Precio ASC";
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
                return "Precio DESC";
            }
        });

        while (true) {
            List<Vehiculo> vehiculos = new ArrayList<>(){};
            vehiculos.addAll(vehiculosOriginal);
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

    private static void mostrarVehiculos(List<Vehiculo> vehiculos) {
        System.out.println(GetTitulo());
        int contador = 1;
        for(Vehiculo v : vehiculos) {
            mostrarVehiculo(v, contador);
            contador++;
        }
    }

    private static void mostrarOpciones() {
        System.out.println("Selecciona una opción: ");
        System.out.println("1) " + (filtroActual == null ? "Filtrar" : "Reiniciar Filtro"));
        System.out.println("2) " + (ordenamientoActual == null ? "Ordenar" : "Reiniciar Ordenamiento"));
        System.out.println("3) Seleccionar Vehiculo");
        System.out.println("4) Volver");
    }

    private static void gestionarFiltros() {
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

    private static void gestionarOrdenamiento() {
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

    private static int obtenerVehiculo(List<Vehiculo> vehiculos) {
        System.out.print("Ingrese el numero del Vehiculo: ");

        String opcion = lectura.nextLine();
        int numero = Integer.parseInt(opcion);

        if (0 < numero && numero <= vehiculos.size()) {
            return numero-1;
        }
        System.out.println(datoInvalido(opcion));
        return -1;
    }

    private static String GetTitulo() {
        String titulo = "Menú Ventas";
        if (filtroActual != null) {
            titulo += ", " + filtroActual.tituloMenuSeleccioble();
        }
        if (ordenamientoActual != null) {
            titulo += ", " + ordenamientoActual.tituloMenuSeleccioble();
        }
        return titulo;
    }

    private static String leerOpcion() {
        System.out.print("Ingrese el número de la opción: ");
        return lectura.nextLine();
    }

    private static void mostrarVehiculo(Vehiculo vehiculo, int contador) {
        System.out.println(contador + ") Tipo: "+(vehiculo instanceof Auto? "Auto": "Moto")+", Marca: "+ vehiculo.getMarca() +", Modelo: "+ vehiculo.getModelo() +", Año: "+ vehiculo.getAnio() +", Color: "+ vehiculo.getColor());

    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
