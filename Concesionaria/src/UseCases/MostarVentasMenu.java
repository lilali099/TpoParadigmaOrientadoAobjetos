package UseCases;

import Domain.*;
import Utils.DataTable;
import Utils.IOpcionFiltradoSeleccionable;
import Utils.IOpcionMenuSeleccionable;

import java.util.*;
import java.util.stream.Collectors;

public class MostarVentasMenu implements IOpcionMenuSeleccionable {
    @Override
    public void execute(Concecionaria concecionaria) {
        List<IOpcionFiltradoSeleccionable<Venta>> filtros = new ArrayList<>();
        List<IOpcionFiltradoSeleccionable<Venta>> ordenado = new ArrayList<>();
        filtros.add(new IOpcionFiltradoSeleccionable<Venta>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                data = data.stream().filter(v -> v.getVehiculo() instanceof Auto).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Filtrado por Autos";
            }
        });

        filtros.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                data = data.stream().filter(v -> v.getVehiculo() instanceof Moto).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Filtrado por Motos";
            }
        });

        filtros.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                data = data.stream().filter(Venta::isEntregado).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Filtrado por Entregados";
            }
        });


        ordenado.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                Comparator<Venta> comparator = Comparator.comparing(Venta::getPrecioFinal);
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
            public List<Venta> execute(List<Venta> data) {
                Comparator<Venta> comparator = Comparator.comparing(Venta::getPrecioFinal).reversed();
                data = data.stream().sorted(comparator).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Precio DESC";
            }
        });

        ordenado.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                Comparator<Venta> comparator = Comparator.comparing(Venta::getPrecioFinal);
                data = data.stream().sorted(comparator).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Cliente ASC";
            }
        });

        ordenado.add(new IOpcionFiltradoSeleccionable<>() {
            @Override
            public List<Venta> execute(List<Venta> data) {
                Comparator<Venta> comparator = Comparator.comparing(Venta::getPrecioFinal).reversed();
                data = data.stream().sorted(comparator).collect(Collectors.toList());
                return data;
            }

            @Override
            public String tituloMenuSeleccioble() {
                return "Cliente DESC";
            }
        });

        DataTable<Venta> dataTable = new DataTable<>();

        dataTable.execute("Menú Ventas", filtros, ordenado, concecionaria.getVentas().stream().toList());
    }
    @Override
    public String tituloMenuSeleccioble() {
        return "Mostrar Ventas";
    }
}
