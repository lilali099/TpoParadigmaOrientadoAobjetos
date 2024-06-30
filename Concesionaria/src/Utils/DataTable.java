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

    private static boolean primeraVez;

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
        primeraVez = true;

        if (dataOriginal.isEmpty()){
            System.out.println(getTitulo());
            System.out.println("No hay datos Disponibles");
            return;
        }

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

            if (opcion.equalsIgnoreCase("cancelar")) {
                System.out.println("Operación cancelada.");
                break;
            }

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
        System.out.println(getTitulo());
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
        filtroActual = gestionarDatos(filtroActual, filtros);
    }

    private IOpcionFiltradoSeleccionable<T> gestionarDatos(IOpcionFiltradoSeleccionable<T> variableFiltrar, List<IOpcionFiltradoSeleccionable<T>> opciones) {
        if (variableFiltrar != null) {
            return null;
        } else {
            int contador = 1;
            for(IOpcionFiltradoSeleccionable<T> x : opciones){
                System.out.println(contador + ") "+ x.tituloMenuSeleccioble());
                contador = contador + 1;
            }

            System.out.println(contador + ") Volver");

            String opcion = leerOpcion();

            if (opcion.equalsIgnoreCase("cancelar")) {
                System.out.println("Operación cancelada.");
                return null;
            }

            int numero = Integer.parseInt(opcion);

            if (0 < numero && numero <= opciones.size()) {
                return opciones.get(numero-1);
            }
            else if (numero == opciones.size() + 1) {
                return null;
            }
            else{
                System.out.println(datoInvalido(opcion));
                return null;
            }
        }
    }

    private void gestionarOrdenamiento() {
        ordenamientoActual = gestionarDatos(ordenamientoActual, ordenado);
    }

    private static<T extends IDataTableRecord> void mostrarDetalle(List<T> data) {
        String opcion = leerOpcion();

        if (opcion.equalsIgnoreCase("cancelar")) {
            System.out.println("Operación cancelada.");
            return;
        }

        int numero = Integer.parseInt(opcion);

        if (0 < numero && numero <= data.size()) {
            data.get(numero-1).mostrarDetalle();
        }
        else{
            System.out.println(datoInvalido(opcion));
        }
    }

    private String getTitulo() {
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