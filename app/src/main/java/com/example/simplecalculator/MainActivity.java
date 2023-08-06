package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarando Variaveis
    EditText edtValue1,edtValue2;
    Button btnSum,btnSubtraction,btnMultiplication,btnDivision,btnResult;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Metodo para referenciar as variaveis ao layout
        initComponents();

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Tratamento de erro
                try {
                    methodSum();
                    Toast.makeText(MainActivity.this,"Sucesso",Toast.LENGTH_LONG).show();
                }catch (Exception E){
                    Toast.makeText(MainActivity.this,"Erro",Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void methodSum() {

        String valor1 = edtValue1.getText().toString();
        String valor2 = edtValue2.getText().toString();

        // Substitui a vírgula pelo ponto
        valor1 = valor1.replace(',', '.');
        valor2 = valor2.replace(',', '.');

        Double numero1 = Double.parseDouble(valor1);
        Double numero2 = Double.parseDouble(valor2);

        Double result = numero1 + numero2;

        txtResult.setText(String.valueOf(result));

    }


    private void initComponents() {

        edtValue1 = findViewById(R.id.edtValue1);
        edtValue2 = findViewById(R.id.edtValue2);
        btnSum = findViewById(R.id.btnSum);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnDivision = findViewById(R.id.btnDivision);
        btnResult = findViewById(R.id.btnResult);
        txtResult = findViewById(R.id.txtResult);
    }
}