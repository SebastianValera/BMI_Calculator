package com.example.bmicalculator;

/**
 * Dedicado a tener los diferentes tipos de peso
 */
enum IMC{
    UNDER_WEIGHT,NORMAL,OVER_WEIGHT,OBESE,MODERATELY_OBESE,SEVERELY_OBESE, VERY_SEVERELY_OBESE;
}

/**
 * Clase dedicada a mostrar la categoria de peso en la que corresponde el usuario
 */
public class IMCEnum {
    private static IMC imc;
    public IMCEnum (IMC imc) {this.imc = imc;}
    public static String getValue(IMC imc){
        String imcStr = "Sin valor";
        switch (imc){
            case UNDER_WEIGHT:
                imcStr = "RIESGO DE DESNUTRICIÓN";
                break;
            case NORMAL:
                imcStr = "PESO NORMAL";
                break;
            case OVER_WEIGHT:
                imcStr = "SOBREPESO";
                break;
            case OBESE:
                imcStr = "OBESIDAD";
                break;
            case MODERATELY_OBESE:
                imcStr = "GRADO DE OBESIDAD l";
                break;
            case SEVERELY_OBESE:
                imcStr = "GRADO DE OBESIDAD ll";
                break;
            case VERY_SEVERELY_OBESE:
                imcStr = "GRADO DE OBESIDAD lll";
                break;
        }
        return imcStr;
    }
}
