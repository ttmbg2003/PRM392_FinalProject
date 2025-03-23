package he173206.abc.com.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import he173206.abc.com.DetailActivity;
import he173206.abc.com.R;
import he173206.abc.com.model.BestSell;

import java.util.List;

public class BestSellAdapter extends RecyclerView.Adapter<BestSellAdapter.ViewHolder> {
    Context context;
    List<BestSell> mBestSellList;
    public BestSellAdapter(Context context, List<BestSell> mBestSellList) {
        this.context=context;
        this.mBestSellList=mBestSellList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_bestsell_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.mName.setText(mBestSellList.get(position).getName());
        holder.mPrice.setText(mBestSellList.get(position).getPrice()+" $");
        Glide.with(context).load(mBestSellList.get(position).getImg_url()).into(holder.mImage);

        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("detail",mBestSellList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBestSellList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mName;
        TextView mPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage=itemView.findViewById(R.id.bs_img);
            mName=itemView.findViewById(R.id.bs_name);
            mPrice=itemView.findViewById(R.id.bs_cost);
        }
    }
}
