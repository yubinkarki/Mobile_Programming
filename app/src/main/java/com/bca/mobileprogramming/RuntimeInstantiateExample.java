package com.bca.mobileprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RuntimeInstantiateExample extends Activity{
    TextView tv;
    EditText et;
    LinearLayout ll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ll = new LinearLayout(this);
        ll.setOrientation(android.widget.LinearLayout.VERTICAL);
        ll.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ll.setBackgroundColor(0x77008080);

        tv = new TextView(this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(-1, 200));
        tv.setText("This is text.");
        tv.setBackgroundColor(0x5500ff00);
        ll.addView(tv);

        et = new EditText(this);
        et.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        et.setHint("Full name");
        et.setBackgroundColor(0xff0000ff);
        ll.addView(et);

        Button btn = new Button(this);
        btn.setText("Save");
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                tv.setText(et.getText().toString());
            }
        });
        ll.addView(btn);

        setContentView(ll);

        //setContentView(R.layout.main);
    }
}
