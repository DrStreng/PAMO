package com.example.strengol.pamo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;


public class Google extends Activity {

    private TextView get_place;
    int PLACE_PICKER_REQIEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        get_place = (TextView) findViewById(R.id.textView4);
        get_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                Intent intent;
                try {
                    intent = builder.build(Google.this);
                    startActivityForResult(intent, PLACE_PICKER_REQIEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//        protected void onActivityResult(int requestCode,int resultCode,Intent data){
//            if(requestCode==PLACE_PICKER_REQIEST){
//                if(requestCode==RESULT_OK){
//                    Place place = PlacePicker.getPlace(this,data);
//                    String address = String.format("Place: %s",place.getAddress());
//                    get_place.setText(address);
//                }
//            }
//    }















}
