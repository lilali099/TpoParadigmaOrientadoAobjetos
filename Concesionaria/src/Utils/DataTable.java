package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataTable<T extends IDataTableRecord> {

    private final List<IOpcionFiltradoSeleccionable<T>> filtros = new ArrayList<>(){};
    private final List<IOpcionFiltradoSeleccionable<T>> ordenado = new ArrayList<>(){};
    private static final Scanner lectura = new Scanner(System.in);

    private IOpcionFiltradoSeleccionable<T> filtroActual = null;
    private IOpcionFiltradoSeleccionable<T> ordenamientoActual = null;
    private String titulo;

    public void execute(
        String titulo,
        List<IOpcionFiltradoSeleccionable<T>> filtros,
        List<IOpcionFiltradoSeleccionable<T>> ordenado,
        List<T> dataOriginal
    )
    {
        this.titulo = titulo;
        this.filtros.addAll(filtros);
        this.ordenado.addAll(ordenado);

        while (true) {
            List<T> data = new ArrayList<>(){};
            data.addAll(dataOriginal);
            if (filtroActual != null){
                data = filtroActual.execute(data);
            }
            if (ordenamientoActual != null){
                data = ordenamientoActual.execute(data);
            }

            mostrarData(data);

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
                    mostrarDetalle(data);
                    break;
                case 4:
                    return; // Salir
                default:
                    System.out.println(datoInvalido(opcion));
                    break;
            }
        }
    }

    private void mostrarData(List<T> data) {
        System.out.println(GetTitulo());
        int contador = 1;
        for(T d : data) {
            mostrarVenta(d, contador);
            contador++;
        }
    }

    private void mostrarVenta(T d, int contador) {
        System.out.println(contador + ") " + d.getDataTableRecord());
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
                filtroActual = filtros.get(numero-1);
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
                ordenamientoActual = ordenado.get(numero-1);
            }
            else if (numero == ordenado.size() + 1) {
                ordenamientoActual = null;
            }
            else{
                System.out.println(datoInvalido(opcion));
            }
        }
    }

    private static<T extends IDataTableRecord> void mostrarDetalle(List<T> data) {
        // Implementa la lógica para mostrar el detalle de una venta
        String opcion = leerOpcion();
        int numero = Integer.parseInt(opcion);

        if (0 < numero && numero <= data.size()) {
            data.get(numero-1).mostrarDetalle();
        }
        else{
            System.out.println(datoInvalido(opcion));
        }
    }

    private String GetTitulo() {
        String titulo = this.titulo;
        if (filtroActual != null) {
            titulo += ", " + filtroActual.tituloMenuSeleccioble();
        }
        if (ordenamientoActual != null) {
            titulo += ", " + ordenamientoActual.tituloMenuSeleccioble();
        }
        return titulo;
    }

    private static String leerOpcion() {
        System.out.print("Ingrese el numero de la opción: ");
        return lectura.nextLine();
    }

    private static String datoInvalido(String value) {
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
