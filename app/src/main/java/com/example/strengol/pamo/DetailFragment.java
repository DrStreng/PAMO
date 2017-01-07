package com.example.strengol.pamo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends android.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    public void setText(String title,String msg) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(title);
        TextView aaa = (TextView) getView().findViewById(R.id.linkText);
        aaa.setText(msg);

    }

}
