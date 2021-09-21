/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria.DAO;
import java.util.Scanner;
import javax.persistence.*;
import libreria.entidades.Autor;
/**
 *
 * @author usuario
 */
public class AutorDao {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = emf.createEntityManager();

    public void insertAutor(Autor autor) throws Exception {
        try {
            if (autor == null) {
                throw new Exception("el autor no puede ser null");
            }
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("error en insertAutor");

        }

    }

    public void eliminarPorNombre(String nombre) throws Exception {
        Autor autor = buscarAutor(nombre);
        if (autor == null) {
            throw new Exception("el autor no puede ser null");
        }
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public Autor buscarAutor(String nombre) {
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
           


            return autor;


        }

    

}
