package Test;

import DAO.impl.PacienteH2;
import entities.Paciente;
import org.apache.log4j.Logger;
import service.PacienteService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;

public class PacienteServiceTest {

    private static final Logger logger = Logger.getLogger(PacienteServiceTest.class);

    private static PacienteService paciente = new PacienteService(new PacienteH2());

    @BeforeClass
    public static void agregarPacienteTest(){
        logger.info("TEST: Agregando los pacientes");
        Paciente paciente1 = new Paciente("Raul", "Hernandez", 34, 44539204, new Date());
        Paciente paciente2 = new Paciente("Ramona", "Hernandez", 19, 45768786, new Date());
        Paciente paciente3 = new Paciente("Sebastian", "Plomer", 64, 345643456, new Date());

        paciente.agregarPaciente(paciente1);
        paciente.agregarPaciente(paciente2);
        paciente.agregarPaciente(paciente3);
    }

    @Test
    public void buscarPacienteTest(){
        logger.info("Realizando el test de buscar paciente");
        Assert.assertTrue(paciente.buscarPaciente(3) != null);
    }
}
