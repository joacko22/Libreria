/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import java.util.UUID;
import libreria.DAO.AutorDao;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;

/**
 *
 * @author usuario
 */
public class AutorService {

    private final AutorDao adao = new AutorDao();

    public Autor crearAutor(String nombre, Boolean alta) throws Exception {

        Autor autor =new Autor();

        try {
        
                autor.setId(UUID.randomUUID().toString());
                autor.setNombre(nombre);
                autor.setAlta(alta);
                adao.insertAutor(autor);
                return autor;
            

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Error en crearAutor");

        }

    }

    public void eliminarPorNombre(String nombre) {
        try {
            adao.eliminarPorNombre(nombre);
        } catch (Exception e) {
        }
    }
    public Autor buscarAutor(String nombre) throws Exception {

        try {
            if (nombre.isEmpty() || nombre == null) {
                throw new Exception("no puede ser null");
            }

            return adao.buscarAutor(nombre);
        } catch (Exception e) {

            throw new Exception("Error en buscar autor");
        }

    }

}
