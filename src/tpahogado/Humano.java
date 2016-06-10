/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejo
 */
public class Humano extends Jugador{
          
    public Humano(TurnoPalabra tp, String nombre){
        super(tp,nombre);
        addObserver(tp);
    }
    
    @Override
    public void run(){
        try {
            while(!this.tp.hayGanador() && (this.vidas > 0)){
                this.tp.dameTurno();
                this.jugarLetra(buscarLetraAlAzar());
                if (this.seGanoONo()){
                    this.setGanador(true);
                    //NOTIFICAR QUE GANASTE
                    setChanged();
                    notifyObservers();
                }
            this.tp.devolverTurno();
            Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Humano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buscarLetraAlAzar() throws IOException{
        
        System.out.println("Ingresar una letra: ");
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String letra = lee.readLine();
        System.out.println("El HUMANO ingreso la letra: " + letra);
        return letra;
    }
    
    public void imprimirArrayList(){
        System.out.print("HUMANO");
        Iterator it = ubicacionLetrasAcertadas.iterator(); 
        while ( it.hasNext() ) { 
            Object objeto = it.next(); 
            String caracter = (String)objeto; 
            System.out.print(caracter + "/"); 
        } 
    }
    
    public boolean seGanoONo(){
        if (this.ubicacionLetrasAcertadas.contains("-"))
            return false;
        
        return true;
    }
    
    public void jugarLetra(String letra){
        if (this.vidas > 0){
            //SUMO UNA JUGADA REALIZADA
            this.jugadas++;
            String palabra = getTp().getPalabra().getPalabra();
            int posicion = palabra.indexOf(letra);
            //GUARDO LA LETRA JUGADA
            this.letrasDadas.add(letra);
            if (posicion != -1){
                //ESTA LETRA SE ENCUENTRA A LO SUMO UNA VEZ EN LA PALABRA BUSCADA
                //SUMO UN ACIERTO
                this.aciertos++;
                //MARCO LA POSICION ACERTADA EN LA PALABRA
                 this.ubicacionLetrasAcertadas.set(posicion,"*");                    
                //ME FIJO SI LA MISMA LETRA ESTA MÁS VECES EN LA PALABRA  
                int posicion2 = palabra.indexOf(letra);
                while ((posicion2 != -1) && (posicion2> posicion)){
                    this.ubicacionLetrasAcertadas.set(posicion,"*");
                    posicion = posicion2;
                    posicion2 = palabra.indexOf(letra);
                }
                imprimirArrayList();
            }else{
                if (posicion == -1){
                    //LA LETRA NO ESTA EN LA PALABRA
                    //DESCUENTO LA VIDA
                    this.vidas--;
                    //NOTIFICAR QUE PERDISTE UNA VIDA
                    setChanged();
                    notifyObservers();
                }
            }
        }
        else{
            if (this.vidas == 0){
                //NOTIFICAR QUE PERDISTE
                setChanged();
                notifyObservers();
            }
        }
    }
    
}
