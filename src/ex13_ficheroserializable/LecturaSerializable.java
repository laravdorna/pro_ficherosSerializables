/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13_ficheroserializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lvazquezdorna
 */
public class LecturaSerializable {

    ObjectInputStream ler;
    FileInputStream f;
    Alumno al;

    //metodo para leer un fichero serializado 
    public void leerSerializado(String nombre) {

        try {
            //instanciar los ficheros de lectura
            f = new FileInputStream(nombre + ".dat");
            ler = new ObjectInputStream(f);
            al = (Alumno) ler.readObject();

            while (al != null) {
                System.out.println(al);
                al = (Alumno) ler.readObject();
            }
//buscar el codigo de fin de fichero para cerrar y que no salte la excepcion
        } catch (ClassNotFoundException ex) {
            System.out.println("La clase no existe " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("error no exite el fichero que quiere leer" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error: No se encuentra el fichero que quiere leer");
        } finally {
            try {
                ler.close();
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(LecturaSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
