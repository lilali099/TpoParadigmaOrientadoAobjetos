package UseCases;

import Domain.Auto;
import Domain.Concesionaria;
import Domain.Moto;
import Domain.Venta;
import Utils.IOpcionMenuSeleccionable;

public class MostrarInformeVentas implements IOpcionMenuSeleccionable {

    @Override
    public void execute(Concesionaria concesionaria) {
        double cantidadGanancias= 0;
        double cantidadVentasAutos= 0;
        double cantidadGananciasAutos= 0;
        double cantidadVentasMotos= 0;
        double cantidadGananciasMotos= 0;
        for (Venta x: concesionaria.getVentas()){
            cantidadGanancias += x.getPrecioFinal();
            if (x.getVehiculo() instanceof Auto) {
                cantidadVentasAutos ++ ;
                cantidadGananciasAutos += x.getPrecioFinal();

            }
            if (x.getVehiculo() instanceof Moto) {
                cantidadVentasMotos ++;
                cantidadGananciasMotos += x.getPrecioFinal();

            }
        }
        System.out.println("Informe de Ventas");
        System.out.println("Ganancia obtenida: $" +cantidadGanancias );
        System.out.println("Cantidad vendida: " + concesionaria.getVentas().size() );
        System.out.println("Informe de Autos");
        System.out.println("Cantidad de autos vendidos: " +cantidadVentasAutos );
        System.out.println("Ganancia obtenida por venta de autos: $" +cantidadGananciasAutos );
        System.out.println("Informe de Motos");
        System.out.println("Cantidad de motos vendidas: " +cantidadVentasMotos );
        System.out.println("Ganancia obtenida por venta de motos: $" +cantidadGananciasMotos );
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Informe de Ventas";
    }
}
