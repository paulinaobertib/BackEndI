package DAO.impl;

import DAO.iBasedeDatosDAO;
import Test.OdontologoServiceTest;
import Util.Util;
import entities.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoH2 implements iBasedeDatosDAO<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/ODONTOLOGO;INIT=RUNSCRIPT FROM '/Users/Paulina/Desktop/DigitalHouse/BackEnd/proyectointegrador/proyectoObertiBussoPaulina/create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public OdontologoH2() {
    }

    @Override
    public Odontologo agregar(Odontologo o) {

        logger.info("Agregando odontologo a la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (nombre, apellido, matricula) VALUES (?,?,?)");

            //setteamos los atributos
            //el ID no porque pusimos que sea autoincremental
            preparedStatement.setString(1, o.getNombre());
            preparedStatement.setString(2, o.getApellido());
            preparedStatement.setString(3, o.getMatricula());

            //Ejecutamos una sentencia SQL
            preparedStatement.executeUpdate();

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

            logger.info("Se agrego con exito el odontologo a la base de datos");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return o;
    }

    @Override
    public void eliminar(int ID) {

        logger.info("Eliminando odontologo de la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM ODONTOLOGO WHERE ID = ?");
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

            logger.info("Se elimino con exito el odontologo de la base de datos");

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Odontologo buscar(int ID) {

        logger.info("Buscando al odontologo en la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo o = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE ID = ?");
            preparedStatement.setInt(1, ID);

            //Ejecutamos una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //Obtenemos los resultados
            while (result.next()) {
                int IDOdontologo = result.getInt("ID");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                o = new Odontologo(IDOdontologo, nombre, apellido, matricula);
            }

            logger.info(o);

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return o;
    }

    @Override
    public List<Odontologo> buscarTodos() {

        logger.info("Listando todos los odontologos de la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Creamos una lista de odontologos
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("SELECT *  FROM ODONTOLOGO");

            //Ejecutamos una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //Obtenemos los resultados
            while (result.next()) {

                int IDPaciente = result.getInt("ID");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String matricula = result.getString("matricula");
                Odontologo o = new Odontologo(IDPaciente, nombre, apellido, matricula);

                //Agregamos el odontologo a la lista
                odontologos.add(o);
            }

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return odontologos;
    }
}
