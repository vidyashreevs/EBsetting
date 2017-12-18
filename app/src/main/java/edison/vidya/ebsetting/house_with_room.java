package edison.vidya.ebsetting;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class house_with_room extends AppCompatActivity {



    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_PHOTOS = "photos";
    private static final String TAG_MOVIES = "movies";
    private static final String TAG_NOTIFICATIONS = "effe";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;




    public List<String> list1;

    public String sale_id;
    public String house_name;
    public String house_id;
    public String floor_name;

    public TextView faq_title;
    public TextView floornametitle;


    // HLVAdapter mAdapter;
    ArrayList<String> alName;
    public List<String> list2;
    ArrayList<Integer> alImage;

    RecyclerView mRecyclerView;

    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    List<String> listDataHeader;

    String roomnamesdb[];

    boolean checkinternet;
    //ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        //String temp= myIntent.getStringExtra("sid");
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.house_with_room);


        Button backbtn=(Button)findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // onBackPressed();


            }
        });

        faq_title=(TextView)findViewById(R.id.faq_title);

        //faq_title.setText(house_name);
        faq_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        floornametitle=(TextView)findViewById(R.id.floorname);
       // floornametitle.setText(floor_name);


        list2=new ArrayList<String>();





        mRecyclerView = (RecyclerView) findViewById(R.id.lvfloor);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        // for verticle scroll
        mLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        // for horizontal scroll
        //mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        alName = new ArrayList<>(Arrays.asList("Ground floor", "1st floor", "2nd floor", "3rd floor", "4th floor", "5th floor", "6th floor"));


        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HLVAdapter2(this, alName);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);


        TextView floornamebtn=(TextView)findViewById(R.id.floorname);
        floornamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        Button btnhome=(Button)findViewById(R.id.homebtn);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }










    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {


            //Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            // Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            // Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onBackPressed() {
        Intent intent=new Intent(getBaseContext(),MainActivity.class);

        intent.putExtra("owner_name",house_name);
        intent.putExtra("sale_id",sale_id);
        intent.putExtra("cid",house_id);
        startActivity(intent);
        this.finish();
        super.onBackPressed();
    }


}
