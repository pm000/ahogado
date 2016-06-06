/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejo
 */
public class Maquina extends Jugador{
       
    List<String> abecedario;
    List<String> letrasDadas;
    private int jugadas;
    private int aciertos;
    
    public void llenarAbecedario(){
    for(int caracter=97;caracter<=117;caracter++){
        abecedario.add(chrs(caracter));
        }
    }
    
    public Maquina(TurnoPalabra tp, String nombre){
        super(tp,nombre);
        this.abecedario = new ArrayList();
        this.letrasDadas = new ArrayList();
        this.jugadas = 0;
        this.aciertos = 0;
       // super(tp);
    }

    @Override
    public void run() {
        
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
