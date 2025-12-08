package com.algomesti.intro.app;

public class CalculadoraCortisol {

    private static final double cortisolMin = 6.0;
    private static final double cortisolMax = 18.4;

    public static void main (String[] args) {

        double cortisol = 182.2;

        boolean resultadoNormal = cortisol >= cortisolMin && cortisol <= cortisolMax;
        boolean resultadoAnormal = !resultadoNormal;

        System.out.println("Cortisol normal: " + resultadoNormal);
        System.out.println("Cortisol Anormal: " + resultadoAnormal);

    }

}
