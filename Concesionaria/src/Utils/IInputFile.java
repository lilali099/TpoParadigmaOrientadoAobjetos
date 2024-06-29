package Utils;

import java.util.Scanner;

public interface IInputFile {
    static <T> T obtenerDato(String nombrePropiedad, Class<T> tipo) {
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
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un " + nombrePropiedad + " válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada no válida. " + e.getMessage());
            }
        }
    }
}
