/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * Esta clase es la encargada de manejar las propiedades del cilcista 
 * @author Admin
 * @version 1.0
 */
public class Ciclista {
    
    private String nombre;
    private String id;
    private int edad;
    private double tiempo;
    private int  num;

    public Ciclista(String nombre, String id, int edad, double tiempo, int num) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.tiempo = tiempo;
        this.num = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
   
    
}
