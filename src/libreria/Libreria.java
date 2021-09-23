/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Scanner;
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
        Scanner sc = new Scanner(System.in);

        AutorService us = new AutorService();
        LibroService ls = new LibroService();
        EditorialService es = new EditorialService();

        try {
//            Autor a1 = us.crearAutor("lean", true);
//            Editorial e2 = es.crearEditorial("Marco polo", true);
//
//            ls.crearLibro(a1, e2);
//            Autor a2 = us.crearAutor("jose", true);
//            Editorial e3 = es.crearEditorial("Cluster", true);
//
//            ls.crearLibro(a2, e3);
//            Autor a3 = us.crearAutor("bsr", true);
//            Editorial e4 = es.crearEditorial("sdw", true);
//
//            ls.crearLibro(a3, e4);
          ls.buscarLibroAutor("jose");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
