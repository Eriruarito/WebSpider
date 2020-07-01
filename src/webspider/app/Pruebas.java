/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspider.app;

import webspider.logic.Logic;

/**
 *
 * @author lachi
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String html = Logic.getHtml("https://www.flaticon.es/packs/black-friday-81");
        System.out.println(html);
        //System.out.println(Logic.getEnlaces(html, "<img", "src='").toString());
        Logic.guardarLista(Logic.getEnlaces(html, "<img", "src='"), "C:\\Users\\lachi\\Documents\\Carpeta1\\Carpeta2\\Carpeta3\\enlaces.data");*/
        Logic.getWebArchivo("https://media.flaticon.com/dist/min/img/apple-icon-120x120-precomposed.png", "C:\\Users\\lachi\\Documents\\foto");
    }
    
}
