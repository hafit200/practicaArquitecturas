/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ConexionBDD;
import java.util.ArrayList;
import controlador.PaisControlador;
import java.util.HashSet;
import javax.swing.JOptionPane;
import model.CedulaException;
import model.Direccion;
import model.Estudiante;
import model.Pais;

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        // Objeto pais
//        Pais p = new Pais();
//        p.setNombre(JOptionPane.showInputDialog("Ingrese el  nombre de su pais:"));
//        p.setCapital(JOptionPane.showInputDialog("Ingrese el  nombre de la capital:"));
//        
//        PaisControlador pc=new PaisControlador();
//        pc.insertarPais(p);

//        //Objeto direccion
//        Direccion d = new Direccion();
//        d.setCalle("Bolivar");
//        d.setCiudad("Ibarra");
//        d.setCodPostal(100100);
//        d.setPais(p);
//
//        System.out.println(d.toString());
//        //Estudiante
//        Estudiante e = new Estudiante();
//        e.setNombre(JOptionPane.showInputDialog("Ingrese sus nombres:"));
//        e.setApellido(JOptionPane.showInputDialog("Ingrese sus Apellido:"));
//        Direccion dir = new Direccion();
//        dir.setCalle(JOptionPane.showInputDialog("Ingrese su direccion"));
//        dir.setCiudad(JOptionPane.showInputDialog("Ingrese su ciudad"));
//        dir.setCodPostal(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su codigo postal")));
//        dir.setPais(p);
//
//
//        e.setDireccion(dir);
//        String cedula = JOptionPane.showInputDialog("Ingrese su cédula");
//
//        try {
//            if (e.validar(cedula)) {
//                e.setCedula(Integer.parseInt(cedula));
//                JOptionPane.showMessageDialog(null, "Cédula válida");
//            }
//        } catch (CedulaException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        JOptionPane.showMessageDialog(null, e.toString());
        ////testing conexxion

//        ConexionBDD prueba=new ConexionBDD();
//        prueba.conectar();
       PaisControlador deber = new PaisControlador();

        ArrayList<String[]> lista = deber.obtenerPaises();

        for (String[] pais : lista) {
            System.out.println(
                    pais[0] + " - "
                    + pais[1] + " - "
                    + pais[2]
            );
        }

    }
}
