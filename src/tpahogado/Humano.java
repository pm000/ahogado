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
public class Humano extends Jugador{
      
    private List<String> letrasDadas;
    private int jugadas;
    private int aciertos;
    
    public Humano(TurnoPalabra tp, String nombre){
        super(tp,nombre);
        this.letrasDadas = new ArrayList();
        this.jugadas = 0;
        this.aciertos = 0;
    }

    public boolean buscarLetraEnPalabra(String letra){
    
        String palabra = getTp().getPalabra().getPalabra();
        for(int i=0;i<palabra.length();i++){
            if (palabra[i].equals(letra)){
                letrasDadas.add(letra);
                
            }
        
        
        }
    
    
    }
    
    
    @Override
    public void run()
    {
        try
        {
            //WHILE NO GANA NADIE
         //   {
                this.
                this.setLibroAlq(super.getBiblioteca().sacarLibro());
                System.out.println("El socio " + this.getNombre()+ " saco el libro "+this.getLibroAlq().getIdLibro());
                SocioLibro.sleep((long)aleatorio());

                super.getBiblioteca().devolverLibro(this.getLibroAlq());
                System.out.println("El socio " + this.getNombre()+ " devolvio el libro "+this.getLibroAlq().getIdLibro());
                SocioLibro.sleep((long)aleatorio());
          //}
        }
        catch (InterruptedException e){
        }
    }

    /**
     * @return the letrasDadas
     */
    public List<String> getLetrasDadas() {
        return letrasDadas;
    }

    /**
     * @param letrasDadas the letrasDadas to set
     */
    public void setLetrasDadas(String letrasDadas) {
        this.letrasDadas.add(letrasDadas);
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
