/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.autor;

import modelo.autor.AutorVO;
import java.util.ArrayList;
import modelo.libro.LibroVO;

/**
 *
 * @author Usuario
 */
public interface ConsultasAutorDAO {
    public void insertar(AutorVO a);
    public void actualizar(AutorVO a);
    public void eliminar(AutorVO a);
    public ArrayList<AutorVO> consultarTabla();
    public ArrayList<AutorVO> consultarJoin();
}
