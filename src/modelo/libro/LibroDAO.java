/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.libro;

import modelo.libro.LibroVO;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conector;

/**
 *
 * @author Usuario
 */
public class LibroDAO implements ConsultasLibroDAO {

    @Override
    public void insertar(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_libro (nombre_libro, genero_libro, "
            +"paginas_libro, idioma_libro) VALUES ( '"+l.getNombre_libro()+"', '"
            +l.getGenero_libro()+"', "+l.getPaginas_libro()+", '"+l.getIdioma_libro()+"');";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje Insertar " + e.getMessage());
        }
        c.desconectar();
 }

    @Override
    public void actualizar(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_libro SET nombre_libro ='"+l.getNombre_libro()
            +"', "+"genero_libro ='"+l.getGenero_libro()+"', "+"paginas_libro ="
            +l.getPaginas_libro()+", "+"idioma_libro ='"+l.getIdioma_libro()+"' "
            +"WHERE id_libro ="+l.getId_libro();
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Actualizar "+e.getMessage());
        }
        c.desconectar();
}

    @Override
    public void eliminar(LibroVO l) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_libro WHERE id_libro ="+l.getId_libro()+";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Eliminar "+e.getMessage());
        }
        c.desconectar();
}

    @Override
    public ArrayList<LibroVO> consultarTabla() {
        Conector c = new Conector();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_libro;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                LibroVO pvo = new LibroVO();
                pvo.setId_libro(rs.getInt(1));
                pvo.setNombre_libro(rs.getString(2));
                pvo.setGenero_libro(rs.getString(3));
                pvo.setPaginas_libro(rs.getInt(4));
                pvo.setIdioma_libro(rs.getString(5));
                info.add(pvo);
            }
            //c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
}

    @Override
    public ArrayList<LibroVO> consultarTablaJoin() {
        Conector c = new Conector();
        ArrayList<LibroVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_autor A INNER JOIN tbl_libro L ON A.id_libro_fk = L.id_libro";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                LibroVO pvo = new LibroVO();
                pvo.setId_libro(rs.getInt(7));
                pvo.setNombre_libro(rs.getString(8));
                pvo.setGenero_libro(rs.getString(9));
                pvo.setPaginas_libro(rs.getInt(10));
                pvo.setIdioma_libro(rs.getString(11));
                info.add(pvo);
            }
            //c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
}
    
}
