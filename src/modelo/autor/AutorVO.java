/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.autor;

/**
 *
 * @author Usuario
 */
public class AutorVO {

    private int id_autor;
    private String nombre_autor;
    private String apellido_autor;
    private String nacionalidad_autor;
    private int edad_autor;
    private int id_libro_fk;

    public AutorVO() {

    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }

    public String getNacionalidad_autor() {
        return nacionalidad_autor;
    }

    public void setNacionalidad_autor(String nacionalidad_autor) {
        this.nacionalidad_autor = nacionalidad_autor;
    }

    public int getEdad_autor() {
        return edad_autor;
    }

    public void setEdad_autor(int edad_autor) {
        this.edad_autor = edad_autor;
    }

    public int getId_libro_fk() {
        return id_libro_fk;
    }

    public void setId_libro_fk(int id_libro_fk) {
        this.id_libro_fk = id_libro_fk;
    }

}
