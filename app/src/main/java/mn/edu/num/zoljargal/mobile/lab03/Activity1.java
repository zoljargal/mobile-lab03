package mn.edu.num.zoljargal.mobile.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {

    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        myButton = findViewById(R.id.myButton1);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String data1 = b.getString("data1");
        int data2 = b.getInt("data2");
        Log.i("aaa", data1);
        Log.i("aaa", String.valueOf(data2));

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent();
                Bundle b = new Bundle();
                b.putString("result1", "this is my result");
                i.putExtras(b);
                setResult(100, i);
                finish();
            }
        });
    }
}