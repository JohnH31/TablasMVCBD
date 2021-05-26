/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Libro;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.libro.FrmEliminarLibro;

/**
 *
 * @author Usuario
 */
public class ControladorEliminarLibro implements MouseListener, WindowListener {

    FrmEliminarLibro vista = new FrmEliminarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();

    public ControladorEliminarLibro(FrmEliminarLibro vista, LibroVO lvo, LibroDAO ldao) {
        this.vista = vista;
        this.lvo = lvo;
        this.ldao = ldao;

        vista.addWindowListener(this);
        vista.tblEliminarLibro.addMouseListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Libro");
        m.addColumn("Genero del Libro");
        m.addColumn("Paginas del Libro");
        m.addColumn("Idioma del Libro");
        for (LibroVO lvo : ldao.consultarTabla()) {
            m.addRow(new Object[]{lvo.getId_libro(), lvo.getNombre_libro(),
                lvo.getGenero_libro(), lvo.getPaginas_libro(), lvo.getIdioma_libro()});

        }
        vista.tblEliminarLibro.setModel(m);
    }

    private void eliminar() {

        int row = vista.tblEliminarLibro.getSelectedRow();
        lvo.setId_libro(Integer.parseInt(vista.tblEliminarLibro.getValueAt(row, 0).toString()));
        int men = JOptionPane.showConfirmDialog(null, "Estas seguro que deceas eliminar el registro?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (men == JOptionPane.YES_OPTION) {
            try {
                ldao.eliminar(lvo);
                lvo.setId_libro(row);
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
