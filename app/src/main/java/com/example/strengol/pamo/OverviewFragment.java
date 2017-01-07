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

        View view = inflater.inflate(R.layout.fragment_overview, container,
                false);

        OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        updateDetail(
                                1,
                                "East Asia modern Folks Compilation",
                                "Asia traditional Folks artists have been adapting to the changes of modern music by combining EDM effects with this several thousands year old gerne. Therefore, both fan of Traditional Eastern Sound and EDM can enjoy these beautiful tracks. ",
                                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kbjhO3iX1GY\" frameborder=\"0\" allowfullscreen></iframe>");
                        break;
                    case R.id.button2:
                        updateDetail(
                                2,
                                "Blender Node ",
                                "Moje tworcze blendery",
                                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/v2XUDcc3SN8\" frameborder=\"0\" allowfullscreen></iframe>");
                        break;
                    case R.id.button3:
                        updateDetail(
                                3,
                                "When you go dark souls with your best mates",
                                "Domani mattina parto per la sardegna per una settimana e l'idea di allontanarmi da SFM mi mette un po a disagio, quindi per rimediare a questo ho deciso di salutarvi con un video :D",
                                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/bzJDimvPW1Y\" frameborder=\"0\" allowfullscreen></iframe>");
                        break;
                    default:
                        break;
                }
            }
        };

        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);

        return view;
    }

    public interface OverviewFragmentActivityListener {
        public void onItemSelected(int id,String title,String msg,String link);
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

    public void updateDetail(int id,String title,String msg,String link) {
        listener.onItemSelected(id,title,msg,link);
    }
}
