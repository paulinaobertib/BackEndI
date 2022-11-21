package service;

import DAO.iBasedeDatosDAO;
import entities.Odontologo;
import entities.Paciente;

import java.util.List;

public class PacienteService {

    private iBasedeDatosDAO<Paciente> pacienteDAO;

    public iBasedeDatosDAO<Paciente> getPacienteDAO() {
        return pacienteDAO;
    }

    public void setPacienteDAO(iBasedeDatosDAO<Paciente> pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public PacienteService(iBasedeDatosDAO<Paciente> pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public Paciente agregarPaciente(Paciente p) {
        return pacienteDAO.agregar(p);
    }

    public void eliminarPaciente(int ID) {
        pacienteDAO.eliminar(ID);
    }

    public Paciente buscarPaciente(int ID) {
        return pacienteDAO.buscar(ID);
    }

    public List<Paciente> buscarTodos(){
        return pacienteDAO.buscarTodos();
    }
}

