/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Persona implements Humano {
    private String nombre;
    private String apellido;
    private int cedula;
    private Direccion direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int cedula, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", direccion=" + direccion + '}';
    }
    
    

    @Override
    public void identificacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Validacion cedula ecuatoriana
    
    public boolean validar(String cedula) throws CedulaException {
 
        if (cedula == null || cedula.isEmpty()) {
            throw new CedulaException("La cédula no puede estar vacía");
        }
 
        //Solo se permiten números
        if (!cedula.matches("\\d+")) {
            throw new CedulaException("Solo se permiten números");
        }
 
        //debe tener exactamente 10 dígitos
        if (cedula.length() != 10) {
            throw new CedulaException("La cédula debe tener exactamente 10 dígitos.");
        }
 
        //Código de provincia válido (01-24)
        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            throw new CedulaException("El código de provincia no es válido.");
        }
 
        //Tercer dígito debe ser menor a 6 (persona natural)
        int tercerDigito = Character.getNumericValue(cedula.charAt(2));
        if (tercerDigito >= 6) {
            throw new CedulaException("El tercer dígito no corresponde a una cédula de persona natural.");
        }
 
        //Algoritmo módulo 10
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;
 
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i)) * coeficientes[i];
            if (digito > 9) {
                digito -= 9;
            }
            suma += digito;
        }
 
        int digitoVerificador = Character.getNumericValue(cedula.charAt(9));
        int residuo = suma % 10;
        int resultado = (residuo == 0) ? 0 : 10 - residuo;
 
        if (resultado != digitoVerificador) {
            throw new CedulaException("La cédula ingresada no es válida");
        }
 
        return true;
    }
    

}
