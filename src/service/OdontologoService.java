package service;

import DAO.iBasedeDatosDAO;
import entities.Odontologo;

import java.util.List;

public class OdontologoService {

    private iBasedeDatosDAO<Odontologo> odontologoDAO;

    public iBasedeDatosDAO<Odontologo> getOdontologoDAO() {
        return odontologoDAO;
    }

    public void setOdontologoDAO(iBasedeDatosDAO<Odontologo> odontologoDao) {
        this.odontologoDAO = odontologoDao;
    }

    public OdontologoService(iBasedeDatosDAO<Odontologo> odontologoDAO) {
        this.odontologoDAO = odontologoDAO;
    }

    public Odontologo agregarOdontologo(Odontologo o) {
        return odontologoDAO.agregar(o);
    }

    public void eliminarOdontologo(int ID) {
        odontologoDAO.eliminar(ID);
    }

    public Odontologo buscarOdontologo(int ID) {
        return odontologoDAO.buscar(ID);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoDAO.buscarTodos();
    }
}
