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

        String[] opciones = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            opciones[i] = lista.get(i)[1]; // nombre del país
        }
        for (String[] pais : lista) {
            System.out.println(
                    pais[1]
            );

        }
        String paisSeleccionado = (String) JOptionPane.showInputDialog(
        null,
        "Escoja su país",
        "PAÍSES",
        JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[0]
);

System.out.println("Seleccionó: " + paisSeleccionado);

PaisControlador pc = new PaisControlador();

// 1. Pedir los datos al usuario mediante JOptionPane
String idEditarInput = JOptionPane.showInputDialog("Ingrese el ID del país que desea EDITAR:");

if (idEditarInput != null && !idEditarInput.isEmpty()) {
    int idEditar = Integer.parseInt(idEditarInput); // Convertimos el ID a número
    
    String nuevoNombre = JOptionPane.showInputDialog("Ingrese el NUEVO nombre del país:");
    String nuevaCapital = JOptionPane.showInputDialog("Ingrese la NUEVA capital del país:");
    
    // 2. Crear el objeto Pais con los nuevos datos (tu modelo no usa ID)
    Pais datosNuevos = new Pais(nuevoNombre, nuevaCapital);
    
    // 3. Llamar al controlador pasando el ID y el objeto por separado
    pc.editarPais(idEditar, datosNuevos); 
}

// 1. Pedir el ID al usuario mediante JOptionPane
String idEliminarInput = JOptionPane.showInputDialog("Ingrese el ID del país que desea ELIMINAR:");

if (idEliminarInput != null && !idEliminarInput.isEmpty()) {
    int idEliminar = Integer.parseInt(idEliminarInput); // Convertimos el ID a número
    
    // 2. Confirmación rápida de seguridad
    int confirmar = JOptionPane.showConfirmDialog(null, 
            "¿Seguro que desea eliminar el país con ID: " + idEliminar + "?", 
            "Confirmar", JOptionPane.YES_NO_OPTION);
            
    if (confirmar == JOptionPane.YES_OPTION) {
        // 3. Llamar al controlador pasando solo el ID
        pc.eliminarPais(idEliminar); 
    }
}

    }
}
