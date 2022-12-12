package com.cesur.examenaddicc22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

class Ejercicio1 {

    /**
     * Enunciado:
     * 
     * Completar el método estadísticasDeArchivo de manera que lea el archivo
     * de texto que se le pasa como parámetro, lo analice y muestre por consola 
     * el número de caracteres, palabras y líneas total.
     * 
     * Modificar solo el código del método.
     * 
     */
    
    static void solucion() {

        estadísticasDeArchivo("pom.xml");
    }

    private static void estadísticasDeArchivo(String archivo) {
        
    	String nuevotexto = "";
    	
BufferedReader in = null;
try {
	in = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\AlbertoMoralesGálvez\\OneDrive - Cesur-GCoremsa\\Escritorio\\token"+".txt"), "utf-8"));
} catch (UnsupportedEncodingException e) {

	e.printStackTrace();
} catch (FileNotFoundException e) {

	e.printStackTrace();
}
				  Scanner sc = new Scanner(in);
				  
				  while(sc.hasNextLine()) {
					
					nuevotexto+=sc.nextLine()+" ";
						  
				  }
				  sc.close();   
				  
		String texto = nuevotexto;
         String[] palabras23 = texto.split("");
           ArrayList caracteres2 = new ArrayList();
 
           
         
        
        for (int i = 0; i<palabras23.length; i++){
      
                    caracteres2.add(palabras23[i]);
        }
              
        System.out.println("Numero de caracteres: "+caracteres2.size());
        System.out.println();
   
        String[] palabras2 = texto.split(" ");
         ArrayList caracteres = new ArrayList();
 
        
        for (int i = 0; i<palabras2.length; i++){
      
                    caracteres.add(palabras2[i]);
        }
              
              System.out.println("Nummero de palabras: "+caracteres.size());
        System.out.println();
       
     int count = 0;

    try {
      File file = new File("C:\\Users\\AlbertoMoralesGálvez\\OneDrive - Cesur-GCoremsa\\Escritorio\\token.txt");

                try (Scanner src = new Scanner(file)) {
                    while(src.hasNextLine()) {
                        src.nextLine();
                        count++;
                    }
                    System.out.println("Numero de lineas totales: " + count);
                }
    } catch (Exception e) {
      e.getStackTrace();
          
    
}
    }
  
    
    }

