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
import vista.FrmMenu;

/**
 *
 * @author Usuario
 */
public class ControladorMostrarAutor implements WindowListener {

    FrmMenu men = new FrmMenu();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    
    public ControladorMostrarAutor(FrmMenu men, AutorVO avo, AutorDAO adao){
        this.men = men;
        this.avo = avo;
        this.adao = adao;
        
        men.addWindowListener(this);
        
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Autor");
        m.addColumn("Apellido del Autor");
        m.addColumn("Nacionalidad del Autor");
        m.addColumn("Edad del Autor");
        m.addColumn("Id Libro");
        for (AutorVO avo : adao.consultarTabla()) {
            m.addRow(new Object[]{avo.getId_autor(),avo.getNombre_autor(),avo.getApellido_autor(),avo.getNacionalidad_autor(),avo.getEdad_autor(),avo.getId_libro_fk()});
                              
        }
        men.tblMostrarAutor.setModel(m);
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
