/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author alejo
 */
public abstract class Jugador extends Observable implements Runnable{
        
    protected TurnoPalabra tp;
    
    //LISTA CON EL ABECEDARIO
    protected String[] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r"};
    //LISTA PARA GUARDAR LAS LETRAS QUE SE VAN TIRANDO
    protected List<String> letrasDadas;
    //LISTA PARA SABER QUE LETRAS SE ADIVINARON Y CUALES NO
    protected List<String> ubicacionLetrasAcertadas;
    
    protected String nombre;
    protected int vidas = 5;
    protected int jugadas = 0;
    protected int aciertos = 0;
    protected boolean ganador = false;
    
    public Jugador(TurnoPalabra tp, String nombre){
        this.tp = tp;
        this.nombre = nombre;      
        this.letrasDadas = new ArrayList<>();
        this.ubicacionLetrasAcertadas = new ArrayList<>();
        for (int i=0;i<getTp().getPalabra().cantidadLetras();i++){
            ubicacionLetrasAcertadas.add("-");
        }
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
     * @return the jugadas
     */
    public int getJugadas() {
        return jugadas;
    }

    /**
     * @param jugadas the jugadas to set
     */
    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    /**
     * @return the aciertos
     */
    public int getAciertos() {
        return aciertos;
    }

    /**
     * @param aciertos the aciertos to set
     */
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    
     
    
    
}
