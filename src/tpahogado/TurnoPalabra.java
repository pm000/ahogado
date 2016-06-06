/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

//import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author alejo
 */
public class TurnoPalabra implements Observer{
    
    private Palabra palabra;
    private Hashtable palabraVisual = new Hashtable <String,String>();
      
    public TurnoPalabra(Palabra palabra){
        this.palabra = palabra;
        for(int i=0;i<=palabra.cantidadLetras();i++){
            palabraVisual.put(i, "-");
        }
    }
    
    
    public void ponerOkLetraPalabra(int lugar){
        palabraVisual
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

    /**
     * @return the palabraVisual
     */
    public List<String> getPalabraVisual() {
        return palabraVisual;
    }

    /**
     * @param palabraVisual the palabraVisual to set
     */
    public void setPalabraVisual(List<String> palabraVisual) {
        this.palabraVisual = palabraVisual;
    }
}
