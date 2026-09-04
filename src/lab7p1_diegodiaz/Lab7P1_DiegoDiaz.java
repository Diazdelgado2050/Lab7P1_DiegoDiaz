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

    static char[][] tablero = new char[10][15];
    static char[][] tablerodos = new char[10][15];
    static char[] letrasFan = {'R', 'M', 'G'};
    static int movPacX, movPacY;
    static int[] movFanX = new int[3];
    static int[] movFanY = new int[3];
    static int puntos = 0;

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

            if (opcion == 1) {

            }

        } while (opcion != 2);

    }

    public static void iniciarJuego(Scanner leer, Random rnd) {
       

        boolean juegoTerminado = false;
        System.out.println("BIENVENIDO A PACMAN");

        while (!juegoTerminado) {
            int puntos = 0;
            System.out.println("Puntos" + puntos + "\n");
            printTablero();

            if (puntos >= 1000) {
                System.out.println("Felicidades llegaste a 1000 puntos, has ganado!");
                System.out.println("Puntuacion final: " + puntos + "\n");
                break;
           
            }
        }
    }

    private static void llenarMatrices() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                tablero[i][j] = '*';

            }
        }

    }

    public static void colocarElementos(Random rnd) {

        movPacX = rnd.nextInt(10);
        movPacY = rnd.nextInt(15);
        tablero[movPacX][movPacY] = 'C';
        tablerodos[movPacX][movPacY] = ' ';
        int obstaculos = 0;

        while (obstaculos < 8) {
            int f = rnd.nextInt(10);
            int c = rnd.nextInt(15);
            if (tablero[f][c] == '*') {
                tablero[f][c] = 'O';
                tablerodos[f][c] = 'O';
                obstaculos++;
            }

        }

        int fruta = 0;
        while (fruta < 2) {
            int f = rnd.nextInt(10);
            int c = rnd.nextInt(15);
            if (tablero[f][c] == '*') {
                tablero[f][c] = 'O';
                tablerodos[f][c] = 'O';
                fruta++;

            }
        }

        for (int i = 0; i < 3; i++) {
            boolean colocado = false;
            while (!colocado) {
                int f = rnd.nextInt(10);
                int c = rnd.nextInt(15);
                if (tablero[f][c] == '*') {
                    movFanX[i] = f;
                    movFanY[i] = c;
                    tablero[f][c] = letrasFan[i];

                    colocado = true;

                }
            }
        }

    }

    public static void printTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.println(tablero[i][j] + " ");

            }

        }
    }

    public static int[] Movimientos(char mov) {
        
        
        
        
        
        
        return null;
    }

    public static boolean moverFantasmas(Random rnd) {

        return false;

    }
}
