package com.devdroid.roombase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTitle, editAmount;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.text1);
        editAmount = findViewById(R.id.text2);
        buttonAdd = findViewById(R.id.btn1);

        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString();
                String amount = editAmount.getText().toString();

                dataBaseHelper.expenseDao().addTx(new Expense(title,amount));
                ArrayList<Expense> arrayExpense = ( ArrayList<Expense>)dataBaseHelper.expenseDao().getAllExpense();
                for (int i = 0; i<arrayExpense.size(); i++)
                {
                    Log.d("Data", "Title: " + arrayExpense.get(i).getTitle() + " Amunt: " + arrayExpense.get(i).getAmount());
                }
            }
        });

    }
}