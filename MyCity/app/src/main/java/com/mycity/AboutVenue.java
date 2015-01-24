package com.mycity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Akhil Bhai on 1/22/2015.
 */
public class AboutVenue extends Fragment {


    TextView textView;

    public static AboutVenue getInstance(){
        AboutVenue aboutVenue = new AboutVenue();
        return aboutVenue;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View layout = inflater.inflate(R.layout.description,container,false);
//        textView= (TextView) layout.findViewById(R.id.section_label);
//        textView.setText("About Venue");
        return layout;
    }

  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
