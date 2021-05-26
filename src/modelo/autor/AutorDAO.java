/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.autor;

import modelo.autor.AutorVO;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conector;
import modelo.libro.LibroVO;

/**
 *
 * @author Usuario
 */
public class AutorDAO implements ConsultasAutorDAO {

    @Override
    public void insertar(AutorVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "INSERT INTO tbl_autor (nombre_autor, apellido_autor, "
            +"nacionalidad_autor, edad_autor, id_libro_fk) VALUES ( '"+a.getNombre_autor()+
            "', '"+a.getApellido_autor() +"', '"+a.getNacionalidad_autor() +"', "
            +a.getEdad_autor() +", "+a.getId_libro_fk() +");";
            c.consultas_multiples(consulta);

        } catch (Exception e) {
            System.out.println("Mensaje Insertar " + e.getMessage());
        }
        c.desconectar();
    }

@Override
        public void actualizar(AutorVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "UPDATE tbl_autor SET nombre_autor ='"
                    +a.getNombre_autor()+"',apellido_autor ='"
                    +a.getApellido_autor()+"', nacionalidad_autor ='"
                    +a.getNacionalidad_autor()+"', edad_autor ="
                    +a.getEdad_autor()+",id_libro_fk ="
                    +a.getId_libro_fk()+" WHERE id_autor ="
                    +a.getId_autor()+";";
//            String consulta = "UPDATE tbl_autor SET nombre_autor ='"+a.getNombre_autor()
//            +"', "+"apellido_autor ='"+a.getApellido_autor()+"', "+ "nacionalidad_autor ='"
//            +a.getNacionalidad_autor()+"', "+"edad_autor ="+a.getEdad_autor()+", "
//            +"id_libro_fk ="+a.getId_libro_fk()+"WHERE id_autor ="+a.getId_autor();
            
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Actualizar "+e.getMessage());
        }
 }

    @Override
        public void eliminar(AutorVO a) {
        Conector c = new Conector();
        try {
            c.conectar();
            String consulta = "DELETE FROM tbl_autor WHERE id_autor ="+a.getId_autor()+";";
            c.consultas_multiples(consulta);
        } catch (Exception e) {
            System.out.println("Mensaje Eliminar "+e.getMessage());
        }
        c.desconectar();
}

    @Override
        public ArrayList<AutorVO> consultarTabla() {
        Conector c = new Conector();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_autor;";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                AutorVO pvo = new AutorVO();
                pvo.setId_autor(rs.getInt(1));
                pvo.setNombre_autor(rs.getString(2));
                pvo.setApellido_autor(rs.getString(3));
                pvo.setNacionalidad_autor(rs.getString(4));
                pvo.setEdad_autor(rs.getInt(5));
                pvo.setId_libro_fk(rs.getInt(6));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;
    }

    @Override
    public ArrayList<AutorVO> consultarJoin() {
        
                Conector c = new Conector();
                AutorVO a = new AutorVO();
        ArrayList<AutorVO> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM tbl_autor A INNER JOIN tbl_libro L ON A.id_libro_fk = L.id_libro";
            ResultSet rs = c.consulta_datos(consulta);
            while(rs.next()){
                AutorVO pvo = new AutorVO();
                pvo.setId_autor(rs.getInt(1));
                pvo.setNombre_autor(rs.getString(2));
                pvo.setApellido_autor(rs.getString(3));
                pvo.setNacionalidad_autor(rs.getString(4));
                pvo.setEdad_autor(rs.getInt(5));
                pvo.setId_libro_fk(rs.getInt(6));
                info.add(pvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos "+e.getMessage());
        }
        return info;    
}
}