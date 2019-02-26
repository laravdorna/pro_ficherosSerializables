/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13_ficheroserializable;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.PedirDatos;

/**
 *
 * @author lvazquezdorna
 */
public class EscrituraSerializable {

    //creo dos atributos de 
    ObjectOutputStream fich;
    FileOutputStream f;

    public void escribirObxetosSerie(String nome) {
        try {

            //crea un fichero de tipo dato 
            f = new FileOutputStream(nome + ".dat");
            //abro el fich en modo escritura y lo conecto con f 
            fich = new ObjectOutputStream(f);
            //asi solo se usa la variable fich y evitamos la f
            // fich= new ObjectOutputStream(new FileOutputStream(nome+".dat"));

            //bucle 
            for (int i = 0; i < 3; i++) {
                //hay que instanciar dentro del bucle el objeto para que guarde los objetos necesarios
                Alumno al = new Alumno(PedirDatos.cadena("nome"), PedirDatos.entero("nota"));
                fich.writeObject(al);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error : NO existe el fichero que quiere abrir");
        } catch (IOException ex) {
            System.out.println("Error; no se encuentra el fichero para escribir");
        } finally {
        //hay q cerrar los ficheros a la inversa de abrirlos para que no de error
            try {
                fich.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Error: no se pudo cerrar el fichero despues de escribir");
            }

        }
    }

}
