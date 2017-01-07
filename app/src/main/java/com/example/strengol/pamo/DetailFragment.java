package com.example.strengol.pamo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends android.app.Fragment {

    private DetailFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail, container, false);

        OnClickListener clickListener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                navigateToFullScreen(getText());
            }
        };

        Button bt1 = (Button)view.findViewById(R.id.main_button);
        bt1.setOnClickListener(clickListener);

        return view;
    }
    public String getText(){
        TextView textView =(TextView) getView().findViewById(R.id.link);
        String text = textView.getText().toString();
        return text;
    }
    public void setText(int id,String title,String msg,String link) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(title);
        TextView aaa = (TextView) getView().findViewById(R.id.linkText);
        aaa.setText(msg);
        TextView bbb = (TextView) getView().findViewById(R.id.link);
        bbb.setText(link);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if(activity instanceof DetailFragmentActivityListener){
            listener = (DetailFragmentActivityListener) activity;
        } else {
            throw new ClassCastException(activity.toString() + "dodaj");
        }
    }

    public interface DetailFragmentActivityListener {
        public void onClickFullScreen(String link);
    }
    private void navigateToFullScreen(String link) {
        listener.onClickFullScreen(link);
    }



}
