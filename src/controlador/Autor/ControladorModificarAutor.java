/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Autor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.autor.AutorDAO;
import modelo.autor.AutorVO;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.FrmMenu;
import vista.autor.FrmModificarAutor;
import vista.autor.FrmRegistroAutor;

/**
 *
 * @author Usuario
 */
public class ControladorModificarAutor implements ActionListener, MouseListener, WindowListener {

    FrmModificarAutor mod = new FrmModificarAutor();
    FrmRegistroAutor reg = new FrmRegistroAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    FrmMenu men = new FrmMenu();

    public ControladorModificarAutor(FrmMenu men,FrmModificarAutor mod, FrmRegistroAutor reg, AutorVO avo, AutorDAO adao) {
        this.mod = mod;
        this.reg = reg;
        this.avo = avo;
        this.adao = adao;
        this.men = men;

        mod.addWindowListener(this);
        reg.btnModificarRegistroA.addActionListener(this);
        mod.tblModificarAutor.addMouseListener(this);
        men.btnModificarAutorM.addActionListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Autor");
        m.addColumn("Apellido del Autor");
        m.addColumn("Nacionalidad del Autor");
        m.addColumn("Edad del Autor");
        m.addColumn("Id Libro");
        for (AutorVO avo : adao.consultarTabla()) {
            m.addRow(new Object[]{avo.getId_autor(), avo.getNombre_autor(), avo.getApellido_autor(), avo.getNacionalidad_autor(), avo.getEdad_autor(), avo.getId_libro_fk()});

        }
        mod.tblModificarAutor.setModel(m);
    }

    private void datos() {
        int row;
        row = mod.tblModificarAutor.getSelectedRow();
        avo.setId_autor(Integer.parseInt(mod.tblModificarAutor.getValueAt(row, 0).toString()));
        reg.jtxNombre.setText(String.valueOf(mod.tblModificarAutor.getValueAt(row, 1)));
        reg.jtxApellido.setText(String.valueOf(mod.tblModificarAutor.getValueAt(row, 2)));
        reg.jtxNacionalidad.setText(String.valueOf(mod.tblModificarAutor.getValueAt(row, 3)));
        reg.jtxEdad.setText(String.valueOf(mod.tblModificarAutor.getValueAt(row, 4)));
        //reg.cbxLibroAutor.addItem(mod.tblModificarAutor.getValueAt(row, 5).toString());
        avo.setId_libro_fk((int) mod.tblModificarAutor.getValueAt(row, 5));
        //reg.jtxLibro.setText(String.valueOf(mod.tblModificarAutor.getValueAt(row, 5)));
    }                                                                                       

    private void modi() {
        try {
            avo.getId_autor();
            avo.setNombre_autor(reg.jtxNombre.getText());
            avo.setApellido_autor(reg.jtxApellido.getText());
            avo.setNacionalidad_autor(reg.jtxNacionalidad.getText());
            avo.setEdad_autor(Integer.parseInt(reg.jtxEdad.getText()));
            avo.setId_libro_fk(Integer.parseInt(reg.cbxLibroAutor.getSelectedItem().toString()));
            adao.actualizar(avo);
            JOptionPane.showMessageDialog(null, "Registro Modificado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Datos para Modificar registro");
        }
    }
    
    private void cargarLibros(int buscar) {
        LibroDAO ldao = new LibroDAO();
        int index = 1;
        reg.cbxLibroAutor.removeAllItems();
        //reg.cbxLibroAutor.addItem("Seleccione un Libro");
        for (LibroVO lvo : ldao.consultarTabla()) {
            reg.cbxLibroAutor.addItem(String.valueOf(lvo.getId_libro()));
            //vista.cbxLibroAutor.addItem(lvo.getNombre_libro());
            if (lvo.getId_libro() == buscar) {
                reg.cbxLibroAutor.setSelectedIndex(index);
            }
            index++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reg.btnModificarRegistroA) {
            this.modi();
            reg.dispose();
        }
        if (e.getSource() == men.btnModificarAutorM) {
            this.cargarLibros(0);
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
