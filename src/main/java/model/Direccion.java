/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Direccion extends Pais {
    private String calle;
    private String ciudad;
    private int codPostal;
    private Pais pais;

    public Direccion() {
    }

    public Direccion(String calle, String ciudad, int codPostal, Pais pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
        this.pais = pais;
    }

    public Direccion(String calle, String ciudad, int codPostal, Pais pais, String nombre, String capital) {
        super(nombre, capital);
        this.calle = calle;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
        this.pais = pais;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return pais + "----Direccion----"+ "\n" + " calle=" + calle + "\n ciudad=" + ciudad + "\n codPostal=" + codPostal + "\n pais=";
    }


    

 
    
}
