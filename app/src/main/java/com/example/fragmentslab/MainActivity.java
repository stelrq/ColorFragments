package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change something

        if(savedInstanceState == null) {
            if(findViewById(R.id.frame_main_container) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frame_main_container, new FirstFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onFragmentInteraction(int color) {
        Log.d("ACTIVITY", "Red:" + Color.red(color) +
                "Green:" + Color.green(color) + "Blue:" + Color.blue(color));
        ColorFragment colorFragment;
        colorFragment = (ColorFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragment_main_color);
        if(colorFragment != null) {
            colorFragment.updateContent(color);
        } else {
            colorFragment = new ColorFragment();
            Bundle args = new Bundle();
            args.putSerializable(getString(R.string.all_color_key), color);
            colorFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_main_container, colorFragment)
                    .addToBackStack(null);
            transaction.commit();
        }
    }
}
