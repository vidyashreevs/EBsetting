package edison.vidya.ebsetting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class HLVAdapter extends RecyclerView.Adapter<HLVAdapter.ViewHolder> {

    ViewHolder p_viewHolder;
    int i_count=0;
    boolean checkinternet;

    ArrayList<String> alName;
   // ArrayList<Integer> alImage;
    Context context;

    public HLVAdapter(Context context, ArrayList<String> alName) { //, ArrayList<Integer> alImage
        super();
        this.context = context;
        this.alName = alName;


        setHasStableIds(true);

        //this.alImage = alImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

       int size=alName.size()-1;
        if(i_count<alName.size()) {
            viewHolder.tvSpecies.setText(alName.get(i_count));

           /*
            else*/
                viewHolder.imgThumbnail.setImageResource(R.drawable.floor);
            if(viewHolder.tvSpecies.getText().toString().equalsIgnoreCase("Add More"))
                    viewHolder.imgThumbnail.setImageResource(R.drawable.addplus);

            i_count++;

            if(i_count<alName.size()) {
                viewHolder.tvSpecies2.setText(alName.get(i_count));
                if(alName.get(i_count).equalsIgnoreCase("Add More"))
                    viewHolder.imgThumbnail2.setImageResource(R.drawable.addplus);
                else
                     viewHolder.imgThumbnail2.setImageResource(R.drawable.floor);
            }
            else if( i_count==alName.size())
            {
                viewHolder.lout.setBackgroundResource(R.color.transper);
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
                   // Toast.makeText(context, "#" + position + " - " + alName.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int divident=alName.size();
        int val =(int) Math.ceil((double) divident/2);
        return val;
    }
    @Override
    public long getItemId(int position)
    {
        return position;
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
        private ItemClickListener clickListener;

        public LinearLayout lout;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            tvSpecies = (TextView) itemView.findViewById(R.id.tv_species);
             imgThumbnail2 = (ImageView) itemView.findViewById(R.id.img_thumbnail2);
            tvSpecies2 = (TextView) itemView.findViewById(R.id.tv_species2);

            lout=(LinearLayout) itemView.findViewById(R.id.secondlayout);




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