/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        // Objeto pais
        Pais p=new Pais();
        p.setNombre("Ecuador");
        p.setCapital("Quito");
        //Objeto direccion
        Direccion d= new Direccion();
        d.setCalle("Bolivar");
        d.setCiudad("Ibarra");
        d.setCodPostal(100100);
        d.setPais(p);
        
        
        System.out.println(d.toString());
        
    }
}
