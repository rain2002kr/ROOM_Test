package com.example.room_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView resultTxt;
    Button button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        resultTxt = (TextView) findViewById(R.id.resultTxt);
        button = (Button) findViewById(R.id.button);


        final AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,"todo-db")
            .allowMainThreadQueries()
            .build();

        resultTxt.setText(db.todoDao().getAll().toString());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.todoDao().insert(new Todo(resultTxt.getText().toString()));
                resultTxt.setText(db.todoDao().getAll().toString());
            }
        });



    }
}
