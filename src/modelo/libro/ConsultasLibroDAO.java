/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.libro;

import modelo.libro.LibroVO;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface ConsultasLibroDAO {

    public void insertar(LibroVO l);
    public void actualizar(LibroVO l);
    public void eliminar(LibroVO l);
    public ArrayList<LibroVO> consultarTabla();
    public ArrayList<LibroVO> consultarTablaJoin();
}
