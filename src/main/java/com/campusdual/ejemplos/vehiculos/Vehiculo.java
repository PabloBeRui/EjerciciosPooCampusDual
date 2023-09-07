package com.campusdual.ejemplos.vehiculos;

public abstract class Vehiculo {

    private Integer pasajeros;

    private Integer velocidadMax;

    private Integer potencia;

    private String marca;


    abstract void getDetails();

    public Integer calcularMovimiento(Integer segundos) {

        return ((velocidadMax * segundos) - (potencia / pasajeros));
    }


}
