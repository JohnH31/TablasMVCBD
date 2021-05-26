/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Autor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.autor.AutorDAO;
import modelo.autor.AutorVO;
import vista.autor.FrmEliminarAutor;

/**
 *
 * @author Usuario
 */
public class ControladorEliminarAutor implements MouseListener, WindowListener {

    FrmEliminarAutor vista = new FrmEliminarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    
    public ControladorEliminarAutor(FrmEliminarAutor vista,AutorVO avo,AutorDAO adao){
        this.vista = vista;
        this.avo = avo;
        this.adao = adao;
        
        vista.addWindowListener(this);
        vista.tblEliminarAutor.addMouseListener(this);
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
        vista.tblEliminarAutor.setModel(m);
    }
    
    private void eliminar() {

        int row = vista.tblEliminarAutor.getSelectedRow();
        avo.setId_autor(Integer.parseInt(vista.tblEliminarAutor.getValueAt(row, 0).toString()));
        int men = JOptionPane.showConfirmDialog(null, "Estas seguro que deceas eliminar el registro?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (men == JOptionPane.YES_OPTION) {
            try {
                adao.eliminar(avo);
                avo.setId_autor(row);
            } catch (Exception e) {
                System.out.println("Mensaje eliminar" + e.getMessage());
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.eliminar();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
