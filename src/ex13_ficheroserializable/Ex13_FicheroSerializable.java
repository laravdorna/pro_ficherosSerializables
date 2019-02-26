/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13_ficheroserializable;

/**
 *
 * @author Lara Vazquez Dorna
 */
public class Ex13_FicheroSerializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EscrituraSerializable obxEss = new EscrituraSerializable();
        obxEss.escribirObxetosSerie("notaAlummos");
        LecturaSerializable obxLec = new LecturaSerializable();
        obxLec.leerSerializado("notaAlummos");
    }
    
}
