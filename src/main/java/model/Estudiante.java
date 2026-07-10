/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Estudiante extends Persona {
    private int idEstudiante;

    public Estudiante() {
    }


    public Estudiante(int idEstudiante, String nombre, String apellido, int cedula, Direccion direccion) {
        super(nombre, apellido, cedula, direccion);
        this.idEstudiante = idEstudiante;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString() {
        return """
               ---Estudiante---
               Nombres:"""+getNombre()+"\n"+
                "Apellidos:"+getApellido()+"\n"+
                "Direccion:"+getDireccion()+"\n"+
                 "Cedula:"+getCedula()+"\n";
    }

    @Override
    public void identificacion() {
        System.out.println("");
    }

    void setCedula(String cedula) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
}
