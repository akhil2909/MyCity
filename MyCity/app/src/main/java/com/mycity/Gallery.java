package com.mycity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akhil Bhai on 1/23/2015.
 */
public class Gallery extends Fragment {

    public static Gallery getInstance(){
        Gallery gallery = new Gallery();
        return gallery;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gallery,container,false);
    }
}
