package com.example.imagedownloaderapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowCategoryActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    private String catname;
    ImageAdapter imageadapter;
    List<ImageModel> imageModelList;

    private boolean isScrolling= false;
    private int currentItems, totalItems, scrolloutItems;
    int pageNumber=1;
    private String MyApi="20556304-1e1a5855144c40a60866da061";
    String URL = "https://pixabay.com/api/?key="+MyApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_category);

        catname=getIntent().getStringExtra("catname").toLowerCase();
        recyclerView=findViewById(R.id.cat_recyclerview);

        fetchImageData();
        imageModelList=new ArrayList<>();
        imageadapter=new ImageAdapter(this,imageModelList);
        recyclerView.setAdapter(imageadapter);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }

            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems=gridLayoutManager.getChildCount();
                totalItems=gridLayoutManager.getItemCount();
                scrolloutItems=gridLayoutManager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems+scrolloutItems==totalItems)  ){
                    isScrolling=false;
                    fetchImageData();
                }
            }
        });

        imageadapter.notifyDataSetChanged();
        fetchImageData();


    }

    private void fetchImageData() {
        StringRequest request = new StringRequest(Request.Method.GET, URL+"&category="+catname+"&page="+pageNumber+"&per_page=80", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("hits");
                    int length = jsonArray.length();

                    for (int i = 0; i < length; i++)
                    {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String id = jsonObject1.getString("id");
                        String image = jsonObject1.getString("largeImageURL");
                        imageModelList.add(new ImageModel(id, image));
                    }
                    imageadapter.notifyDataSetChanged();
                    pageNumber++;
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast= Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("key", MyApi);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolmenu, menu);

        return  super.onCreateOptionsMenu(menu);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.search) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            final EditText editText =  new EditText(this);
            editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            editText.setTextColor(Color.BLACK);
            editText.setHint("Search Images");
            editText.setHintTextColor(Color.DKGRAY);
            alert.setMessage("Enter Category e.g. Nature");
            alert.setTitle("Search Wallpaper");
            alert.setView(editText);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String query = editText.getText().toString().toLowerCase();
                    URL = "https://pixabay.com/api/?key="+MyApi+"&q="+query;
                    imageModelList.clear();
                    fetchImageData();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }






}