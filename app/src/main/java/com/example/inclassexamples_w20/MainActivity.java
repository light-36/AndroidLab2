package com.example.inclassexamples_w20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main);

        //Now that the screen was loaded, use findViewByid() to
        // get load the objects in Java:
        TextView firstText = findViewById(R.id.firstText);

        EditText theEdit = findViewById(R.id.firstEditText);

        String message = getResources().getString(R.string.hello);
        theEdit.setText(message);

        final Button btn = findViewById(R.id.myButton);
        String toastMessage = getResources().getString(R.string.toast_message);
        btn.setOnClickListener( (click) ->  {
            firstText.setText(theEdit.getText());
            Toast.makeText(this,
                     toastMessage,
                    Toast.LENGTH_SHORT).show();
        }  );


        CheckBox cb = findViewById(R.id.checkb);
        View mainView = findViewById(android.R.id.content);
        cb.setOnCheckedChangeListener( (compoundButton, b) -> {

            //  Toast.makeText(MainActivity.this, "Checkbox is " + b, Toast.LENGTH_LONG).show();
            Snackbar.make(mainView, "Checkbox is now " + b, Snackbar.LENGTH_LONG)
                    .setAction("Undo", click-> compoundButton.setChecked( !b ))
                    .show();

        });
    }
}