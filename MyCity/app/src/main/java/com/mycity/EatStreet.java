package com.mycity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Akhil Bhai on 1/22/2015.
 */

public class EatStreet extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        ((TextView)findViewById(R.id.section_label)).setText("Eat Street");
    }
}
