package Utils;

import java.util.List;

public interface IOpcionFiltradoSeleccionable<T extends IDataTableRecord> {
    List<T> execute(List<T> data);
    String tituloMenuSeleccioble();
}
