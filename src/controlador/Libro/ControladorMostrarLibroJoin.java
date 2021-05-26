/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Libro;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.libro.LibroDAO;
import modelo.libro.LibroVO;
import vista.libro.FrmMostrarJoinLibro;

/**
 *
 * @author John
 */
public class ControladorMostrarLibroJoin implements WindowListener {

    FrmMostrarJoinLibro fmj = new FrmMostrarJoinLibro();
    LibroVO lvo = new LibroVO();
    LibroDAO ldao = new LibroDAO();
    
    public ControladorMostrarLibroJoin(FrmMostrarJoinLibro fmj,LibroVO lvo,LibroDAO ldao){
        this.fmj = fmj;
        this.lvo = lvo;
        this.ldao = ldao;
        
        fmj.addWindowListener(this);
    }
    
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre del Libro");
        m.addColumn("Genero del Libro");
        m.addColumn("Paginas del Libro");
        m.addColumn("Idioma del Libro");
        for (LibroVO lvo : ldao.consultarTablaJoin()) {
            m.addRow(new Object[]{lvo.getId_libro(),lvo.getNombre_libro(),
                lvo.getGenero_libro(),lvo.getPaginas_libro(),lvo.getIdioma_libro()});
            
        }
        fmj.tblMostrarJoinLibro.setModel(m);
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

