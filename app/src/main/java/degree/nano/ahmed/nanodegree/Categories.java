package degree.nano.ahmed.nanodegree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sand on 16/01/17.
 */
public class Categories extends Fragment {

    RecyclerView reCategories;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories,container,false);
        declare(view);


        return view;
    }

    private void declare(View view){
       reCategories = (RecyclerView) view.findViewById(R.id.reCategories);
       reCategories.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
