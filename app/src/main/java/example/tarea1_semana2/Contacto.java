package example.tarea1_semana2;

import java.util.ArrayList;

public class Contacto {

    private String nombre;
    private String fechaDeNacimiento;
    private String telefono;
    private String email;
    private String descripcionDeContacto;

    public Contacto(String nombre, String fechaDeNacimiento, String telefono, String email, String descripcionDeContacto) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.descripcionDeContacto = descripcionDeContacto;
    }

    public ArrayList<String> stringDeDatos(){
        ArrayList<String> stringDeDatos = new ArrayList<>();
        stringDeDatos.add(nombre);
        stringDeDatos.add(fechaDeNacimiento);
        stringDeDatos.add(telefono);
        stringDeDatos.add(email);
        stringDeDatos.add(descripcionDeContacto);
        return stringDeDatos;
    }

}
