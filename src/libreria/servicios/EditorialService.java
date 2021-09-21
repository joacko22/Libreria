/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria.servicios;
import java.util.Scanner;
import java.util.UUID;
import libreria.DAO.EditorialDao;
import libreria.entidades.Editorial;
/**
 *
 * @author usuario
 */
    public class EditorialService {

    private final EditorialDao edao = new EditorialDao();

    public Editorial crearEditorial(String nombre, Boolean alta) throws Exception {

        Editorial edit = new Editorial();
        try {
           
            edit.setId(UUID.randomUUID().toString());
            edit.setNombre(nombre);
            edit.setAlta(alta);
            edao.crearEditorial(edit);
            return edit;
        } catch (Exception e) {
            throw new Exception("error en editorial service");
        }

    }

    public Editorial buscarEditorial(String nombre) throws Exception {

        try {
            return edao.buscarEditorial(nombre);
        } catch (Exception e) {
            throw new Exception("error en editorial service");
        }

    }
}

