package com.pro.pcmappnew;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pro.pcmappnew.dao.DAOorder;
import com.pro.pcmappnew.utils.Order;
import com.pro.pcmappnew.utils.OrderSpreadsheetWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderActivity extends AppCompatActivity {

    private EditText nameInputField,emailInputField,phonenumberInputField,ordertypeInputField,orderdescInputField;
    private ProgressDialog progressDialog;
    private RadioGroup rbOrderGroup;
    private RadioButton rbOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        final OrderSpreadsheetWebService spreadsheetWebService = retrofit.create(OrderSpreadsheetWebService.class);
*/
        nameInputField = (EditText) findViewById(R.id.order_name);
        emailInputField = (EditText) findViewById(R.id.order_email);
        phonenumberInputField = (EditText) findViewById(R.id.order_phonenumber);
        ordertypeInputField = (EditText) findViewById(R.id.order_ordertype);
        //rbOrderGroup = (RadioGroup) findViewById(R.id.rb_ordertype);
        orderdescInputField = (EditText) findViewById(R.id.order_desc);
        DAOorder dao = new DAOorder();
        Button btnOrder = findViewById(R.id.btn_test1);
        btnOrder.setOnClickListener(v->{
            Order order = new Order(nameInputField.getText().toString(),
                    emailInputField.getText().toString(),
                    phonenumberInputField.getText().toString(),
                    ordertypeInputField.getText().toString(),
                    orderdescInputField.getText().toString());
            dao.add(order).addOnSuccessListener(suc->
            {
                Toast.makeText(OrderActivity.this, "sukses", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(OrderActivity.this, "fail", Toast.LENGTH_SHORT).show();
            });
                       /* String nameInput = nameInputField.getText().toString();
                        String emailInput = emailInputField.getText().toString();
                        String phonenumberInput = phonenumberInputField.getText().toString();
                        String ordertypeInput = ordertypeInputField.getText().toString();
                        String orderdescInput = orderdescInputField.getText().toString();
                       // Call<Void> completeQuestionnaireCall = spreadsheetWebService.completeQuestionnaire(nameInput, emailInput, phonenumberInput, ordertypeInput, orderdescInput);
                        //completeQuestionnaireCall.enqueue(callCallback);
                        //progressDialog.setMessage("Your order has been placed");
                        progressDial og.show(); */

        });
    }
}
    /*private final Callback<Void> callCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            Log.d("XXX", "Submitted. " + response);
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            Log.e("XXX", "Failed", t);
        }
    };*/
