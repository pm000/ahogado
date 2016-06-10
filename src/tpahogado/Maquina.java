/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejo
 */
public class Maquina extends Jugador{

    public Maquina(TurnoPalabra tp, String nombre){
        super(tp,nombre);
        addObserver(tp);
    }

    @Override
    public void run() {
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
                
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int elejirNumeroRandom(int limite){
                                System.out.println("elejirNumeroRandom");
                              limite = limite - 1;
        int aux;
        aux = (int)Math.ceil(Math.random()*limite);       
        return aux;
    }
    
    public String buscarLetraAlAzar(){
                        System.out.println("buscarLetraAlAzar");
        //contains(X) -> Retorna true si existe el elemento X en el ArrayList.
        int numero = this.elejirNumeroRandom(abecedario.length);                    //ojo
     System.out.println("salio ");
                     System.out.println("elejirNumeroRandom " + numero);
        String letra = this.abecedario[numero];
        
        while (this.letrasDadas.contains(letra)){
            numero = this.elejirNumeroRandom(this.abecedario.length);               //ojo
            letra = this.abecedario[numero];
        }
        System.out.println("La maquina ingreso la letra: " + letra);
        return letra;
    }
    
    
    public void imprimirArrayList(){
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
            System.out.println("1 - Jugarletra");
        if (this.vidas > 0){
            //SUMO UNA JUGADA REALIZADA
            this.jugadas++;
            String palabra = getTp().getPalabra().getPalabra();
            int posicion = palabra.indexOf(letra);
            //GUARDO LA LETRA JUGADA
            this.letrasDadas.add(letra);
            if (posicion != -1){
                System.out.println("    LA LETRA ESTA EN LA PALABRA");
                //ESTA LETRA SE ENCUENTRA A LO SUMO UNA VEZ EN LA PALABRA BUSCADA
                //SUMO UN ACIERTO
                this.aciertos++;
                //MARCO LA POSICION ACERTADA EN LA PALABRA
                
                
                
                                System.out.println("entro1");
                            //    imprimirArrayList();
                this.ubicacionLetrasAcertadas.set(posicion,"*");                        //ojo
                //ME FIJO SI LA MISMA LETRA ESTA MÁS VECES EN LA PALABRA  
                
                int posicion2 = palabra.indexOf(letra);
                while ((posicion2 != -1) && (posicion2> posicion)){

                    this.ubicacionLetrasAcertadas.set(posicion,"*");
                    posicion = posicion2;
                                        posicion2 = palabra.indexOf(letra);
                }
                
                                System.out.print("MAQUINA ");
                    imprimirArrayList();

                
                
            }else{
                if (posicion == -1){
                    System.out.println("    LA letra NO esta");
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
