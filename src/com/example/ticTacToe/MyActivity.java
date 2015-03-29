package com.example.ticTacToe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bA = (Button)findViewById(R.id.button);

        bA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.fr"));
//                Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0610080501"));
                Intent i2 = new Intent(MyActivity.this, Calculator.class);
                boolean isCheckedIA = ((RadioButton) findViewById(R.id.radioButton)).isChecked();
                boolean isCheckedPlayer = ((RadioButton) findViewById(R.id.radioButton2)).isChecked();
                boolean isCross = ((Switch) findViewById(R.id.switch1)).isChecked();
                boolean isPlayer1 = ((Switch) findViewById(R.id.switch2)).isChecked();
//                i2.putExtra("val1",10);
//                i2.putExtra("val2",20);
                i2.putExtra("isCheckedIA",isCheckedIA);
                i2.putExtra("isCheckedPlayer",isCheckedPlayer);
                i2.putExtra("isCross",isCross);
                i2.putExtra("isPlayer1",isPlayer1);
                startActivity(i2);


            }
        });


    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
//        Toast.makeText(MyActivity.this, "onPause()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop() {
        super.onStop();
//        Toast.makeText(MyActivity.this,"onStop()", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast.makeText(MyActivity.this,"onDestroy()", Toast.LENGTH_LONG).show();

    }


}
