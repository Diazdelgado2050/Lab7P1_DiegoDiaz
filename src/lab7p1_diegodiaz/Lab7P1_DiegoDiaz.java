/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_diegodiaz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Lab7P1_DiegoDiaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        Random rnd = new Random();
        int opcion;
        do {
            
            System.out.println("==Menu==");
            System.out.println("1. PACMAN");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = leer.nextInt();
            
            
            
            
        } while (opcion != 2);
        
        
        
        
    }
    
}
