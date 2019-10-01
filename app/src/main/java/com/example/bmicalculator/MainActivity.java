package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Creado por Humberto Sebastian Valera Castro el 30.09.19.
 */
public class MainActivity extends AppCompatActivity {


    private EditText heightText;
    private EditText weightText;
    private EditText BmiResult;
    private TextView BmiCategory;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcularIMC();
    }

    /**
     * Metodo dedicado a hacer instancia al boton dedicado a calcular la masa corporal
     * y se relaciona con el metodo que detecta "clic" al picarle al boton
     */
    private void btnCalcularIMC(){
        Button btnCalcularIMCResult = findViewById(R.id.BTN_Calculo);
        btnCalcularIMCResult.setOnClickListener(new BtnCalcularIMCEscuchador());
    }

    /**
     * Se implementa metodo dedicado a obtener y mostrar los resultados en la vista
     */
    class BtnCalcularIMCEscuchador implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            BmiCategory = findViewById(R.id.STC_Categoria);
            BmiResult = findViewById(R.id.EDT_BMI);
            weightText = findViewById(R.id.EDT_Kg);
            heightText = findViewById(R.id.EDT_M);
            String estaturaStr = heightText.getText().toString();
            String pesoStr = weightText.getText().toString();
            Double estaturaDbl = Double.parseDouble(estaturaStr);
            Double pesoDbl = Double.parseDouble(pesoStr);
            Double imc = calcularIMC(pesoDbl,estaturaDbl);
            BmiResult.setText(Double.toString(imc));
            BmiCategory.setText(getBMICategoria(imc));
        }
    }

    /**
     * Metodo que calcula el Indice de Masa Corporal
     * @param pesoDbl Peso de la persona
     * @param estaturaDbl Estatura de la persona
     * @return Indice de masa corporal en formato double
     */
    private Double calcularIMC(Double pesoDbl, Double estaturaDbl){
        Double imc = pesoDbl / (estaturaDbl * estaturaDbl);
        return imc;
    }

    /**
     * Metodo que calcula la categoria a partir del IMC
     * @param imc Indice de Masa Corporal en formato Double
     * @return categoria calculada en formato de cadena de Texto (string)
     */
    private String getBMICategoria(Double imc){
    IMC categoria;
    if (imc < 15) {
        categoria = IMC.VERY_SEVERELY_UNDER_WEIGHT;
    }else if (imc < 16){
        categoria = IMC.SEVERELY_UNDER_WEIGHT;
    }else if (imc < 18.5){
        categoria = IMC.UNDER_WEIGHT;
    }else if (imc < 20){
        categoria = IMC.NORMAL;
    }else if (imc < 30){
        categoria = IMC.OVER_WEIGHT;
    }else if (imc < 35){
        categoria = IMC.MODERATELY_OBESE;
    }else if (imc < 40){
        categoria = IMC.SEVERELY_OBESE;
    }else {
        categoria = IMC.VERY_SEVERELY_OBESE;
    }
    return IMCEnum.getValue(categoria);
    }
}
