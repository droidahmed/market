package degree.nano.ahmed.nanodegree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import degree.nano.ahmed.nanodegree.model.CategoryModel;

public class MainActivity extends AppCompatActivity {

    LinearLayout linAdd,linCategory;
    private DatabaseReference mDatabase;
    ArrayList<CategoryModel> categoryModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declare();
        action();
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        categoryModels = new ArrayList<>();
//        categoryModels.add(new CategoryModel("Cars","c1","https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/download.jpg?alt=media&token=06f5237e-6d83-4c74-9296-3af2c87fa25d"));
//        categoryModels.add(new CategoryModel("Mobile","m1","https://firebasestorage.googleapis.com/v0/b/glaring-torch-4375.appspot.com/o/Sony.jpg?alt=media&token=61cc33a2-224a-4106-b056-9f723007f2d2"));
//        mDatabase.child("category").setValue(categoryModels);



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
