/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.libro.FrmModificarLibro;
import vista.libro.FrmRegistroLibro;

/**
 *
 * @author Usuario
 */
public class ControladorModificarLibro implements ActionListener, MouseListener, WindowListener {

    FrmModificarLibro mod = new FrmModificarLibro();
    FrmRegistroLibro reg = new FrmRegistroLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorModificarLibro (FrmModificarLibro mod, FrmRegistroLibro reg, LibroVO lvo, LibroDAO ldao){
        this.mod = mod;
        this.reg = reg;
        this.lvo = lvo;
        this.ldao = ldao;
        
        mod.addWindowListener(this);
        reg.btnModificarRegistroL.addActionListener(this);
        mod.tblModificarLibro.addMouseListener(this);
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
        mod.tblModificarLibro.setModel(m);
    }
    
        private void datos() {
        int row;
        row = mod.tblModificarLibro.getSelectedRow();
        lvo.setId_libro(Integer.parseInt(mod.tblModificarLibro.getValueAt(row, 0).toString()));
        reg.jtxNombre.setText(String.valueOf(mod.tblModificarLibro.getValueAt(row, 1)));
        reg.jtxGenero.setText(String.valueOf(mod.tblModificarLibro.getValueAt(row, 2)));
        reg.jtxPaginas.setText(String.valueOf(mod.tblModificarLibro.getValueAt(row, 3)));
        reg.jtxIdioma.setText(String.valueOf(mod.tblModificarLibro.getValueAt(row, 4)));
    }

    private void modi() {
        try {
            lvo.getId_libro();
            lvo.setNombre_libro(reg.jtxNombre.getText());
            lvo.setGenero_libro(reg.jtxGenero.getText());
            lvo.setPaginas_libro(Integer.parseInt(reg.jtxPaginas.getText()));
            lvo.setIdioma_libro(reg.jtxIdioma.getText());
            ldao.actualizar(lvo);
            JOptionPane.showMessageDialog(null,"Registro Modificado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para Modificar registro");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reg.btnModificarRegistroL) {
            this.modi();
            reg.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.datos();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        reg.setVisible(true);
        reg.setLocationRelativeTo(null);
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
