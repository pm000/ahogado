/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpahogado;

/**
 *
 * @author alejo
 */
public class TPahogado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Palabra palabra = new Palabra("hola");
        TurnoPalabra turnopalabra = new TurnoPalabra(palabra);
        Maquina maq1 = new Maquina(turnopalabra,"Maq1");
        Humano humano = new Humano(turnopalabra,"Pablo");
        new Thread(maq1).start();
        new Thread(humano).start();

    }
    
}
