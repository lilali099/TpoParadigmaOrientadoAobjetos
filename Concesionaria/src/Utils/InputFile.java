package Utils;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputFile {
    public static <T> T obtenerDato(String nombrePropiedad, Class<T> tipo) {
        Scanner lectura = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese " + nombrePropiedad + ":");
            String input = lectura.nextLine();
            try {

                if (input.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }

                if (tipo == String.class) {
                    return tipo.cast(input);
                } else if (tipo == Integer.class) {
                    return tipo.cast(Integer.parseInt(input));
                } else if (tipo == Double.class) {
                    return tipo.cast(Double.parseDouble(input));
                } else if (tipo == Boolean.class) {
                    return tipo.cast(Boolean.parseBoolean(input));
                } else {
                    throw new IllegalArgumentException("Tipo no soportado");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(nombrePropiedad, input));
            }
        }
    }

    public static <T> T obtenerDatoConValidacion(String nombrePropiedad, Class<T> tipo,  String mensajeValidacionError, Predicate<String> validacion) {
        Scanner lectura = new Scanner(System.in);
        boolean primeraVez = true;
        while (true) {
            if (primeraVez) {
                primeraVez = false;
            }
            else{

            }
            System.out.println("Ingrese " + nombrePropiedad + ":");
            String input = lectura.nextLine();
            try {

                if (input.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }

                if (tipo == String.class) {
                    if (validacion.test(input)){
                        return tipo.cast(input);
                    }
                    else{
                        System.out.println(mensajeValidacionError);
                    }
                } else if (tipo == Integer.class) {
                    if (validacion.test(input)){
                        return tipo.cast(Integer.parseInt(input));
                    }
                    else{
                        System.out.println(mensajeValidacionError);
                    }
                } else if (tipo == Double.class) {
                    if (validacion.test(input)){
                        return tipo.cast(Double.parseDouble(input));
                    }
                    else{
                        System.out.println(mensajeValidacionError);
                    }
                } else if (tipo == Boolean.class) {
                    if (validacion.test(input)){
                        return tipo.cast(Boolean.parseBoolean(input));
                    }
                    else{
                        System.out.println(mensajeValidacionError);
                    }
                } else {
                    throw new IllegalArgumentException("Tipo no soportado");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(nombrePropiedad, input));
            }
        }
    }

    private static String datoInvalido(String nombrePropiedad, String value){
        return "\"" + value + "\" no válido.\n Por favor, ingrese un " + nombrePropiedad + " válido.";
    }
}
