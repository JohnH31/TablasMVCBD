/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Autor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.autor.AutorDAO;
import modelo.autor.AutorVO;
import vista.autor.FrmMostrarJoin;

/**
 *
 * @author John
 */
public class ControladorMostrarJoin implements WindowListener {

    FrmMostrarJoin fmj = new FrmMostrarJoin();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();

    public ControladorMostrarJoin(FrmMostrarJoin fmj, AutorVO avo, AutorDAO adao) {
        this.fmj = fmj;
        this.avo = avo;
        this.adao = adao;

        fmj.addWindowListener(this);

    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Autor");
        m.addColumn("Apellido del Autor");
        m.addColumn("Nacionalidad del Autor");
        m.addColumn("Edad del Autor");
        m.addColumn("Id Libro fk");
        for (AutorVO avo : adao.consultarJoin()) {
            m.addRow(new Object[]{avo.getId_autor(), avo.getNombre_autor(), avo.getApellido_autor(), avo.getNacionalidad_autor(), avo.getEdad_autor(), avo.getId_libro_fk()});

        }
        fmj.tblModificarJoinAutor.setModel(m);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
