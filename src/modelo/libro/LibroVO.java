/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.libro;

/**
 *
 * @author Usuario
 */
public class LibroVO {
    private int id_libro;
    private String nombre_libro;
    private String genero_libro;
    private int paginas_libro;
    private String idioma_libro;
    
    public LibroVO(){
        
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getGenero_libro() {
        return genero_libro;
    }

    public void setGenero_libro(String genero_libro) {
        this.genero_libro = genero_libro;
    }

    public int getPaginas_libro() {
        return paginas_libro;
    }

    public void setPaginas_libro(int paginas_libro) {
        this.paginas_libro = paginas_libro;
    }

    public String getIdioma_libro() {
        return idioma_libro;
    }

    public void setIdioma_libro(String idioma_libro) {
        this.idioma_libro = idioma_libro;
    }
    
            
}
