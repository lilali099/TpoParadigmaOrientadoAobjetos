package Utils;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class InputFile {

    public static String obtenerDatoString(String nombrePropiedad) {
        return obtenerDatoGenerico(nombrePropiedad, input -> input);
    }

    public static Integer obtenerDatoInteger(String nombrePropiedad) {
        return obtenerDatoGenerico(nombrePropiedad, Integer::parseInt);
    }

    public static Double obtenerDatoDouble(String nombrePropiedad) {
        return obtenerDatoGenerico(nombrePropiedad, Double::parseDouble);
    }

    public static Boolean obtenerDatoBoolean(String nombrePropiedad) {
        return obtenerDatoGenerico(nombrePropiedad, Boolean::parseBoolean);
    }

    private static <T> T obtenerDatoGenerico(String nombrePropiedad, Function<String, T> convertidor) {
        Scanner lectura = new Scanner(System.in);
        boolean primeraVez = true;
        while (true) {
            if (primeraVez) {
                primeraVez = false;
            } else {
                System.out.println("Ingrese \"cancelar\" para finalizar la operación");
            }
            System.out.println("Ingrese " + nombrePropiedad + ":");
            String input = lectura.nextLine();
            try {
                if (input.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }
                return convertidor.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(nombrePropiedad, input));
            }
        }
    }

    private static <T> T obtenerDatoGenerico(String nombrePropiedad, Function<String, T> convertidor, String mensajeValidacionError, Predicate<String> validacion) {
        Scanner lectura = new Scanner(System.in);
        boolean primeraVez = true;
        while (true) {
            if (primeraVez) {
                primeraVez = false;
            } else {
                System.out.println("Ingrese \"cancelar\" para finalizar la operación");
            }
            System.out.println("Ingrese " + nombrePropiedad + ":");
            String input = lectura.nextLine();
            try {
                if (input.equalsIgnoreCase("cancelar")) {
                    System.out.println("Operación cancelada.");
                    return null;
                }

                if (validacion.test(input)) {
                    return convertidor.apply(input);
                } else {
                    System.out.println(mensajeValidacionError);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(datoInvalido(nombrePropiedad, input));
            }
        }
    }

    public static String obtenerDatoString(String nombrePropiedad, String mensajeValidacionError, Predicate<String> validacion) {
        return obtenerDatoGenerico(nombrePropiedad, input -> input, mensajeValidacionError, validacion);
    }

    public static Integer obtenerDatoInteger(String nombrePropiedad, String mensajeValidacionError, Predicate<String> validacion) {
        return obtenerDatoGenerico(nombrePropiedad, Integer::parseInt, mensajeValidacionError, validacion);
    }

    public static Double obtenerDatoDouble(String nombrePropiedad, String mensajeValidacionError, Predicate<String> validacion) {
        return obtenerDatoGenerico(nombrePropiedad, Double::parseDouble, mensajeValidacionError, validacion);
    }

    public static Boolean obtenerDatoBoolean(String nombrePropiedad, String mensajeValidacionError, Predicate<String> validacion) {
        return obtenerDatoGenerico(nombrePropiedad, Boolean::parseBoolean, mensajeValidacionError, validacion);
    }

    private static String datoInvalido(String nombrePropiedad, String value){
        return "\"" + value + "\" no válido.\n Por favor, ingrese un " + nombrePropiedad + " válido.";
    }
}
