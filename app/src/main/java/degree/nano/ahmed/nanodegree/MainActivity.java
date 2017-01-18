package degree.nano.ahmed.nanodegree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import degree.nano.ahmed.nanodegree.model.CategoryModel;
import degree.nano.ahmed.nanodegree.model.ProductModel;

public class MainActivity extends AppCompatActivity {

    LinearLayout linAdd,linCategory;
    private DatabaseReference mDatabase;
    ArrayList<ProductModel> categoryModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declare();
        action();
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        categoryModels = new ArrayList<>();
//                categoryModels = new ArrayList<>();
//        categoryModels.add(new CategoryModel("Cars","c1","https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/download.jpg?alt=media&token=06f5237e-6d83-4c74-9296-3af2c87fa25d"));
//        categoryModels.add(new CategoryModel("Mobile","m1","https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/Sony.jpg?alt=media&token=61cc33a2-224a-4106-b056-9f723007f2d2"));
//        mDatabase.child("category").setValue(categoryModels);

        categoryModels = new ArrayList<>();

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
      //  mDatabase.child("category").child("1").child("m1").setValue(categoryModels);

    }

    private void declare(){
        linAdd = (LinearLayout) findViewById(R.id.linAdd);
        linCategory = (LinearLayout) findViewById(R.id.linCategory);
    }

    private void action(){
        linAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.main,new AddProducts()).addToBackStack("").commit();
            }
        });

        linCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.main,new Categories()).addToBackStack("").commit();

            }
        });
    }
}
