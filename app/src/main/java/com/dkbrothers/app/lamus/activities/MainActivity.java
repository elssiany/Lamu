package com.dkbrothers.app.lamus.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dkbrothers.app.lamus.R;
import com.dkbrothers.app.lamus.dao.LamuDao;

public class MainActivity extends AppCompatActivity {


   private String[] tables = {"Director", "Productor Musical", "Empleado"};

    private Intent[] activities = {new Intent(this,EmployeeAdminActivity.class)
            , new Intent(this,SaveMusicTrackActivity.class),
            new Intent(this,PlaylistActivity.class)};

   private int posiTypeUser = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            initViews();
        }
    }


    @VisibleForTesting
    private void initViews(){

        final Spinner spinner =  findViewById(R.id.sp_type_user);
        final EditText inputEmail= findViewById(R.id.input_email);
        final EditText inputPassword= findViewById(R.id.input_passw);

        final LamuDao lamuDao = new LamuDao(MainActivity.this);


        final String[] typeUsers = {"Seleccione tipo de usuario","Director", "Productor Musical", "Empleado"};



       spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, typeUsers));


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
               posiTypeUser = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputEmail.getText().toString().isEmpty() &&
                        !inputPassword.getText().toString().isEmpty() && posiTypeUser!=0){

                    LamuDao.NAME_TABLE = tables[posiTypeUser];

                    if(lamuDao.getDirector(inputEmail.getText().toString(),
                            inputPassword.getText().toString())!=null){

                        startActivity(activities[posiTypeUser]);

                        Toast.makeText(getApplicationContext(),"Bienvenido a Lamus",
                                Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Correo o contraseña incorrecta...",
                                Toast.LENGTH_LONG).show();
                    }




                }else {
                    Toast.makeText(getApplicationContext(),"Por favor, ingrese todos los datos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
