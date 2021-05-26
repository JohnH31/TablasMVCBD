/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Autor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.autor.AutorDAO;
import modelo.autor.AutorVO;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.autor.FrmInsertarAutor;
import vista.FrmMenu;

/**
 *
 * @author Usuario
 */
public class ControladorInsertarAutor implements ActionListener {

    FrmInsertarAutor vista = new FrmInsertarAutor();
    AutorVO avo = new AutorVO();
    AutorDAO adao = new AutorDAO();
    FrmMenu men = new FrmMenu();

    public ControladorInsertarAutor(FrmMenu men, FrmInsertarAutor vista, AutorVO avo, AutorDAO adao) {
        this.men = men;
        this.vista = vista;
        this.avo = avo;
        this.adao = adao;

        vista.btnAgregarAutor.addActionListener(this);
        vista.btnCancelarAutor.addActionListener(this);
        men.btnInsertarAutorM.addActionListener(this);
    }

    private void insertarAutor() {
        try {
            avo.setNombre_autor(vista.jtxNombre.getText());
            avo.setApellido_autor(vista.jtxApellido.getText());
            avo.setNacionalidad_autor(vista.jtxNacionalidad.getText());
            avo.setEdad_autor(Integer.parseInt(vista.jtxEdad.getText()));
            avo.setId_libro_fk(Integer.parseInt(vista.cbxLibroAutor.getSelectedItem().toString()));
            adao.insertar(avo);
            vista.jtxNombre.setText("");
            vista.jtxApellido.setText("");
            vista.jtxNacionalidad.setText("");
            vista.jtxEdad.setText("");
            vista.cbxLibroAutor.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Registro Ingresado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro!");
        }
    }

    private void cargarLibros(int buscar) {
        LibroDAO ldao = new LibroDAO();
        int index = 1;
        vista.cbxLibroAutor.removeAllItems();
        vista.cbxLibroAutor.addItem("Seleccione un Libro");
        for (LibroVO lvo : ldao.consultarTabla()) {
            vista.cbxLibroAutor.addItem(String.valueOf(lvo.getId_libro()));
            //vista.cbxLibroAutor.addItem(lvo.getNombre_libro());
            if (lvo.getId_libro() == buscar) {
                vista.cbxLibroAutor.setSelectedIndex(index);
            }
            index++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregarAutor) {
            this.insertarAutor();
        }
        if (e.getSource() == vista.btnCancelarAutor) {
            vista.dispose();
        }
        if (e.getSource() == men.btnInsertarAutorM) {
            this.cargarLibros(0);
        }
    }

}
