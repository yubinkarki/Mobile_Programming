package com.bca.mobileprogramming;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class SendData extends AppCompatActivity {
    EditText editId, editName, editAddress;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.user_details);

        editId = findViewById(R.id.userId);
        editName = findViewById(R.id.userName);
        editAddress = findViewById(R.id.userAddress);
        btnSubmit = findViewById(R.id.btnInsert);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyPostRequest();
            }
        });
    }

    public void volleyPostRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.47/setdata.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error posting data", error.toString());
                    }
                }
        ) {
            @Override
            protected HashMap<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();

                params.put("id", editId.getText().toString());
                params.put("name", editName.getText().toString());
                params.put("address", editAddress.getText().toString());

                return params;
            }
        };

        queue.add(stringRequest);
    }
}
