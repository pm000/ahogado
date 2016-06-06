/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.Observable;

/**
 *
 * @author alejo
 */
public abstract class Jugador extends Observable,Thread implements Runnable{
        
    private TurnoPalabra tp;
    private String nombre;
    private int vidas;
    
    public Jugador(TurnoPalabra tp, String nombre){
        this.tp = tp;
        this.nombre = nombre;
        this.vidas = 5;
    }

    abstract public void run();   
    
    /**
     * @return the tp
     */
    public TurnoPalabra getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(TurnoPalabra tp) {
        this.tp = tp;
    }

    /**
     * @return the vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * @param vidas the vidas to set
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
