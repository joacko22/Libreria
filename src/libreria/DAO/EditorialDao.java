/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria.DAO;
import java.util.Scanner;
import javax.persistence.*;
import libreria.entidades.Editorial;
/**
 *
 * @author usuario
 */

public class EditorialDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = emf.createEntityManager();

    public void crearEditorial(Editorial edit) throws Exception {
        try {
            if (edit==null) {
                throw new Exception("la editorial no puede ser null");
            }
            em.getTransaction().begin();
            em.persist(edit);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new Exception("Error al crearEditorial");
        }
    }
    public Editorial buscarEditorial(String nombre){

        Editorial edit = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        return edit;
    }
}


