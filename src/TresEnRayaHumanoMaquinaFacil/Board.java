/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRayaHumanoMaquinaFacil;

import TresEnRayaHumanoMaquina.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author ramos
 */
public class Board {
    public static final Random RANDOM = new Random();
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    
    private int [][]board = new int[3][3];
    
    public static Point movimientoComputadora;
    
    public boolean seAcaboElJuego(){
        return alguienGano(PLAYER_X) || alguienGano(PLAYER_O) || getCeldasDisponibles().isEmpty();
    }

    public boolean alguienGano(int player) {
       //buscamos si gano algun jugador en de manera diagonal
       if((board[0][0]== board[1][1] && board[0][0]==board[2][2] && board[0][0]==player)||
               (board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]==player)){
           return true;
       }
       //buscamos si gano algun jugador en de manera horizonatl y vertical
       for(int i=0;i<3;i++){
           if((board[i][0]== board[i][1] && board[i][0]==board[i][2] && board[i][0]==player)||
               (board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]==player)){
                return true;
            }
       }
       return false;
    }
    //esta funcion devuelve todas las celdas disponibles en el tablero
    public List<Point> getCeldasDisponibles(){
        List<Point> availableCells = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //buscamos en la matriz los espacios que tengan el valor de NO_PLAYER 
                if(board[i][j]==NO_PLAYER){
                    availableCells.add(new Point(i,j));
                }
            }
        }
        return availableCells;
    }
    //esta funcion se encarga de hacer un movimiento de cualquier jugador
    public boolean hacerUnMovimiento(Point point,int player){
        if(board[point.x][point.y]!=NO_PLAYER){
            return false;
        }
        board[point.x][point.y] = player;
        return true;
    }
    
    public void mostrarTablero(){
        System.out.println("");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String value = "?";
                if(board[i][j]==PLAYER_X){
                    value="X";
                }
                else if(board[i][j]==PLAYER_O){
                    value="O";
                }
                System.out.print(value+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //este metodo solo se encarga de hacer un movimiento aleatorio
    //en puntos donde aun no se marco
    public void moverAleatorio(){
        int i = 0;
        List<Point> celdasDisponibles = getCeldasDisponibles();
        Point p = new Point(RANDOM.nextInt(3),RANDOM.nextInt(3));
        while(celdasDisponibles.isEmpty() != true &&seAcaboElJuego() != true ){
            if(p.x == celdasDisponibles.get(i).x && p.y == celdasDisponibles.get(i).y 
                    && board[p.x][p.y] == NO_PLAYER){
                movimientoComputadora = p;
                break;
            }
            else{
                p = new Point(RANDOM.nextInt(3),RANDOM.nextInt(3));
                i=i+1;
                if(i == celdasDisponibles.size()-1){
                    i=0;
                }
            }
        }
    }
    //utilizamos este metodo para limpiar el tablero de todas las jugadas
    //este metodo es utilizado en la GUI al pulsar el boton reiniciar
    public void limpiar(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=NO_PLAYER;
            }
        }
    }
    
    
}
