/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 * Esta clase es la encargada de manejar las propiedades de los equipos de
 * ciclistas
 *
 * @author Admin
 * @version 1.0
 */
public class Equipo {

    private String nombre;
    private String codigo;
    private String anio;
    private double tienpo;
    private Ciclista[] ciclistas;

    public Equipo(String nombre, String codigo, String anio, double tienpo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.anio = anio;
        this.tienpo = tienpo;
        ciclistas = new Ciclista[9];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getTienpo() {
        return tienpo;
    }

    public void setTienpo(double tienpo) {
        this.tienpo = tienpo;
    }

    public Ciclista[] getCiclistas() {
        return ciclistas;
    }

    public void setCiclistas(Ciclista[] ciclistas) {
        this.ciclistas = ciclistas;
    }

    /**
     * Identificar posicion de ubicacion ciclista
     *
     * @param id Codigo unico que identifica al Ciclista
     * @return posicion si lo encuentra , -1 si no esta.
     */
    public int buscarCiclista(String id) {
        for (int i = 0; i < ciclistas.length; i++) {
            if (ciclistas[i] != null && ciclistas[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Agregar Ciclista
     * @param c
     * @return verdadero si pudo agregar el ciclista, falso sino
     */
    public boolean agregarCiclista(Ciclista c) {
        if (buscarCiclista(c.getId()) != -1) {
            System.err.println("No se puede agregar ciclista("+c.getNombre()+"), El codigo " + c.getId() + " ya fue asignado");
            return false;
        }

        for (int i = 0; i < ciclistas.length; i++) {
            if (ciclistas[i] == null) {
                ciclistas[i] = c;
                return true;
            }
        }

        return false;
    }
/**
 * Eliminar cilista
 * @param id
 * @return verdadero si se pudo eliminar , falso sino
 */
    public boolean eliminarCiclista(String id) {
        int posCiclista = buscarCiclista(id);
        if (posCiclista != -1) {
            ciclistas[posCiclista] = null;
            return true;
        }
        return false;
    }
    
/**
 * Contar cantidad de Ciclitas por Equipo
 * @return numero de ciclistas que tiene un equipo
 */    
    public int contarCiclistas(){
        int conteo = 0;
        for (int i = 0; i < ciclistas.length; i++) {
            if(ciclistas[i] != null){
                conteo++;
            }
        }        
        return conteo;
    }
    
    /**
     * Ubica el mejor Ciclista del Equipo en funcion del mejor tiempo
     * @return Objeto ciclista que tiene el mejor tiempo
     */
    public Ciclista liderEquipo(){
        Ciclista c = null;
        double mejor = Double.MAX_VALUE;
        for (int i = 0; i < ciclistas.length; i++) {
            if(ciclistas[i] != null){
                double tiempo = ciclistas[i].getTiempo();
                if(tiempo > 0 && tiempo < mejor){
                    mejor = tiempo;
                    c = ciclistas[i];
                }
            }
        }
        return c;
    }
    
    /**
     * Busca el ciclista de acuerdo al numer de camiseta
     * @param num numero de camiseta 
     * @return Objeto ciclita si es encontrado o de lo contrario null si el ciclista no esta en el equipo o no es encontrado
     */
    public Ciclista buscarPorNumero(int num){
        for (int i = 0; i < ciclistas.length; i++) {
            if(ciclistas[i] != null && ciclistas[i].getNum() == num ){
                return ciclistas[i];
            }
        }
        return null;
    }

}
