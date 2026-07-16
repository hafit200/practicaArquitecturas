/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Asus
 */
public class File {

    public File() {
    }
    public static void main(String[] args) {
//        try {
//            FileWriter writer=new FileWriter("mi archivo.txt");
//            writer.write("Hola MUNDO FILES");
//            writer.close();
//            
////            FileReader reader=new FileReader("mi archivo.txt");
////            BufferedReader bufferedReader=new BufferedReader(reader);
////            String linea;
////            while((linea=bufferedReader.readLine())!=null){
////                System.out.println(linea);
////            }
////            bufferedReader.close();
////            reader.close();
//        } catch (IOException e) {
//            System.out.println("Error al manejar el fichero"+e.getMessage());
//        }
//    }
    
    PDF pdf=new PDF();
    pdf.btnPDFActionPerformed("Mi primer pdf");
}}
