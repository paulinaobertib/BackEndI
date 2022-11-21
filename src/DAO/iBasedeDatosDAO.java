package DAO;

import java.util.List;

//Creacion de la interfaz DAO

public interface iBasedeDatosDAO<T> {

    public T agregar(T dato);

    public void eliminar(int ID);

    public T buscar (int ID);

    public List<T> buscarTodos();
}
