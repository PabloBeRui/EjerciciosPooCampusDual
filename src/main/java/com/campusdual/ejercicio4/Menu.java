package com.campusdual.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
* --Escribe un programa que utilice la clase Dieta y despliegue un menú donde puedas añadir alimentos. El menú tendrá las siguientes opciones.
	-1. Crear/reiniciar dieta: crea o remplaza la dieta inicial
		-a. Sin limite
		-b. Por calorías
		-c. Por macronutrientes
		-d. Por datos personales
	-2. Mostrar información: muestra calorías y macronutrientes de la dieta
	-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible
		-a. Nuevo alimento
		-b. Alimento existente
	-4. Salir
*
 */


public class Menu {

    private static Diet actualDiet;

    private static Food lechuga = new Food(1, 0, 0, "Leituga");
    private static Food callos = new Food(800, 20, 30, "callos");

    private static ArrayList<Food> foodList = new ArrayList<>(Arrays.asList(lechuga, callos));
    private static ArrayList<Food> foodToDietList = new ArrayList<>();

//    private static ArrayList<Diet> dietList = new ArrayList<>();

    private static String anotherFood;  //variable para menu de añador más alimentos

    public static void main(String[] args) {
//        foodMenu();
        addFood();
    }

    private static void foodMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Crear/reiniciar dieta: crea o remplaza la dieta inicial");
        System.out.println("1-Sin limite");
        System.out.println("2-Por calorías");
        System.out.println("3-Por macronutrientes");
        System.out.println("4-Por datos personales");

        Integer menuNum = scanner.nextInt();

        switch (menuNum) {
            case 1:
                System.out.println("Sin limite");
                actualDiet = new Diet();
                break;
            case 2:
                System.out.println("Por calorías");
                System.out.println("Fanegas, introduce calorías");
                Integer maxCalories = scanner.nextInt();
                actualDiet = new Diet(maxCalories);
                break;
            case 3:
                System.out.println("Por macronutrientes");
                System.out.println("Fanegas, introduce Carbohidratos");
                Integer maxCarbs = scanner.nextInt();
                System.out.println("Fanegas, introduce Grasas");
                Integer maxFats = scanner.nextInt();
                System.out.println("Fanegas, introduce Proteínas");
                Integer maxProtein = scanner.nextInt();
                actualDiet = new Diet(maxFats, maxCarbs, maxProtein);
                break;
            case 4:
                boolean women = false;
                System.out.println("Por datos personales");
                scanner.nextLine(); // Consumir el newline
                String gender;
                do {
                    System.out.println("¿Eres hombre o mujer?");
                    gender = scanner.nextLine();

                    if (gender.equalsIgnoreCase("mujer")) {
                        women = true;
                        break;
                    } else if (gender.equalsIgnoreCase("hombre")) {
                        women = false;
                        break;
                    } else {
                        System.out.println("Escribe bien, por favor");
                    }
                } while (!gender.equalsIgnoreCase("mujer") && !gender.equalsIgnoreCase("hombre"));
                System.out.println("Cuantos años tienes?");
                int age = scanner.nextInt();
                System.out.println("Altura en cm?");
                int height = scanner.nextInt();
                System.out.println("¿Cuántos Kg pesas (sin trampas)");
                int weight = scanner.nextInt();

                actualDiet = new Diet(women, age, height, weight);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    //!  MENU 3
    private static void addFood() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Agregar alimento a la dieta");
        System.out.println("a. Nuevo alimento");
        System.out.println("b. Alimento existente");
        String menu = scanner.nextLine();
        if (menu.equalsIgnoreCase("a")) {
            System.out.println("Añade el nombre del alimento");
            String foodName = scanner.nextLine();
            System.out.println("Añade Carbohidratos");
            Integer setCarbos = scanner.nextInt();
            System.out.println("Añade Grasas");
            Integer setFats = scanner.nextInt();
            System.out.println("Añade Proteínas");
            Integer setProteins = scanner.nextInt();

            Food foodname = new Food(setCarbos, setFats, setProteins, foodName);

            foodList.add(foodname);

            for (Food food : foodList) {
                System.out.println(food.getFoodName());
            }


// ! añadir más?

            do {
                scanner.nextLine();

                System.out.println("Deseas añadir otro Alimento?");

                anotherFood = scanner.nextLine();


                if (anotherFood.equalsIgnoreCase("si")) {
                    addFood();
                } else if (anotherFood.equalsIgnoreCase("no")) {

                    break;
                } else {

                    System.out.println("Escribe bien, por favor");
                }
            } while (!anotherFood.equalsIgnoreCase("si") && !anotherFood.equalsIgnoreCase("no"));
        }

        // System.out.println(foodList);

        for (Food food : foodList) {
            System.out.println(food.getFoodName());
        }

        if (menu.equalsIgnoreCase("b")) {
            System.out.println("Elige un alimento entre de los siguientes:");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            for (Food food : foodList) {
                System.out.println(food.getFoodName());
            }
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            String selectedFood = scanner.nextLine();
            for (Food food : foodList) {

                if (food.getFoodName().equalsIgnoreCase(selectedFood)) {

                    System.out.println("Has añadido " + selectedFood + " correctamente");
                    foodToDietList.add(food);
                    System.out.println(food.getFoodName());
                }
//                 else {
//                    System.out.println("Alimento no encontrado");
            }


            do {
//                scanner.nextLine();

                System.out.println("Deseas añadir otro Alimento?");

                anotherFood = scanner.nextLine();


                if (anotherFood.equalsIgnoreCase("si")) {
                    addFood();
                } else if (anotherFood.equalsIgnoreCase("no")) {

                    break;
                } else {

                    System.out.println("Escribe bien, por favor");
                }
            } while (!anotherFood.equalsIgnoreCase("si") && !anotherFood.equalsIgnoreCase("no"));
        }


    }
}



