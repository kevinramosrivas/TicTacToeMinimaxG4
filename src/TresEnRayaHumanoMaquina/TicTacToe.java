/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRayaHumanoMaquina;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ramos
 */
// esta es una implementacion sin interfaz grafica
public class TicTacToe {
    public static final Random RANDOM = new Random();
    public static void main(String args[]){
        Board b = new Board();
        Scanner scanner = new Scanner(System.in);
        b.mostrarTablero();
        System.out.println("Selecciona tu turno 1.COMPUTADORA(X) 2.USUARIO(O)");
        
        int choice = scanner.nextInt();
        if(choice == Board.PLAYER_X){
            Point p = new Point(RANDOM.nextInt(3),RANDOM.nextInt(3));
            b.hacerUnMovimiento(p,Board.PLAYER_X);
            b.mostrarTablero();
        }
        while(!b.seAcaboElJuego()){
            boolean moveOk = true;
            do{
                if(!moveOk){
                    System.out.println("esta celda no esta disponible");
                    
                }
                System.out.println("Tu movimiento:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Point userMove  = new Point(x-1,y-1);
                moveOk = b.hacerUnMovimiento(userMove,Board.PLAYER_O);
            }while(!moveOk);
            b.mostrarTablero();
            
            if(b.seAcaboElJuego())
                break;
            b.minimax(0,Board.PLAYER_X);
            System.out.println("La computadora escogio: "+b.movimientoComputadora);
            b.hacerUnMovimiento(b.movimientoComputadora,Board.PLAYER_X);
            b.mostrarTablero();
        }
        if(b.alguienGano(Board.PLAYER_X)){
            System.out.println("TU PIERDES");
        }
        else if(b.alguienGano(Board.PLAYER_O)){
            System.out.println("TU GANAS");
        }
        else{
            System.out.println("EMPATE");
        }
        
    }
    
}
