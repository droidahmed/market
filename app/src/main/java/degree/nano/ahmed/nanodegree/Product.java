package degree.nano.ahmed.nanodegree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sand on 16/01/17.
 */
public class Product extends Fragment {

    TextView tvProductName,tvProductDescription,tvProductPrice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product,container,false);
        declare(view);
        return view;
    }


    private void declare(View view){
        tvProductName = (TextView) view.findViewById(R.id.tvProductName);
        tvProductDescription = (TextView) view.findViewById(R.id.tvProductDescription);
        tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);

    }

    private void retrieveData(){

    }

}
