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

    public Maquina(TurnoPalabra tp, String nombre){
        super(tp,nombre);
    }

    @Override
    public void run() {
        while(!tp.hayGanador() && (vidas > 0)){
            tp.dameTurno();
            jugarLetra(buscarLetraAlAzar());
        
            
            
            tp.devolverTurno();
        }
     
            //observame che hay q poner las instrucciones para observer
               
        
    }

    public int elejirNumeroRandom(int limite){
        //Math.random()*ValorLimite+ValorInicial
        return (int) Math.random()*limite;
    }
    
    public String buscarLetraAlAzar(){
        //contains(X) -> Retorna true si existe el elemento X en el ArrayList.
        int numero = elejirNumeroRandom(abecedario.length);
        String letra = abecedario[numero];
        while (letrasDadas.contains(letra)){
            numero = elejirNumeroRandom(abecedario.length);
            letra = abecedario[numero];
        }
        return letra;
    }
    
    public boolean seGanoONo(){
    if (ubicacionLetrasAcertadas.contains("-"))
        return false;
    else
        return true;
    }
    
    public void jugarLetra(String letra){
        if (vidas > 0){
            jugadas++;
            String palabra = getTp().getPalabra().getPalabra();
            int posicion = palabra.indexOf(letra);
            //GUARDO LA LETRA JUGADA
            letrasDadas.add(letra);
            if (posicion != -1){
                //ESTA LETRA SE ENCUENTRA A LO SUMO UNA VEZ EN LA PALABRA BUSCADA
                //SUMO UN ACIERTO
                aciertos++;
                //MARCO LA POSICION ACERTADA EN LA PALABRA
                ubicacionLetrasAcertadas.set(posicion,"*");
                //ME FIJO SI LA MISMA LETRA ESTA MÁS VECES EN LA PALABRA      
                while (posicion != -1){
                    posicion = palabra.indexOf(letra);
                    ubicacionLetrasAcertadas.set(posicion,"*");
                }
            }else{
                if (posicion == -1){
                    //LA LETRA NO ESTA EN LA PALABRA
                    //DESCUENTO LA VIDA
                    vidas--;
                }
            }
        }

    }
    
    
}
