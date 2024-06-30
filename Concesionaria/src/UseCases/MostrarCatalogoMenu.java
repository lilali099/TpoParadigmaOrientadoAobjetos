package UseCases;

import Domain.*;
import Utils.DataTable;
import Utils.IOpcionFiltradoSeleccionable;
import Utils.IOpcionMenuSeleccionable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MostrarCatalogoMenu implements IOpcionMenuSeleccionable {
    @Override
    public void execute(Concecionaria concecionaria) {
        List<IOpcionFiltradoSeleccionable<Vehiculo>> filtros = new ArrayList<>(){};
        List<IOpcionFiltradoSeleccionable<Vehiculo>> ordenado = new ArrayList<>(){};
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

        DataTable<Vehiculo> dataTable = new DataTable<>();

        dataTable.execute("Menu Ventas", filtros, ordenado, concecionaria.getVehiculos().stream().toList());
    }

    @Override
    public String tituloMenuSeleccioble() {
        return "Mostrar Catalogo";
    }
}
