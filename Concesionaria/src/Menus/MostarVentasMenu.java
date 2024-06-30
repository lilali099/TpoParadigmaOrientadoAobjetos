package Menus;

import Classes.Auto;
import Classes.Concecionaria;
import Classes.Moto;
import Classes.Venta;
import Utils.IOpcionMenuSeleccionable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MostarVentasMenu implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concecionaria concecionaria) {
        boolean ordenadoASC = true;
        String propiedadOrdenado = "";
        int filtrado = 0;

        Scanner lectura = new Scanner(System.in);
        String opcion = "";
        while (true){
            List<Venta> ventas = new ArrayList<>(concecionaria.getTransacciones().stream().toList());
            if (filtrado == 1){
                ventas = ventas.stream().filter(x -> x.getVehiculo() instanceof Auto).toList();
            }
            else if (filtrado == 2){
                ventas = ventas.stream().filter(x -> x.getVehiculo() instanceof Moto).toList();
            }
            else if (filtrado == 3){
                ventas = ventas.stream().filter(Venta::isEntregado).toList();
            }

            if(!propiedadOrdenado.isEmpty()){
                if (propiedadOrdenado.equals("precio")){
                    ventas = ventas.stream()
                        .sorted(ordenadoASC ? Comparator.comparing(Venta::getPrecioFinal)
                            : Comparator.comparing(Venta::getPrecioFinal).reversed())
                        .collect(Collectors.toList());
                } else if (propiedadOrdenado.equals("cliente")) {
                    ventas = ventas.stream()
                        .sorted(ordenadoASC ? Comparator.comparing(Venta::getPrecioFinal)
                            : Comparator.comparing(Venta::getPrecioFinal).reversed())
                        .collect(Collectors.toList());
                }
            }

            System.out.println(GetTitulo(ordenadoASC, propiedadOrdenado, filtrado));

            for(Venta t : ventas){
                mostrarVenta(t);
            }

            if (filtrado == 0){
                System.out.println("1) Filtrar");
            }
            else {
                System.out.println("1) Reiniciar Filtro");
            }

            if (propiedadOrdenado.isEmpty()){
                System.out.println("2) Ordenar");
            }
            else{
                System.out.println("2) Reiniciar Ordenamiento");
            }
            System.out.println("3) Mostrar Detalle");
            System.out.println("4) Volver");

            try{
                System.out.println("Ingrese el numero de la opción: ");
                opcion = lectura.nextLine();
                int numero = Integer.parseInt(opcion);

                switch (numero){
                    case 1:
                        if (filtrado != 0){
                            filtrado = 0;
                        }
                        else {
                            System.out.println("1)Filtrar por Autos");
                            System.out.println("2)Filtrar por Motos");
                            System.out.println("3)Filtrar por Entregados");
                            //pasar a enumerados
                            System.out.println("4)Volver");

                            System.out.println("Ingrese el numero de la opción: ");
                            opcion = lectura.nextLine();
                            numero = Integer.parseInt(opcion);

                            switch (numero){
                                case 1:
                                    filtrado = 1;
                                    break;
                                case 2:
                                    filtrado = 2;
                                    break;
                                case 3:
                                    filtrado = 3;
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println(datoInvalido(opcion));
                            }
                        }
                        break;
                    case 2:
                        if (propiedadOrdenado != ""){
                            propiedadOrdenado = "";
                        }
                        else {
                            System.out.println("1)Ordenar por precio ASC");
                            System.out.println("2)Ordenar por precio DESC");
                            System.out.println("3)Ordenar por cliente ASC");
                            System.out.println("4)Ordenar pro cliente DESC");

                            System.out.println("Ingrese el numero de la opción: ");
                            opcion = lectura.nextLine();
                            numero = Integer.parseInt(opcion);

                            switch (numero){
                                case 1:
                                    propiedadOrdenado = "precio";
                                    ordenadoASC = true;
                                    break;
                                case 2:
                                    propiedadOrdenado = "precio";
                                    ordenadoASC = false;
                                    break;
                                case 3:
                                    propiedadOrdenado = "cliente";
                                    ordenadoASC = true;
                                    break;
                                case 4:
                                    propiedadOrdenado = "cliente";
                                    ordenadoASC = false;
                                    break;
                                default:
                                    System.out.println(datoInvalido(opcion));
                            }
                        }
                        break;
                    default:
                        System.out.println(datoInvalido(opcion));
                        break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(opcion));
            }
        }
    }

    private String GetTitulo(boolean ordenadoASC, String propiedadOrdenado, int filtrado) {
        String titulo = "Menu Ventas";

        if (filtrado == 1){
            titulo += ", filtrado por Autos";
        } else if (filtrado == 2) {
            titulo += ", filtrado por Motos";
        }
        else if (filtrado == 3) {
            titulo += ", filtrado por Entregados";
        }

        if (propiedadOrdenado != ""){
            titulo += ", ordenado por " + propiedadOrdenado;
            titulo += ordenadoASC? " ASC" : " DESC";
        }

        return titulo;
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "";
    }

    private void mostrarVenta(Venta venta){
        System.out.println("");
        //mostrar info principal en una sola linea
    }

    private void mostrarDetalle(Venta venta){
        System.out.println("");
        //mostrar toda la info en varias lineas
    }

    private static String datoInvalido(String value){
        return "\"" + value + "\" no válido.\n Por favor, ingrese una opción válida.";
    }
}
