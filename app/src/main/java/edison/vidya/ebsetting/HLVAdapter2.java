package edison.vidya.ebsetting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class HLVAdapter2 extends RecyclerView.Adapter<HLVAdapter2.ViewHolder> {

    int i_count=0;


    ArrayList<String> alName;

    Context context;


    public HLVAdapter2(Context context, ArrayList<String> alName) {
        super();
        this.context = context;
        this.alName = alName;
        setHasStableIds(true);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item2, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

       // final DataSource datasource=dataSou


        int size=alName.size()-1;
        if(i_count<alName.size()) {
            viewHolder.tvSpecies.setText(alName.get(i_count));

           /*
            else*/
            viewHolder.imgThumbnail.setImageResource(R.drawable.room01_eb);
            if(viewHolder.tvSpecies.getText().toString().equalsIgnoreCase("Add More")) {
                viewHolder.imgThumbnail.setImageResource(R.drawable.addplus);
                viewHolder.subroom.setText("");
            }

            i_count++;

            if(i_count<alName.size()) {
                viewHolder.tvSpecies2.setText(alName.get(i_count));
                if(alName.get(i_count).equalsIgnoreCase("Add More")) {
                    viewHolder.imgThumbnail2.setImageResource(R.drawable.addplus);
                    viewHolder.subroom2.setText("");
                }
                else
                    viewHolder.imgThumbnail2.setImageResource(R.drawable.room_icon);
            }
            else if( i_count==alName.size())
            {
                viewHolder.subroom2.setText("");
                viewHolder.lout.setBackgroundResource(R.color.transper);
                viewHolder.lout3.setBackgroundResource(R.color.transper);
            }
            i_count++;
        }




        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                   // Toast.makeText(context, "#" + position + " - " + alName.get(position) + " (Long click)", Toast.LENGTH_SHORT).show();
                    //context.startActivity(new Intent(context, MainActivity.class));
                } else {
                    //Toast.makeText(context, "#" + position + " - " + alName.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });

       // viewHolder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        int divident=alName.size();
        int val =(int) Math.ceil((double) divident/2);
        return val;
    }
    @Override
    public int getItemViewType(int position)
    {
        return position;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView imgThumbnail;
        public TextView tvSpecies;
        public ImageView imgThumbnail2;
        public TextView tvSpecies2;
        public TextView subroom;
        public TextView subroom2;
        private ItemClickListener clickListener;

        public LinearLayout lout;
        public LinearLayout lout2;
        public LinearLayout lout3;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvSpecies = (TextView) itemView.findViewById(R.id.tv_species);
            imgThumbnail2 = (ImageView) itemView.findViewById(R.id.img_thumbnail2);
            tvSpecies2 = (TextView) itemView.findViewById(R.id.tv_species2);

            subroom = (TextView) itemView.findViewById(R.id.subroom);
            subroom2 = (TextView) itemView.findViewById(R.id.subroom2);

            lout=(LinearLayout) itemView.findViewById(R.id.secondlayout);

            lout2=(LinearLayout) itemView.findViewById(R.id.linelay1);
            lout3=(LinearLayout) itemView.findViewById(R.id.linelay2);




            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }


}