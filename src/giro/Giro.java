/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giro;

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
        GiroItalia giro = new GiroItalia("2001");
        
        Equipo e1 = new Equipo("claro","0", "1", 1983);
        e1.agregarCiclista(new Ciclista("Jose David", "1", 19, 999, 1));
        e1.agregarCiclista(new Ciclista("Pedro", "2", 19, 999, 1));
        e1.agregarCiclista(new Ciclista("Juaquin", "3", 19, 999, 1));
        e1.agregarCiclista(new Ciclista("Juaquin", "4", 19, 999, 1));
        e1.agregarCiclista(new Ciclista("Juaquin", "5", 19, 999, 1));
        
          
        Equipo e2 = new Equipo("movistar","1","2",1578);
        e2.agregarCiclista(new Ciclista("Pepe", "1", 19, 999, 1));
        e2.agregarCiclista(new Ciclista("Ricardiño", "2", 19, 999, 1));
        e2.agregarCiclista(new Ciclista("aa", "3", 19, 999, 1));
        e2.agregarCiclista(new Ciclista("bb", "4", 19, 999, 1));
        
        
        giro.agregarEquipo(e1);
        giro.agregarEquipo(e2);
        
        
        
        Equipo equipos[][] = giro.getEquipos();
             
         for (int i = 0; i < equipos.length; i++) {
            for (int j = 0; j < equipos.length; j++){
                
                if (equipos[i][j]!=null) {
                    System.out.print(equipos[i][j].getCodigo()+"\t");
                }else{
                    System.out.print("vacio "+ "\t");
                }
   
            }
            
             System.out.println();
         }
         
         System.out.println("El equipo con mas ciclistas es : "+giro.buscaEquipoMasCiclistas().getNombre());
         
    }
    
    
    
}
