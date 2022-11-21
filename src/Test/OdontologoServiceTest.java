package Test;

import DAO.impl.OdontologoH2;
import entities.Odontologo;
import org.apache.log4j.Logger;
import service.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class OdontologoServiceTest {

    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);

    private static OdontologoService odontologo = new OdontologoService(new OdontologoH2());

    @BeforeClass
    public static void agregarOdontologoTest(){
        logger.info("TEST: Agregando los odontologos");
        Odontologo odontologo1 = new Odontologo("Roberto", "Perez", "AEN2342");
        Odontologo odontologo2 = new Odontologo("Patricia", "Lopez", "P287U2B");
        Odontologo odontologo3 = new Odontologo("Daniel", "Gigena", "DUJAJ234");

        odontologo.agregarOdontologo(odontologo1);
        odontologo.agregarOdontologo(odontologo2);
        odontologo.agregarOdontologo(odontologo3);
    }

    @Test
    public void eliminarOdontologoTest(){
        logger.info("Realizando el test de eliminar odontologo");
        odontologo.eliminarOdontologo(1);
        Assert.assertTrue(odontologo.buscarOdontologo(1) == null);
    }

    @Test
    public void listarTodosOdontologosTest() {
        logger.info("Realizando el test de listar todos los odontologos");
        List<Odontologo> listaOdontologos = odontologo.buscarTodos();
        Assert.assertTrue(!listaOdontologos.isEmpty());
    }
}
