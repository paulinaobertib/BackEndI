package entities;

public class Odontologo {

    //Declaracion de los atributos de la clase

    private int ID;

    private String nombre;

    private String apellido;

    private String matricula;


    //Creacion de los constructores de la clase

    public Odontologo(int ID, String nombre, String apellido, String matricula) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    //Importamos el método toString() de la libreria de String y lo sobreescribimos

    @Override
    public String toString() {
        return "Odontologo {" +
                "ID: " + ID +
                ", nombre: " + nombre +
                ", apellido: " + apellido +
                ", matricula: " + matricula +
                '}';
    }
}
