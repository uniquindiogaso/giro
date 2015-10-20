/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giro;

import gui.Interfaz;
import java.util.ArrayList;
import logica.Ciclista;
import logica.Equipo;
import logica.GiroItalia;

/**
 *
 * @author Admin
 */
public class Giro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }

    /**
     * Utilizado para llenar datos al ejecutarse la app
     */
    public static void test() {
        GiroItalia giro = new GiroItalia("2001");

        Equipo e1 = new Equipo("claro", "0", "1", 1983);
        e1.agregarCiclista(new Ciclista("Jose David", "1", 19, 999, 1));
        e1.agregarCiclista(new Ciclista("Pedro", "2", 19, 999, 2));
        e1.agregarCiclista(new Ciclista("jjj", "3", 19, 30, 3));
        e1.agregarCiclista(new Ciclista("aaa", "4", 19, 999, 4));
        e1.agregarCiclista(new Ciclista("aaa", "5", 19, 69, 5));

        Equipo e2 = new Equipo("movistar", "1", "6", 1578);
        e2.agregarCiclista(new Ciclista("Pepe", "7", 19, 999, 6));
        e2.agregarCiclista(new Ciclista("Ricardiño", "8", 19, 21, 7));
        e2.agregarCiclista(new Ciclista("aa", "9", 19, 77, 8));
        e2.agregarCiclista(new Ciclista("bb", "10", 19, 999, 9));

        giro.agregarEquipo(e1);
        giro.agregarEquipo(e2);

        ArrayList<Equipo> equipos = giro.getEquipos();

        for (Equipo equipo : equipos) {
            if (equipo != null) {
                System.out.print(equipo.getCodigo() + "\t");
            } else {
                System.out.print("vacio " + "\t");
            }
            System.out.println();
        }

        System.out.println(giro.adicionarTiempoCiclista(1, 6));
    }

}
