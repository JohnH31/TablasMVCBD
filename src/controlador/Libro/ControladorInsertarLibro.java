/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Libro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.libro.FrmInsertarLibro;

/**
 *
 * @author Usuario
 */
public class ControladorInsertarLibro implements ActionListener {

    FrmInsertarLibro vista = new FrmInsertarLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();

    public ControladorInsertarLibro(FrmInsertarLibro vista, LibroVO lvo, LibroDAO ldao) {
        this.vista = vista;
        this.lvo = lvo;
        this.ldao = ldao;

        vista.btnAgregarLibro.addActionListener(this);
        vista.btnCancelarLibro.addActionListener(this);
    }

    private void insertarLibro() {
        try {
            lvo.setNombre_libro(vista.jtxNombre.getText());
            lvo.setGenero_libro(vista.jtxGenero.getText());
            lvo.setPaginas_libro(Integer.parseInt(vista.jtxPaginas.getText()));
            lvo.setIdioma_libro(vista.jtxIdioma.getText());
            ldao.insertar(lvo);     
            vista.jtxNombre.setText("");
            vista.jtxGenero.setText("");
            vista.jtxPaginas.setText("");
            vista.jtxIdioma.setText("");
            JOptionPane.showMessageDialog(null,"Registro Ingresado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Datos para guardar registro ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregarLibro) {
            this.insertarLibro();
        }
        if (e.getSource() == vista.btnCancelarLibro) {
            vista.dispose();
        }

    }
}
