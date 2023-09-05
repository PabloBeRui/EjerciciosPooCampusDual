package com.campusdual.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Integer primo;

        System.out.println("Escribe un numero del 1 al 20");

        Scanner teclado = new Scanner(System.in);

        primo = teclado.nextInt();

        if (primo < 1 || primo > 20) {
            System.out.println("Espabila y lee el enunciado!");


        } else {
            switch (primo) {

                case 2:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                case 17:
                case 19:
                    System.out.println("Es primo!");
                    break;
                default:
                    System.out.println("No es primo");
                    break;


            }
        }
        

    }


}
