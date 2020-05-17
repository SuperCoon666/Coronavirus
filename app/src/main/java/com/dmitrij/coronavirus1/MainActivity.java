package com.dmitrij.coronavirus1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    Barsic bars;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bars = new Barsic(5, "Parsic", null, null);

                //getFragmentManager()
                if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container,
                            ContactsFragment.newInstance())
                            .commit();
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (bars!=null){
            outState.putParcelable("barsic", bars);
        }

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getParcelable("barsic")!=null){
            bars = savedInstanceState.getParcelable("barsic");
        }
    }
}
