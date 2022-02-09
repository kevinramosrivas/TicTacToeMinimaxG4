/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TresEnRayaHumanoMaquina;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ramos
 */
public class Board {
    
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    
    
    
    private int [][]board = new int[3][3];
    
    public Point movimientoComputadora;
    
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
    // por profundidad se entiende al nivel al que se encuentra en un arbol recursivo
    public int minimax(int profundidad,int turno){
        //en caso de ganar MAX(X) la computadora -> retornamos 1
        // en caso de ganar MIN(O) el usuario -> retorna -1
        
        
        // en este caso la computadora ocupa la ficha x y el jugador humano la ficha o
        //como estamos usando un algoritmo recursivo estas son las condiciones inciales
        if(alguienGano(PLAYER_X))
            return 1;
        if(alguienGano(PLAYER_O))
            return -1;
        //obtenemos todas las celdas disponibles en las que la computadora 
        //podra hacer sus movimientos
        List<Point> celdasDisponibles = getCeldasDisponibles();
        
        //si es que no hay celdad y nadie gano significa un empate simbolizado 
        // por cero
        if(celdasDisponibles.isEmpty())
            return 0;
        //obtenermos los valores mas pequeños y mas grande respectivamente
        //que nos puede ofrecer java como valores iniciales
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<celdasDisponibles.size();i++){
            Point point = celdasDisponibles.get(i);
            //como vamos a generar todo el arbol de forma recursiva esta condicion se dara cuando
            //es turno del jugador x
            if(turno == PLAYER_X){
                hacerUnMovimiento(point,PLAYER_X);
                int puntajeActual = minimax(profundidad+1,PLAYER_O);
                //utilizamos Math.max para comparar cual es mayor
                // si el anterior valor max o el nuevo obtenido de puntajeActual
                //utilizamos esto para maximizar la jugada de X 
                max = Math.max(puntajeActual,max);
                // si ya se hallo la puntuacion de toda una rama del arbol recursivo
                if(profundidad == 0){
                    System.out.println("Puntaje de la computadora para la posicion: "+point+"="+puntajeActual);
                }
                // si en el punto escogido nos genero una victoria o empate              
                // segun la funcion de evaluacion
                if(puntajeActual >= 0){
                    if(profundidad == 0){
                        movimientoComputadora = point;
                    }
                }
                // si hubo una victoria volvemos la celda que utilizamos 
                // a su valor inicial NO_PLAYER
                if(puntajeActual == 1){
                    board[point.x][point.y] = NO_PLAYER;
                    break;
                }
                //si acabamos todas las posibilidades de puntos disponibles 
                // escogemos el punto que quede
                if(i==celdasDisponibles.size()-1 && max<0){
                    if(profundidad==0){
                        movimientoComputadora = point;
                    }
                }
            }
            //si es turno de O esta condicion se cumplira
            //marcaremos en el tablero la jugada de O
            else if(turno == PLAYER_O){
                hacerUnMovimiento(point,PLAYER_O);
                int puntajeActual = minimax(profundidad+1,PLAYER_X);
                //utilizamos Math.min para comparar cual es menor
                // si el anterior valor min o el nuevo obtenido de puntajeActual
                //utilizamos esto para minimizar la jugada de X 
                min = Math.min(puntajeActual,min);
                
                if(min == -1){
                    board[point.x][point.y] = NO_PLAYER;    
                }
            }
            //como modificamos el tablero al analizar las diferentes posiciones 
            // volvemos los valores a su estado inicial NO_PLAYER
            board[point.x][point.y]=NO_PLAYER;
        }
        //ya que utilizamos un algoritmo recursivo retornamo
        // si en caso es turno del jugador x(la computadora) retornamos el max
        // en caso de que no se cumple la condicion retornamos el valor min
        return turno == PLAYER_X ? max:min;
    
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
