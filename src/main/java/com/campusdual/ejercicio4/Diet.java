package com.campusdual.ejercicio4;

import java.util.ArrayList;

/*
* Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos y calcule cuentas calorías, carbohidratos, proteinas y grasas genera la ingesta
La clase dieta tiene que tener las siguientes funcionalidades:
	-Diet(): crea una dieta sin límite de calorías
	-Diet(Integer maxCalories): crea una dieta con un máximo de calorías, en cuanto se supera ese máximo cuando se adjunta un alimento se despliega un error
	-Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein): crea una dieta con un máximo de estos tres valores, si se supera alguno de ellos cuando se adjunta un alimento se indicara cual y desplegará un error
	-Diet(Boolean women, Integer age, Integer height, Integer weight): Calcula el metabolismo basal de la persona y lo asigna como máximo de calorías en la dieta
		--CALCULAR METABOLISMO BASAL
			E = edad
			A = altura en centímetros
			P = peso en kilos

			Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
			Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161
	-addFood(Food,Integer): agrega un alimento y una cantidad en gramos
	-getTotalCalories(): devuelve el total de calorías
	-getTotalCarbs(): devuelve el total de carbohidratos
	-getTotalFats(): devuelve el total de grasas
	-getTotalProtein(): devuelve el total de proteinas
*
* */
public class Diet {

    private Integer totalCalories = 0;
    private Integer totalFats = 0;
    private Integer totalCarbs = 0;
    private Integer totalProteins = 0;
    private Integer maxCalories;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;
    private boolean women;
    private Integer age;
    private Integer height;
    private Integer weight;

    private static ArrayList<Food> foodToDietList = new ArrayList<>();

    private static ArrayList<Integer> foodToDietWeight = new ArrayList<>();


    //Constructores

    public Diet() {

    }

    public Diet(Integer maxCalories) {
        this.maxCalories = maxCalories;
    }

    public Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProtein = maxProtein;
    }

    public Diet(boolean women, Integer age, Integer height, Integer weight) {
        this.women = women;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }


    // GETTERS y SETTERS


    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public Integer getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(Integer totalFats) {
        this.totalFats = totalFats;
    }

    public Integer getTotalCarbs() {
        return totalCarbs;
    }

    public void setTotalCarbs(Integer totalCarbs) {
        this.totalCarbs = totalCarbs;
    }

    public Integer getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(Integer totalProteins) {
        this.totalProteins = totalProteins;
    }

    public Integer getMaxCalories() {
        return maxCalories;
    }

    public void setMaxCalories(Integer maxCalories) {
        this.maxCalories = maxCalories;
    }

    public Integer getMaxFats() {
        return maxFats;
    }

    public void setMaxFats(Integer maxFats) {
        this.maxFats = maxFats;
    }

    public Integer getMaxCarbs() {
        return maxCarbs;
    }

    public void setMaxCarbs(Integer maxCarbs) {
        this.maxCarbs = maxCarbs;
    }

    public Integer getMaxProtein() {
        return maxProtein;
    }

    public void setMaxProtein(Integer maxProtein) {
        this.maxProtein = maxProtein;
    }

    public boolean isWomen() {
        return women;
    }

    public void setWomen(boolean women) {
        this.women = women;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


    //METODOS

    public Integer basalMetabolism(Boolean women, Integer age, Integer height, Integer weight) {

        return women ? (weight * 10) + (int) (height * 6.25) - (age * 5) - 161 : (weight * 10) + (int) (height * 6.25) - (age * 5) + 5;


    }

    //!  Añado a los arraylist el alimento y el peso  a cada uno
    public static void addFoodToDietList(Food food) {
        foodToDietList.add(food);
    }

    public static void addWeightToWeight(Integer setWeight) {
        foodToDietWeight.add(setWeight);
    }
//! hago un método para leer los 2 arrays

    public static void printDietDetails() {

        System.out.println("\u001B[32m---------------------------------------------------");
        System.out.println("\u001B[32m|           Elementos añadido a Dieta             |");
        System.out.println("\u001B[32m---------------------------------------------------");
        System.out.println("\n");

        System.out.println("Lista de alimentos:");
        for (int i = 0; i < foodToDietList.size(); i++) {
            System.out.println(foodToDietList.get(i) + " - Peso: " + foodToDietWeight.get(i) + " gramos");
        }
    }

// Metodo para añadir food y sus propiedades y el peso

    /*public static void addPropertiesToDietProperties(Food foodInfo, Integer setWeight) {
    }
*/
}
