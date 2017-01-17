package degree.nano.ahmed.nanodegree;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import degree.nano.ahmed.nanodegree.model.ProductModel;

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
        retrieveData();
        return view;
    }
//        categoryModels = new ArrayList<>();
//        categoryModels.add(new ProductModel(
//        "Samsung note 4","Model 64 gb good condition red color ","400 $",
//                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/samsung.jpg?alt=media&token=02ee4096-4bd3-40c2-9ec8-3d0e08601cf1",33.403198,10.302560));
//        categoryModels.add(new ProductModel("Sony Z 5permium","very luxuries gold color camera 4k","600 $",
//                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/Sony.jpg?alt=media&token=61cc33a2-224a-4106-b056-9f723007f2d2",52.747331,2.412987));
//        categoryModels.add(new ProductModel("HTC M9","very luxuries silver color excellent condition","350 $",
//                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/htc.jpg?alt=media&token=4071d0e7-5521-4dd2-a1e9-d608b090af4b",51.418188,5.499304));
//
//        categoryModels.add(new ProductModel("Nexsus pixel xl","very luxuries blue silver color excellent condition","390 $",
//                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/nexsus.jpg?alt=media&token=6714551b-f842-405c-af93-3f92388bfde4",51.418188,5.499304));
//
//        mDatabase.child("category").child("1").setValue(categoryModels);

//    "Mercedes AMG","Model 2016 good condition red color modified to 800 hp","270000 $",
//            "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/mercedes.jpg?alt=media&token=18f0fcae-c55d-4379-b749-7b5d75a6176c",43.403198,11.302560));
//    categoryModels.add(new ProductModel("Audi R 8","very luxuries red color modified bt ATB to 750 hp","210000 $",
//                                                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/audi.jpg?alt=media&token=87451580-6bee-4220-a7cf-5b0383252aeb",48.747331,2.412987));
//    categoryModels.add(new ProductModel("BMW x5","very luxuries red color modified bt ATB to 600 hp","155000 $",
//                                                "https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/bmw_series.png?alt=media&token=dcde1b82-587e-4c51-a675-724e88612e67",50.137152,8.959783));
//    mDatabase.child("category").child("0").setValue(categoryModels);

    private void declare(View view){
        tvProductName = (TextView) view.findViewById(R.id.tvProductName);
        tvProductDescription = (TextView) view.findViewById(R.id.tvProductDescription);
        tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);

    }

    private void retrieveData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference posts = database.getReference("posts");

        posts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, ProductModel> results = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String, ProductModel>>() {});

                List<ProductModel> posts = new ArrayList<ProductModel>(results.values());

                for (ProductModel post : posts) {
                    Log.e("Post Title", post.getProductName());
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
