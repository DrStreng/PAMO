package com.example.strengol.pamo;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private OverviewFragmentActivityListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // przypisujemy layout do fragmentu
        View view = inflater.inflate(R.layout.fragment_overview, container,
                false);

        // definiujemy listener dla poszczególnych elementów (buttonów)
        OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        updateDetail(
                                "East Asia modern Folks Compilation",
                                "Asia traditional Folks artists have been adapting to the changes of modern music by combining EDM effects with this several thousands year old gerne. Therefore, both fan of Traditional Eastern Sound and EDM can enjoy these beautiful tracks. ",
                                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kbjhO3iX1GY\" frameborder=\"0\" allowfullscreen></iframe>");
                        break;
                    case R.id.button2:
                        updateDetail("title2","Szczegółowe informacje o elemencie drugim.","bbb");
                        break;
                    default:
                        break;
                }
            }
        };

        // przypisujemy elementom clickListener
        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);

        return view;
    }

    // interfejs, który będzie implementować aktywność
    public interface OverviewFragmentActivityListener {
        public void onItemSelected(String title,String msg,String link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OverviewFragmentActivityListener) {
            listener = (OverviewFragmentActivityListener) activity;
        } else {
            throw new ClassCastException( activity.toString() + " musi implementować interfejs: OverviewFragment.OverviewFragmentActivityListener");
        }
    }

    // metoda wysyła dane do aktywności
    public void updateDetail(String title,String msg,String link) {
        listener.onItemSelected(title,msg,link);
    }
}
