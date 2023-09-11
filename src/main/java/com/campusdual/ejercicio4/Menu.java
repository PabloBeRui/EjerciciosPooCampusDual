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
    private static final Scanner scanner = new Scanner(System.in);

    private static Diet actualDiet;

    private static Food lechuga = new Food(1, 0, 0, "Leituga");
    private static Food callos = new Food(800, 20, 30, "callos");

    private static ArrayList<Food> foodList = new ArrayList<>(Arrays.asList(lechuga, callos));


    private static String anotherFood;  //variable para menu de añador más alimentos

    public static void main(String[] args) {
//        foodMenu();
        //  addFood();
        menuInit();
    }

    private static void foodMenu() {


        System.out.println("\u001B[34m╔══════════════════════════════════════════════════╗");
        System.out.println("\u001B[34m║    Crear/reiniciar dieta: crea o remplaza la     ║");
        System.out.println("\u001B[34m║                dieta inicial                     ║");
        System.out.println("\u001B[34m╚══════════════════════════════════════════════════╝");
        System.out.println("\n");
        System.out.println("1-Sin limite");
        System.out.println("2-Por calorías");
        System.out.println("3-Por macronutrientes");
        System.out.println("4-Por datos personales");
        System.out.println("5- Volver al Menú principal");

        Integer menuNum = scanner.nextInt();

        switch (menuNum) {
            case 1:
                System.out.println("Sin limite");
                actualDiet = new Diet();
                System.out.println("\u001B[32m---------------------------------------------------");
                System.out.println("\u001B[32m|               Elegido: Sin límites              |");
                System.out.println("\u001B[32m---------------------------------------------------");
                System.out.println("\n");
                menuInit();
                break;
            case 2:
                System.out.println("Por calorías");
                System.out.println("Introduce calorías");
                System.out.println("\n");
                Integer maxCalories = scanner.nextInt();
                actualDiet = new Diet(maxCalories);
                System.out.println("\u001B[34m-----------------------------------------------------");
                System.out.println("\u001B[34m* Elegido: límite de calorías: " + maxCalories);
                System.out.println("\u001B[34m-----------------------------------------------------");

                System.out.println("\n");
                menuInit();
                break;
            case 3:
                System.out.println("Por macronutrientes");
                System.out.println("Introduce Carbohidratos");
                Integer maxCarbs = scanner.nextInt();
                System.out.println("Introduce Grasas");
                Integer maxFats = scanner.nextInt();
                System.out.println("Introduce Proteínas");
                Integer maxProtein = scanner.nextInt();
                System.out.println("\n");
                actualDiet = new Diet(maxFats, maxCarbs, maxProtein);
                System.out.println("\u001B[34m-----------------------------------------------------");
                System.out.println("\u001B[34mElegido: Por macronutrientes: " +
                        "\nMáximo Carbohidratos: " + maxCarbs +
                        "\nMáximo Grasas: " + maxFats +
                        "\nMáximo Proteínas: " + maxProtein);
                System.out.println("\u001B[34m-----------------------------------------------------");

                System.out.println("\n");
                menuInit();
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
                        System.out.println("Por favor, introduce hombre o mujer");
                    }
                } while (!gender.equalsIgnoreCase("mujer") && !gender.equalsIgnoreCase("hombre"));
                System.out.println("Cuantos años tienes?");
                int age = scanner.nextInt();
                System.out.println("Altura en cm?");
                int height = scanner.nextInt();
                System.out.println("¿Cuántos Kg pesas");
                int weight = scanner.nextInt();

                actualDiet = new Diet(women, age, height, weight);

                System.out.println("\u001B[34m-----------------------------------------------------");
                System.out.println("\u001B[34mElegido: Por Datos personales: " +
                        "\nEdad: " + age +
                        "\nAltura en cm: " + height +
                        "\nPeso en Kg: " + weight);
                System.out.println("\u001B[34m-----------------------------------------------------");

                System.out.println("\n");
                break;
            case (5):
                menuInit();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    //!  MENU 3
    private static void addFood() {

        System.out.println("\u001B[34m╔══════════════════════════════════════════════════╗");
        System.out.println("\u001B[34m║        Agregar alimento a la dieta               ║");
        System.out.println("\u001B[34m╚══════════════════════════════════════════════════╝");

        System.out.println("\n");
        System.out.println("a. Nuevo alimento");
        System.out.println("b. Alimento existente");
        System.out.println("c. Volver al Menu principal");
        String menu = scanner.nextLine();

        if (menu.equalsIgnoreCase("a")) {
            System.out.println("Añade el nombre del alimento");
            String foodName = scanner.nextLine();
            System.out.println("Añade Carbohidratos por 100 gramos");
            Integer setCarbos = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Añade Grasas por 100 gramos");
            Integer setFats = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Añade Proteínas por 100 gramos");
            Integer setProteins = scanner.nextInt();
            scanner.nextLine();
            System.out.println("¿Cuantos gramos?");
            Integer setWeight = scanner.nextInt();
            scanner.nextLine();
//! dame gramos
            Food foodInfo = new Food(setCarbos, setFats, setProteins, foodName);


//! Añadi el un método estático en el que ya hace el add
            Diet.addFoodToDietList(foodName);
            Diet.addWeightToWeight(setWeight);
            Diet.printDietDetails();
            foodList.add(foodInfo);


            for (Food food : foodList) {
                System.out.println(food.getFoodName());
            }

            // Eliminado scanner.nextLine(); de aquí


            do {
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
            System.out.println("\u001B[34m╔════════════════════════════════════════════════════╗");
            System.out.println("\u001B[34m║ Elige un alimento entre los siguientes:            ║");
            System.out.println("\u001B[34m╚════════════════════════════════════════════════════╝");
            for (Food food : foodList) {
                System.out.println(food.getFoodName());
            }
            System.out.println("\n");
            String selectedFood = scanner.nextLine();
            Boolean finded = false;
            for (Food food : foodList) {

                if (food.getFoodName().equalsIgnoreCase(selectedFood)) {
                    finded = true;
                    System.out.println("Has añadido " + selectedFood + " correctamente");
//                    foodToDietList.add(food);
                    System.out.println(food.getFoodName());
                }
            }
            if (!finded) {
                System.out.println("Alimento no encontrado");
            }
            do {
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
        if (menu.equalsIgnoreCase("c")) {
            menuInit();
        } else {
            System.out.println("\n");
            System.out.println("*************************************************");
            System.out.println("* Por favor, escoge una opción válida: a, b, o c*");
            System.out.println("************************************************" +
                    " *");
            System.out.println("\n");
            addFood();


        }
    }


    //! VAMOS A POR EL MENU PRINCIPAL

    public static void menuInit() {

        System.out.println("\n");
        System.out.println("\u001B[38;2;255;165;0m╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("\u001B[38;2;255;165;0m║                           Menú Principal                             ║");
        System.out.println("\u001B[38;2;255;165;0m╚══════════════════════════════════════════════════════════════════════╝");

        ;

        System.out.println("\n");
        System.out.println("Menu Inicial");
        System.out.println("\n");
        System.out.println("Elige una opción del 1 al 4, por favor");
        System.out.println("1. Crear/reiniciar dieta: crea o remplaza la dieta inicial");
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
        System.out.println("3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible");
        System.out.println("4. Salir");
        System.out.println("\n");
        Integer chooseNum = scanner.nextInt();
        scanner.nextLine();
        switch (chooseNum) {
            case (1):
                foodMenu();
                break;
            case (2):
                break;
            case (3):
                addFood();
                break;
            case (4):
                System.out.println("  _  ");
                System.out.println(" ('v')");
                System.out.println("-=-<");
                System.out.println("(\")_\"");
                System.out.println(" Bye Bye!");


                break;
            default:
                System.out.println("\u001B[34m-------------------------------------------------");
                System.out.println("\u001B[34mPor favor, escribe un número válido");
                System.out.println("\u001B[34m-------------------------------------------------");
                System.out.println("\n");
                menuInit();
        }


    }
    //!MENU 2


}



