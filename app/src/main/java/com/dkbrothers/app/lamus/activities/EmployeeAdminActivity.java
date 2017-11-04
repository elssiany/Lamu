package com.dkbrothers.app.lamus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dkbrothers.app.lamus.R;
import com.dkbrothers.app.lamus.dao.LamuDao;
import com.dkbrothers.app.lamus.models.Employee;

import java.util.UUID;

public class EmployeeAdminActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_admin);
        if(savedInstanceState==null){
            initViews();
        }
    }


    private void initViews(){

        final EditText inputNames= findViewById(R.id.input_names);
        final EditText inputLastName= findViewById(R.id.input_last_names);
        final EditText inputEmail= findViewById(R.id.input_email);

        final LamuDao lamuDao = new LamuDao(EmployeeAdminActivity.this);

        final String password = UUID.randomUUID().toString().substring(0,7);

        ((TextView) findViewById(R.id.txt_password)).setText("Contraseña: "+password);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputEmail.getText().toString().isEmpty() &&
                        !inputNames.getText().toString().isEmpty()
                        &&
                        !inputLastName.getText().toString().isEmpty()){


                    if(lamuDao.saveEmployee(new Employee(0,inputNames.getText().toString(),
                            inputLastName.getText().toString(),
                            inputEmail.getText().toString(),
                            password))){

                        Toast.makeText(getApplicationContext(),"Registro exitoso",
                                Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(getApplicationContext(),"oushh, no se completo el registro, intente de nuevo...",
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
