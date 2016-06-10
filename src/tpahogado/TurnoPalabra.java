/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author alejo
 */
public class TurnoPalabra implements Observer{
    
    private Palabra palabra;
    boolean disponible = true;
    boolean ganadorJuego = false;
    
    public TurnoPalabra(Palabra palabra){
        this.palabra = palabra;
    }
    
    public synchronized void dameTurno() throws InterruptedException{
        while(!disponible){
            wait();
        }
        disponible = false;
    }
    
    public synchronized  void devolverTurno() throws InterruptedException{
        disponible = true;
        notifyAll();
    }
    
    @Override
    public void update(Observable O, Object status){
        //VERIFICAR LAS 3 POSIBLE DESCONTE VIDA, PERDISTE O GANASTE
        Jugador jugador = (Jugador) O;
        if (jugador.getVidas() == 0){
            //PERDISTE
            System.out.println("PERDIO el jugador " + jugador.getNombre());
        }else{
            if (jugador.isGanador()){
                //HAY UN GANADOR
                this.ganadorJuego = true;
                System.out.println("GANO el jugador " + jugador.getNombre());
            }else{
                //SE DESCONTO UNA VIDA
                System.out.println("ERROR esa letra no existe en la palabra, al jugador " + jugador.getNombre() +" le quedan " + jugador.getVidas() + " vidas");
            }
        }
    }

    public boolean hayGanador(){
        return this.ganadorJuego;
    }
   
    /**
     * @return the palabra
     */
    public Palabra getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

}
