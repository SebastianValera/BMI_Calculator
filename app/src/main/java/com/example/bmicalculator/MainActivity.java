package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod(){
        Button button = (Button) findViewById(R.id.BTN_Calculo);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Hace una instancia del objeto del EDT encargado de la altura
                final EditText heightText = (EditText) findViewById(R.id.EDT_M);
                //Obtiene el valor introducido por el usuario en una variable string
                String heightStr = heightText.getText().toString();
                //Transforma el texto a tipo double y lo guarda en una variable
                double height = Double.parseDouble(heightStr);
                //Haccec una instancia del objeto del EDT encargado del peso
                final EditText weightText = (EditText) findViewById(R.id.EDT_Kg);
                //Obtiene el vlor introducido por el usuario en una varible string
                String weightStr = weightText.getText().toString();
                //Transforma el texto a tipo double y lo guarda en una variable
                double weight = Double.parseDouble(weightStr);
                //Se obtiene el calculo de la formula general y el resultado
                //se guarda en una variable
                double BMI = (weight)/(height*height);
                //Hace una instancia del objeto del EDT encargado de mostrar el resultado
                final EditText BmiResult = (EditText) findViewById(R.id.EDT_BMI);
                //Hace una conversión de double a string y lo coloca como texto en el control
                BmiResult.setText(Double.toString(BMI));
                //Se crea una variable de tipo string con el fin de almacenar el mensaje
                //de la categoria a mostrar
                String BMI_Cat;
                //Se empiezan a hacer comparaciones dependiendo del valor de la variable "BMI"
                //para mostrar el mensaje correcto
                if (BMI < 15)
                    BMI_Cat = "Very severely underweight";
                else if (BMI < 16)
                    BMI_Cat = "Severely underweight";
                else if (BMI < 18.5)
                    BMI_Cat = "Underweight";
                else if (BMI < 25)
                    BMI_Cat = "Normal";
                else if (BMI < 30)
                    BMI_Cat = "Overweight";
                else if (BMI < 35)
                    BMI_Cat = "Obese Class 1 - Moderately Obese";
                else if (BMI < 40)
                    BMI_Cat = "Obese Class 2 - Severely Obese";
                else
                    BMI_Cat = "Obese Class 3 - Very Severely Obese";
                //Se hace instancia del static que se dedica a mostrar el mensaje
                final TextView BMICategory = (TextView) findViewById(R.id.STC_Categoria);
                BMICategory.setText(BMI_Cat);
            }
        });
    }
}
