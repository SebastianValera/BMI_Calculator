package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    //Controles
    private Bundle datos;
    private TextView tvImc;
    private TextView tvCategoria;
    private TextView tvObservaciones;

    /**
     * Constructor de la clase
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        tvImc = (TextView)findViewById(R.id.STC_IMC);
        tvCategoria = (TextView)findViewById(R.id.STC_Categoria);
        tvObservaciones = (TextView)findViewById(R.id.STC_Observaciones);
        datos = getIntent().getExtras();
        tvImc.setText(datos.getString("imc"));
        tvCategoria.setText(datos.getString("categoria"));
        tvObservaciones.setText(getObservaciones(datos.getString("categoria")));
    }

    /**
     * Metodo dedicado a regresar las observaciones de acuerdo a la categoria mandada.
     * @param categoria string que indica que categoria pertenece el usuario
     * @return string con las observaciones que se recomiendan al usuario.
     */
    public String getObservaciones(String categoria){
        String observaciones = "";
        switch (categoria){
            case "RIESGO DE DESNUTRICIÓN":
                observaciones = "1-Realiza 3 comidas al dia repletas de proteina, carbohidratos y grasa.\n" +
                        "2-Evita consumir muchas verduras ya que son saciantes y llenan tu estomago.\n" +
                        "3-Toma leche.\n" +
                        "4-Evita beber agua antes de comidas, ya que tu estomago se llenara de agua.\n" +
                        "5-Dormir 8 horas diarias.";
                break;
            case "PESO NORMAL":
                observaciones = "1-Desayunar pequeño per satisfactorio por la mañana.\n" +
                        "2-Comer alimentos asados o al vapor en lugar de empanizados.\n" +
                        "3-Dormir 8 horas diarias.\n" +
                        "4-Reducir la ingestion de carbohidratos, comiendo alimentos mas saludables y legeros.\n" +
                        "5-Tener una rutina de ejercicio.\n";
                break;
            case "SOBREPESO": case "OBESIDAD": case "GRADO DE OBESIDAD l": case "GRADO DE OBESIDAD ll": case "GRADO DE OBESIDAD lll":
                observaciones = "1-Realizar 3 comidas principales.\n" +
                        "2-Establecer un horario de comidas y evitar comer fuera de ellas.\n" +
                        "3-Verificar si no existen problemas de salud que interfieras con la alimentacion.\n" +
                        "4-Fomentar la actividad física diaria.\n" +
                        "5-Restringir alimentos procesados y bebidas con alto azucar, sal y grasas, realizando una dieta de verduras, frutos, granos enteros, leguminosas, comida casera y agua simple.";
                break;
        }
        return observaciones;
    }
}
