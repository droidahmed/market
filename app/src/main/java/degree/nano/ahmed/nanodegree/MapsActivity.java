package degree.nano.ahmed.nanodegree;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

import degree.nano.ahmed.nanodegree.adapter.CategoryAdapter;
import degree.nano.ahmed.nanodegree.model.CategoryModel;
import degree.nano.ahmed.nanodegree.model.ProductModel;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    ArrayList<ProductModel> productModels;
    ArrayList<LatLng> latLngArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        productModels = new ArrayList<>();
        latLngArrayList = new ArrayList<>();
        if(getIntent().getExtras()!=null){
            getIntent().getExtras().getString("id");
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        retrieveData();
    }


    private void retrieveData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference posts = database.getReference("category").child("0").child("c1");
        posts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {

                    String name = (String) messageSnapshot.child("productName").getValue();
                    String price = (String) messageSnapshot.child("price").getValue();
                    String url = (String) messageSnapshot.child("productUrl").getValue();
                    String des = (String) messageSnapshot.child("productDescription").getValue();
                    double longitude = (Double) messageSnapshot.child("longitude").getValue();
                    double latitude = (Double) messageSnapshot.child("latitude").getValue();
                    ProductModel productModel = new ProductModel(name,des,price,url,longitude,latitude);
                    productModels.add(productModel);
                    LatLng latLng = new LatLng(longitude,latitude);
                    latLngArrayList.add(latLng);
                    Log.d("rrvvv", name);
                }


                for (int i = 0; i < latLngArrayList.size(); i++) {

                    drawMarker(productModels.get(i).getProductName(),productModels.get(i).getProductUrl(),latLngArrayList.get(i));
                    Log.d("qqq", productModels.get(i).getProductUrl());
                }
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngArrayList.get(0)));

//categoryModels = dataSnapshot.getValue(new GenericTypeIndicator<ArrayList<CategoryModel>>() {
//});
//                HashMap<String, CategoryModel> results = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String, CategoryModel>>() {});
//
//                List<CategoryModel> posts = new ArrayList<>(results.values());

//        Log.d("rrvvv4",""+posts.size());

//                for (CategoryModel post : posts) {
//                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void drawMarker(String productName, final String url, LatLng point) {
        // Creating an instance of MarkerOptions
        MarkerOptions markerOptions = new MarkerOptions();

        // Setting latitude and longitude for the marker
        markerOptions.position(point);
        final Marker marker =  mMap.addMarker(new MarkerOptions()
                .position(point));
        marker.setTag(point);
        marker.setTitle(productName);
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Log.d("qqq", url);
                marker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        Picasso.with(this)
                .load(url).into(target);
        // Adding marker on the Google Map
        mMap.addMarker(markerOptions);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        int position = (int)(marker.getTag());
        Intent intent = new Intent(MapsActivity.this,MainActivity.class);
        intent.putExtra("product","product");
        startActivity(intent);

        return false;
    }
}
