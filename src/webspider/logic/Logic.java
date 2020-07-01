/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webspider.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import webspider.base.Base;
import webspider.base.Enlace;

/**
 *
 * @author lachi
 */
public class Logic {
    
    public static String getHtml(String enlaceWeb) {
	StringBuilder texto = new StringBuilder("");
	try {
            URL url = new URL(enlaceWeb);
            URLConnection urlConexion = url.openConnection();
            urlConexion.connect();
            BufferedReader pagina = new BufferedReader(
                                    new InputStreamReader(
                                    urlConexion.getInputStream()), Base.BYTES);
            String linea;
            while ((linea = pagina.readLine()) != null)texto.append(linea);
            pagina.close();
	} catch (Exception e) {
	}
            return texto.toString();
    }
    
    public static List<String> getEnlacesWeb(String html, String etiqueta, String buscar) {
	List<String> enlaces = new ArrayList<String>();
        html = html.replaceAll("\"", "'");
	int posicion = html.indexOf(etiqueta);
	while (posicion != -1) {
            String enlace = html.substring(posicion + etiqueta.length());
            enlace = enlace.substring(enlace.indexOf(buscar) + buscar.length());
            enlace = enlace.substring(0, enlace.indexOf("'"));
            if(!enlace.contains(".jpg") && !enlace.contains(".jpeg") && !enlace.contains(".png") &&
               !enlace.contains(".gif") && !enlace.contains(".js")   && !enlace.contains(".css") && enlace.contains("http"))
               enlaces.add(enlace);
            html = html.substring(posicion + buscar.length());
            posicion = html.indexOf(buscar);
	}
	return enlaces;
    }
    
    public static List<String> getEnlacesImg(String html, String etiqueta, String buscar) {
	List<String> enlaces = new ArrayList<String>();
        html = html.replaceAll("\"", "'");
	int posicion = html.indexOf(etiqueta);
	while (posicion != -1) {
            String enlace = html.substring(posicion + etiqueta.length());
            enlace = enlace.substring(enlace.indexOf(buscar) + buscar.length());
            enlace = enlace.substring(0, enlace.indexOf("'"));
            if(enlace.contains(".jpg") && enlace.contains("http"))
            enlaces.add(enlace);
            if(enlace.contains(".jpeg") && enlace.contains("http"))
            enlaces.add(enlace);
            if(enlace.contains(".gif") && enlace.contains("http"))
            enlaces.add(enlace);
            if(enlace.contains(".png") && enlace.contains("http"))
            enlaces.add(enlace);
            html = html.substring(posicion + buscar.length());
            posicion = html.indexOf(buscar);
	}
	return enlaces;
    }
    
    public static List<String> getEnlacesJs(String html, String etiqueta, String buscar) {
	List<String> enlaces = new ArrayList<String>();
        html = html.replaceAll("\"", "'");
	int posicion = html.indexOf(etiqueta);
	while (posicion != -1) {
            String enlace = html.substring(posicion + etiqueta.length());
            enlace = enlace.substring(enlace.indexOf(buscar) + buscar.length());
            enlace = enlace.substring(0, enlace.indexOf("'"));
            if(enlace.contains(".js") && enlace.contains("http"))
               enlaces.add(enlace);
            html = html.substring(posicion + buscar.length());
            posicion = html.indexOf(buscar);
	}
	return enlaces;
    }
    
    public static List<String> getEnlacesCss(String html, String etiqueta, String buscar) {
	List<String> enlaces = new ArrayList<String>();
        html = html.replaceAll("\"", "'");
	int posicion = html.indexOf(etiqueta);
	while (posicion != -1) {
            String enlace = html.substring(posicion + etiqueta.length());
            enlace = enlace.substring(enlace.indexOf(buscar) + buscar.length());
            enlace = enlace.substring(0, enlace.indexOf("'"));
            if(enlace.contains(".css") && enlace.contains("http"))
               enlaces.add(enlace);
            html = html.substring(posicion + buscar.length());
            posicion = html.indexOf(buscar);
	}
	return enlaces;
    }
    
    public static List<String> getEnlacesMulti(String html, String etiqueta, String buscar) {
	List<String> enlaces = new ArrayList<String>();
        html = html.replaceAll("\"", "'");
	int posicion = html.indexOf(etiqueta);
	while (posicion != -1) {
            String enlace = html.substring(posicion + etiqueta.length());
            enlace = enlace.substring(enlace.indexOf(buscar) + buscar.length());
            enlace = enlace.substring(0, enlace.indexOf("'"));
            if(enlace.contains("http"))
               enlaces.add(enlace);
            html = html.substring(posicion + buscar.length());
            posicion = html.indexOf(buscar);
	}
	return enlaces;
    }
    
    public static String getName(String enlace){
        int posicion = enlace.indexOf("//");
        String enlace2 = enlace.substring(posicion + 2);
        enlace2 = enlace2.substring(0, enlace2.indexOf("/"));
    return enlace2;   
    }
    
    public static void guardarLista(List<String> lista, String nombreArchivo) {
	guardarLista(lista, new File(nombreArchivo));
    }
    
    public static void guardarLista(List<String> lista, File nombreArchivo) {
        try {
            PrintWriter archivo = new PrintWriter(new FileWriter(nombreArchivo));
            for (String elemento : lista) {
                archivo.println(elemento.toString());
            }
            archivo.close();
	} catch(IOException ioe) {			
	}
    }
    
    public static void getWebArchivo(String enlaceWeb, String nombreArchivo) {
	System.out.println("Descargando: " + enlaceWeb);
	try {
            URL url = new URL(enlaceWeb);
            URLConnection urlConexion = url.openConnection();
            urlConexion.addRequestProperty("User-Agent", "");
            urlConexion.setReadTimeout(Base.RETARDO_MILISEGUNDOS);
            urlConexion.connect();
            InputStream documento = urlConexion.getInputStream();
            FileOutputStream guardar = new FileOutputStream(nombreArchivo);
            byte[] array = new byte[Base.BYTES];
            int leido = 0;
            while ((leido = documento.read(array)) > 0) {
		guardar.write(array, 0, leido);
		guardar.flush();
            }
            documento.close();
            guardar.close();
        } catch (Exception ioe) {
        }
    }
    
    public static ArrayList<String> leerArhivoTextoLista(String nombreArchivo) {
	return leerArhivoTextoLista(new File(nombreArchivo));
    }
    
    public static ArrayList<String> leerArhivoTextoLista(File nombreArchivo) {
	BufferedReader archivo = null;
	ArrayList<String> lista = new ArrayList<String>();
	try {
            archivo = new BufferedReader(new FileReader(nombreArchivo));
            String linea = "";
            while (linea != null) {
		linea = archivo.readLine();
		if (linea != null) {
                    lista.add(linea);
		}
            }
            archivo.close();
	} catch (IOException ioe) {
	}
            return lista;
    }      
}
