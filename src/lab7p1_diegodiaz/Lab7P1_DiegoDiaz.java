/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_diegodiaz;

import java.util.Random;
import java.util.Scanner;

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
        Scanner leer = new Scanner(System.in);
        Random rnd = new Random();
        int opcion;
        do {
            System.out.println("==Menu PACMAN :V==");
            System.out.println("1. PACMAN");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = leer.nextInt();

            if (opcion == 1) {
                puntos = 0;
                iniciarJuego(leer, rnd);

            }
        } while (opcion != 2);
    }

    public static void iniciarJuego(Scanner leer, Random rnd) {
        llenarMatrices();
        colocarElementos(rnd);

        boolean juegoTerminado = false;
        System.out.println("BIENVENIDO A PACMAN");

        while (!juegoTerminado) {
            System.out.println("Puntos: " + puntos + "\n");
            printTablero();

            if (puntos >= 1000) {
                System.out.println("Felicidades llegaste a 1000 puntos, has ganado!");
                System.out.println("Tu puntuacion final es: " + puntos + " ");
                break;
            }
            System.out.println("ESCOGE TU JUGADA!");
            System.out.print("W, S, A, D: ");
            char mov = leer.next().charAt(0);
            mov = Character.toLowerCase(mov);

            if (mov != 'w' && mov != 's' && mov != 'a' && mov != 'd') {
                continue;
            }

            int[] resultado = MovimientosPac(mov);
            puntos = resultado[0];

            if (resultado[2] == 1) {
                System.out.println("Obstaculo!");
                continue;
            }

            if (resultado[1] == 1) {
                printTablero();
                System.out.println("Fuiste atrapado, has perdido :(");
                System.out.println("Puntuacion final: " + puntos + "\n");
                break;

            }
            boolean atrapado = moverFantasmas(rnd);
            if (atrapado) {
                printTablero();
                System.out.println("\nFuiste atrapado, has perdido!");
                System.out.println("Puntuacion final: " + puntos + "\n");
                break;
            }
        }

    }

    public static void llenarMatrices() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                tablero[i][j] = '*';
                tablerodos[i][j] = '*';
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
        while (fruta < 1) {
            int f = rnd.nextInt(10);
            int c = rnd.nextInt(15);
            if (tablero[f][c] == '*') {
                tablero[f][c] = 'B';
                tablerodos[f][c] = 'B';
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
                System.out.print(tablero[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static int[] MovimientosPac(char mov) {
        int posX = movPacX;
        int posY = movPacY;

        if (mov == 'w') {
            posX = (movPacX - 1 + 10) % 10;
        } else if (mov == 's') {
            posX = (movPacX + 1) % 10;
        } else if (mov == 'a') {
            posY = (movPacY - 1 + 15) % 15;
        } else if (mov == 'd') {
            posY = (movPacY + 1) % 15;
        }
        if (tablero[posX][posY] == 'O') {

            return new int[]{puntos, 0, 1};
        }
        if (tablero[posX][posY] == 'R' || tablero[posX][posY] == 'M' || tablero[posX][posY] == 'G') {
            return new int[]{puntos, 1, 0};
        }
        if (tablerodos[posX][posY] == '*') {
            puntos += 50;
        } else if (tablerodos[posX][posY] == 'B') {
            puntos += 150;
        }

        tablero[movPacX][movPacY] = ' ';
        tablerodos[movPacX][movPacY] = ' ';

        movPacX = posX;
        movPacY = posY;
        tablero[movPacX][posY] = 'C';
        tablerodos[posX][posY] = ' ';

        return new int[]{puntos, 0, 0};

    }

    public static boolean moverFantasmas(Random rnd) {

        for (int i = 0; i < 3; i++) {
            int posFan = rnd.nextInt(4);
            int posX = movFanX[i];
            int posY = movFanY[i];

            if (posFan == 0) {
                posX = (movFanX[i] - 1 + 10) % 10;
            } else if (posFan == 1) {
                posX = (movFanX[i] + 1) % 10;
            } else if (posFan == 2) {
                posY = (movFanY[i] - 1 + 15) % 15;
            } else if (posFan == 3) {
                posY = (movFanY[i] + 1) % 15;
            }

            if (tablero[posX][posY] == 'O' || tablero[posX][posY] == 'R' || tablero[posX][posY] == 'M' || tablero[posX][posY] == 'G') {
                continue;

            }
            if (tablero[posX][posY] == 'C') {
                return true;
            }

            tablero[movFanX[i]][movFanY[i]] = tablerodos[movFanX[i]][movFanY[i]];

            movFanX[i] = posX;
            movFanY[i] = posY;
            tablero[movFanX[i]][movFanY[i]] = letrasFan[i];

        }
        return false;
    }
}
