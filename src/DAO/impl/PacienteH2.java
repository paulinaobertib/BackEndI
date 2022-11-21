package DAO.impl;

import DAO.iBasedeDatosDAO;
import entities.Paciente;
import Util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacienteH2 implements iBasedeDatosDAO<Paciente> {

    private static final Logger logger = Logger.getLogger(PacienteH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/PACIENTES;INIT=RUNSCRIPT FROM '/Users/Paulina/Desktop/DigitalHouse/BackEnd/proyectointegrador/proyectoObertiBussoPaulina/create.sql'";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public PacienteH2() {
    }

    @Override
    public Paciente agregar(Paciente p) {

        logger.info("Agregando paciente a la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (nombre, apellido, edad, DNI, fechaAlta) VALUES (?,?,?,?,?)");

            //setteamos los atributos
            //el ID no porque pusimos que sea autoincremental
            preparedStatement.setString(1, p.getNombre());
            preparedStatement.setString(2, p.getApellido());
            preparedStatement.setInt(3, p.getEdad());
            preparedStatement.setInt(4, p.getDNI());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(p.getFechaAlta()));

            //Ejecutamos una sentencia SQL
            preparedStatement.executeUpdate();

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

            logger.info("Se agrego con exito el paciente a la base de datos");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }

        return p;
    }

    @Override
    public void eliminar(int ID) {

        logger.info("Eliminando paciente de la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM PACIENTES where ID = ?");
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

            logger.info("Se elimino con exito el paciente de la base de datos");

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Paciente buscar(int ID) {

        logger.info("Buscando paciente en la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente p = null;

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            //Nos conectamos
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Creamos una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES where ID = ?");
            preparedStatement.setInt(1, ID);

            //Ejecutamos una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //Obtenemos los resultados
            while (result.next()) {
                int IDPaciente = result.getInt("ID");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int edad = result.getInt("edad");
                int DNI = result.getInt("DNI");
                Date fechaAlta = result.getDate("fechaAlta");
                p = new Paciente(IDPaciente, nombre, apellido, edad, DNI, fechaAlta);
            }

            logger.info(p);

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Paciente> buscarTodos() {

        logger.info("Listando todos los pacientes de la base de datos");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //Creamos una lista de pacientes
        List<Paciente> pacientes = new ArrayList<>();

        try {
            //Levantamos el Driver
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT *  FROM PACIENTES");

            //Ejecutamos una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //Obtenemos los resultados
            while (result.next()) {

                int IDPaciente = result.getInt("ID");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int edad = result.getInt("edad");
                int DNI = result.getInt("DNI");
                Date fechaAlta = result.getDate("fechaAlta");
                Paciente p = new Paciente(IDPaciente, nombre, apellido, edad, DNI, fechaAlta);

                //Agregamos el paciente a la lista
                pacientes.add(p);
            }

            //Cerramos el objeto de tipo PreparedStatement
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }
}
