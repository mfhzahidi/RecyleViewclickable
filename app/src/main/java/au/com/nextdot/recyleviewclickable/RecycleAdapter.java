package au.com.nextdot.recyleviewclickable;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sakib on 2/14/2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter <RecycleAdapter.RecyclerViewHolder>{
    private ArrayList<Data>arrayList=new ArrayList<Data>();
    Context context;
    public RecycleAdapter(ArrayList<Data> arrayList,Context context)
    {
        this.arrayList = arrayList;
        this.context=context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,context,arrayList);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Data data=arrayList.get(position);
        holder.imageView.setImageResource(data.getImage_no());
        holder.textView1.setText(data.getHead());
        holder.textView2.setText(data.getDetails());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1,textView2;

        //for clickable

        Context context;
        ArrayList<Data> data=new ArrayList<Data>();
        public RecyclerViewHolder(View view,Context context,ArrayList<Data> data)
        {
            super(view);
            this.context=context;
            this.data=data;
            view.setOnClickListener(this);
            imageView=view.findViewById(R.id.img);
            textView1=view.findViewById(R.id.heading);
            textView2=view.findViewById(R.id.body);
        }

        @Override
        public void onClick(View v) {
           Toast.makeText(v.getContext(),"hello",Toast.LENGTH_LONG).show();
           int position=getAdapterPosition();
           Data datas=this.data.get(position);
           Intent intent=new Intent(this.context,Details.class);
           intent.putExtra("image",datas.image_no);
           intent.putExtra("head",datas.getHead());
           intent.putExtra("body",datas.getDetails());
           this.context.startActivity(intent);
        }
    }
}
