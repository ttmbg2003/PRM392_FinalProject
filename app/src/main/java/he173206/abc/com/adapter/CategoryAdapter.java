package he173206.abc.com.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import he173206.abc.com.ItemsActivity;
import he173206.abc.com.R;
import he173206.abc.com.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private List<Category> mCategoryList;

    public CategoryAdapter(Context context, List<Category> mCategoryList) {
        this.context=context;
        this.mCategoryList=mCategoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Glide.with(context).load(mCategoryList.get(position).getImg_url()).into(holder.mTypeImg);
        holder.mTypeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ItemsActivity.class);
                intent.putExtra("type",mCategoryList.get(position).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mTypeImg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTypeImg=itemView.findViewById(R.id.category_img);
        }
    }
}
