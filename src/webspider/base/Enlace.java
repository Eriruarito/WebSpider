/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspider.base;

/**
 *
 * @author lachi
 */
public class Enlace {
    public int numero;
    public String enlaceWeb;
    public String tipoEnlace;
    
    public Enlace(int numero, String enlaceWeb, String tipoEnlace){
        this.numero = numero;
        this.enlaceWeb = enlaceWeb;
        this.tipoEnlace = tipoEnlace;
    }
    
}
        
