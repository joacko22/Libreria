/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import libreria.DAO.LibroDao;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author usuario
 */
public class LibroService {

    private LibroDao ldao = new LibroDao();

    public void crearLibro(Autor a, Editorial edit) throws Exception {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        try {
           
            
                Libro lib = new Libro();
                lib.setId(UUID.randomUUID().toString());
                System.out.println("ingrese el titulo");
                String titulo = sc.next();
                lib.setTitulo(titulo);
                System.out.println("ingrese el Año");
                Integer anio = sc.nextInt();
                lib.setAnio(anio);
                System.out.println("ingrese los ejemplares");
                Integer ejemplares = sc.nextInt();
                lib.setEjemplares(ejemplares);
                System.out.println("ingrese los ejemplares prestados");
                Integer ejemplaresPrestados = sc.nextInt();
                lib.setEjemplaresPrestados(ejemplaresPrestados);
                System.out.println("ingrese los ejemplares restantes");
                Integer ejemplaresRestantes = sc.nextInt();
                lib.setEjemplaresRestantes(ejemplaresRestantes);

                lib.setAlta(true);
                 
                lib.setAutor(a);
               
                lib.setEdit(edit);
                ldao.crearLibro(lib);
          
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("error en crear libro");

        }
    }

    public void eliminarPorID(String id) {
        try {
            ldao.eliminarPorID(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        try {
            return ldao.buscarPorTitulo(titulo);
        } catch (Exception e) {
            throw new Exception("error en buscar titulo");
        }
    }

  public List<Libro> buscarLibroAutor(String autor1){

        try {
            if(autor1 == null){
                System.out.println("Debe indicar autor");
            }
            List<Libro> libro = ldao.buscarLibroAutor(autor1);
            System.out.println(libro);
            if(libro == null){
                System.out.println("No hay libro para lo buscado");
            }
            return libro;
        } catch (Exception e) {

        }
        return null;
  }
    

    public Libro buscarID(String id) throws Exception {
        try {

            if (id.isEmpty() || id == null) {
                throw new Exception("el id no puede estar vacio");
            }
            return ldao.buscarPorID(id);
        } catch (Exception e) {
            throw new Exception("error en buscarID");
        }
    }
}
