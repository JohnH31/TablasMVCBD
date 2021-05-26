/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividadcrud;

import controlador.Autor.ControladorEliminarAutor;
import controlador.Libro.ControladorEliminarLibro;
import controlador.Autor.ControladorInsertarAutor;
import controlador.Libro.ControladorInsertarLibro;
import controlador.ControladorMenu;
import controlador.Autor.ControladorModificarAutor;
import controlador.Libro.ControladorModificarLibro;
import controlador.Autor.ControladorMostrarAutor;
import controlador.Autor.ControladorMostrarJoin;
import controlador.Libro.ControladorMostrarLibro;
import controlador.Libro.ControladorMostrarLibroJoin;
import modelo.autor.AutorDAO;
import modelo.autor.AutorVO;
import modelo.Conector;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.autor.FrmEliminarAutor;
import vista.libro.FrmEliminarLibro;
import vista.autor.FrmInsertarAutor;
import vista.libro.FrmInsertarLibro;
import vista.FrmMenu;
import vista.autor.FrmModificarAutor;
import vista.autor.FrmMostrarJoin;
import vista.libro.FrmModificarLibro;
import vista.autor.FrmRegistroAutor;
import vista.libro.FrmMostrarJoinLibro;
import vista.libro.FrmRegistroLibro;

/**
 *
 * @author Usuario
 */
public class ActividadCrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //  Conector c = new Conector();
        //  c.conectar();
        FrmMenu men = new FrmMenu();
        FrmInsertarLibro ins = new FrmInsertarLibro();
        FrmEliminarLibro eli = new FrmEliminarLibro();
        FrmModificarLibro mod = new FrmModificarLibro();
        FrmRegistroLibro reg = new FrmRegistroLibro();
        FrmInsertarAutor insa = new FrmInsertarAutor();
        FrmEliminarAutor elia = new FrmEliminarAutor();
        FrmModificarAutor moda = new FrmModificarAutor();
        FrmRegistroAutor rega = new FrmRegistroAutor();
        FrmMostrarJoin fmj = new FrmMostrarJoin();
        FrmMostrarJoinLibro fmjl = new FrmMostrarJoinLibro();

        LibroVO lvo = new LibroVO();
        LibroDAO ldao = new LibroDAO();
        AutorVO avo = new AutorVO();
        AutorDAO adao = new AutorDAO();

        ControladorMenu cm = new ControladorMenu(men, ins, eli, mod, insa, elia,moda,fmj,fmjl);
        ControladorInsertarLibro cil = new ControladorInsertarLibro(ins, lvo, ldao);
        ControladorMostrarLibro cml = new ControladorMostrarLibro(men, lvo, ldao);
        ControladorEliminarLibro cel = new ControladorEliminarLibro(eli, lvo, ldao);
        ControladorModificarLibro cmlr = new ControladorModificarLibro(mod, reg, lvo, ldao);
        ControladorInsertarAutor cia = new ControladorInsertarAutor(men, insa, avo, adao);
        ControladorMostrarAutor cma = new ControladorMostrarAutor(men, avo, adao);
        ControladorEliminarAutor cea = new ControladorEliminarAutor(elia, avo, adao);
        ControladorModificarAutor cmaa = new ControladorModificarAutor(men,moda,rega,avo,adao);
        ControladorMostrarJoin cmj = new ControladorMostrarJoin(fmj,avo,adao);
        ControladorMostrarLibroJoin cmlj = new ControladorMostrarLibroJoin(fmjl,lvo,ldao);
        men.setVisible(true);
        men.setLocationRelativeTo(null);
    }

}
