package TresEnRayaHumanoHumano;

public class TresEnRaya {


    public static void main(String[] args) {
        TresEnRaya tresEnRaya1 = new TresEnRaya();
        tresEnRaya1.lanzarJuego();
    }
    
    public  void lanzarJuego(){
        Tablero v1 = new Tablero();
        v1.setVisible(true);
    }
    
    public void salirJuego(){
        System.exit(0);
    }
    

}
