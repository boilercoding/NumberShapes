package com.boilercoding.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class NumberShape {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;

            }

            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numberShapeIs(View view) {
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);
        NumberShape numberShape = new NumberShape();
        String message = "";

        if (numberEditText.getText().toString().isEmpty()) {
            message = "Please Enter A Number";
        } else {
            numberShape.number = Integer.parseInt(numberEditText.getText().toString());

            if (numberShape.isSquare()) {
                if (numberShape.isTriangular()) {
                    message = numberShape.number + " is both triangular and square!";
                } else {
                    message = numberShape.number + " is square but not triangular.";
                }
            } else {
                if (numberShape.isTriangular()) {
                    message = numberShape.number + " is triangular but not square.";
                } else {
                    message = numberShape.number + " is neither square nor triangular.";
                }
            }
        }

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
