/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.servicios.AutorService;
import libreria.servicios.EditorialService;
import libreria.servicios.LibroService;

/**
 *
 * @author usuario
 */
public class Libreria {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emf.createEntityManager();

        AutorService us = new AutorService();
        LibroService ls = new LibroService();
        EditorialService es = new EditorialService();


        try {
            //Editorial e = es.crearEditorial("santillan", true);
          //  Autor a1 = us.crearAutor("lean", true);
            Autor a2 = us.crearAutor("marco", true);
            Editorial e2 = es.crearEditorial("Marco polo", true);
        //    System.out.println(ls.buscarLibroAutor("marco"));
      
            //ls.crearLibro(a2, e2);

            //ls.eliminarPorID("bf8ba026-bd8c-40e7-981c-22fc0e1e4e83");
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
