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
    
    public void update(Observable O, Object status){
    
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
