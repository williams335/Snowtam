package com.example.snowtam_kk.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.snowtam_kk.Model.ListsMots;
import com.example.snowtam_kk.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ImageButton Ajouter;
    private ImageButton Valider;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Ajouter = (ImageButton) findViewById(R.id.BoutonAjouter);


        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<ListsMots> listsMots = new ArrayList<>();

                EditText mot = (EditText) findViewById(R.id.editText);

                String name = mot.getText().toString();

                TextView mTextViewResult = (TextView) findViewById(R.id.List);

                if(name==""){
                    Toast.makeText(MainActivity.this,"Veuillez rentrer une valeur valide" , Toast.LENGTH_LONG).show();
                }else if(listsMots.size()==4){
                    Toast.makeText(MainActivity.this,"Vous avez déjà entré quatre (4) OACI" , Toast.LENGTH_LONG).show();
                }
                else{
                    mTextViewResult.append(name + "\n\n");
                    listsMots.add(new ListsMots(name));
                }
            }
        });



        Valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }


}