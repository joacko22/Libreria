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
          //  Autor a1 = us.crearAutor("lean", true);   
           // Editorial e2 = es.crearEditorial("Marco polo", true);
            
        //    System.out.println(ls.buscarLibroAutor("marco"));
      String nombreAut,nombreEdit;
    int op;
            do {
                System.out.println("ingrese que desea hacer: \n"
                        + "1.Crear Libro\n"
                        + "2.salir");
                       op = sc.nextInt();
                
                switch (op) {
                    case 1:
                        System.out.println("Cual es el nombre del autor");
                        nombreAut = sc.next();
                       Autor a = us.crearAutor(nombreAut,true);
                        
                    
                        System.out.println("Cual es el nombre de la Editorial");
                        nombreEdit = sc.next();
                        Editorial edit = es.crearEditorial(nombreEdit,true);
                        
                    
                        ls.crearLibro(a, edit);
                        break;
                    case 2: 
                        System.out.println("saliendo...");
                        break;
                }
            } while (op!=2);


            //ls.eliminarPorID("bf8ba026-bd8c-40e7-981c-22fc0e1e4e83");
          
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
