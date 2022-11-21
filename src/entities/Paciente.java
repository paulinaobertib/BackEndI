package entities;

import java.util.Date;

public class Paciente {

    //Declaracion de los atributos de la clase

    private int ID;

    private String nombre;

    private String apellido;

    private int edad;

    private int DNI;

    private Date fechaAlta;


    //Creacion de los constructores

    public Paciente(int ID, String nombre, String apellido, int edad, int DNI, Date fechaAlta) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
    }

    public Paciente(String nombre, String apellido, int edad, int DNI, Date fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
    }


    //Creacion de los getters y setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    //Importamos el método toString() de la libreria de String y lo sobreescribimos

    @Override
    public String toString() {
        return "Paciente {" +
                "ID: " + ID +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", edad: " + edad +
                ", DNI: " + DNI +
                ", fecha alta: " + fechaAlta +
                '}';
    }
}
