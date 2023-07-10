package com.bca.mobileprogramming;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UserTableActionsMain extends AppCompatActivity {
    EditText editId, editName, editAddress;
    Button btnSelect, btnInsert, btnUpdate, btnDelete;
    TextView txtData;
    UserDatabaseConnection userDB;
    ListView listView;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.user_details);

        userDB = new UserDatabaseConnection(this);

        editId = findViewById(R.id.userId);
        editName = findViewById(R.id.userName);
        editAddress = findViewById(R.id.userAddress);

        btnSelect = findViewById(R.id.btnSelect);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        txtData = findViewById(R.id.txtData);

        listView = findViewById(R.id.listViewContainer);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(editId.getText().toString());
                String name = editName.getText().toString();
                String address = editAddress.getText().toString();

                userDB.insertData(id, name, address);

                Toast.makeText(getApplicationContext(), "Data inserted successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int id = 0;
                String name = "";
                String address = "";*/

                ArrayList<Integer> idArray = new ArrayList<>();
                ArrayList<String> nameArray = new ArrayList<>();
                ArrayList<String> addressArray = new ArrayList<>();

                Cursor cursor = userDB.selectData();

                while (cursor.moveToNext()) {
                    /*id = cursor.getInt(0);
                    name = cursor.getString(1);
                    address = cursor.getString(2);*/

                    idArray.add(cursor.getInt(0));
                    nameArray.add(cursor.getString(1));
                    addressArray.add(cursor.getString(2));
                }

                ListViewAdapter adapter = new ListViewAdapter(UserTableActionsMain.this,
                        idArray, nameArray, addressArray);

                listView.setAdapter(adapter);

                // txtData.setText("Id: " + id + "\t Name: " + name + "\t Address: " + address);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();
                String name = editName.getText().toString();
                String address = editAddress.getText().toString();

                userDB.updateData(id, name, address);

                Toast.makeText(getApplicationContext(), "Data updated successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();

                userDB.deleteData(id);

                Toast.makeText(getApplicationContext(), "Data deleted successfully",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
