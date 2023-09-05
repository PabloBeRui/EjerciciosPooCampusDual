package com.campusdual.ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Integer year;

        System.out.println("Escribe un año");

        Scanner teclado= new Scanner(System.in);

        year= teclado.nextInt();

        if (year%4== 0 && year%100!=0 || year%400==0 ){
            System.out.println("es año bisiesto");
        } else {
            System.out.println("Pues va a ser que no es bisiesto");
        }


    }
}
