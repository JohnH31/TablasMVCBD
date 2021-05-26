/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.autor.FrmEliminarAutor;
import vista.libro.FrmEliminarLibro;
import vista.autor.FrmInsertarAutor;
import vista.libro.FrmInsertarLibro;
import vista.FrmMenu;
import vista.autor.FrmModificarAutor;
import vista.autor.FrmMostrarJoin;
import vista.libro.FrmModificarLibro;
import vista.libro.FrmMostrarJoinLibro;

/**
 *
 * @author Usuario
 */
public class ControladorMenu implements ActionListener {

    FrmMenu men = new FrmMenu();
    FrmInsertarLibro ins = new FrmInsertarLibro();
    FrmEliminarLibro eli = new FrmEliminarLibro();
    FrmModificarLibro mod = new FrmModificarLibro();
    FrmInsertarAutor insa = new FrmInsertarAutor();
    FrmEliminarAutor elia = new FrmEliminarAutor();
    FrmModificarAutor moda = new FrmModificarAutor();
    FrmMostrarJoin fmj = new FrmMostrarJoin();
    FrmMostrarJoinLibro fmjl = new FrmMostrarJoinLibro();

    public ControladorMenu(FrmMenu men, FrmInsertarLibro ins, FrmEliminarLibro eli, FrmModificarLibro mod, FrmInsertarAutor insa, FrmEliminarAutor elia,FrmModificarAutor moda,FrmMostrarJoin fmj,FrmMostrarJoinLibro fmjl) {
        this.men = men;
        this.ins = ins;
        this.eli = eli;
        this.mod = mod;
        this.insa = insa;
        this.elia = elia;
        this.moda = moda;
        this.fmj = fmj;
        this.fmjl = fmjl;
        
        men.btnInsertarLibroM.addActionListener(this);
        men.btnEliminarLibroM.addActionListener(this);
        men.btnModificarLibroM.addActionListener(this);
        men.btnInsertarAutorM.addActionListener(this);
        men.btnEliminarAutorM.addActionListener(this);
        men.btnModificarAutorM.addActionListener(this);
        men.btnMostrarAutorM.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == men.btnInsertarLibroM) {
            ins.setVisible(true);
            ins.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnEliminarLibroM) {
            eli.setVisible(true);
            eli.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnModificarLibroM) {
            mod.setVisible(true);
            mod.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnInsertarAutorM) {
            insa.setVisible(true);
            insa.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnEliminarAutorM) {
            elia.setVisible(true);
            elia.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnModificarAutorM) {
            moda.setVisible(true);
            moda.setLocationRelativeTo(null);
        }
        if (e.getSource() == men.btnMostrarAutorM) {
            fmj.setVisible(true);
            fmj.setLocationRelativeTo(null);
            fmjl.setVisible(true);
            fmjl.setLocationRelativeTo(null);
        }
    }

}
