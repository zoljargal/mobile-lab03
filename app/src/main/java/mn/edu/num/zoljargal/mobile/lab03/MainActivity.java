package mn.edu.num.zoljargal.mobile.lab03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = findViewById(R.id.myButton);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                // mainActivity -> Activity1 data transfer
                Bundle b = new Bundle();
                b.putString("data1", "this is my data");
                b.putInt("data2", 23);
                i.putExtras(b);
                i.setClass(MainActivity.this, Activity1.class);
//                startActivity(i);
                startActivityForResult(i, 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
            String r = data.getStringExtra("result1");
            Log.i("Result from Activity1", r);
        }
    }
}