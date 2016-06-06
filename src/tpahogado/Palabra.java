/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.Objects;

/**
 *
 * @author alejo
 */
public class Palabra {
    
    private String palabra;
    
    public Palabra(String palabra){
        this. palabra = palabra;
    }
    
    public int cantidadLetras(){
        return this.palabra.length();
    }
   
    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
