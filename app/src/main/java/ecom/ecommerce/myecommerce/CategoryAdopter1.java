package ecom.ecommerce.myecommerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdopter1 extends RecyclerView.Adapter<CategoryAdopter1.ViewHolder> {
    ArrayList<CategoryModel1> categoryModel1s;
    Context context;
    String title;

    public CategoryAdopter1(ArrayList<CategoryModel1> categoryModel1s, Context context, String title) {
        this.categoryModel1s = categoryModel1s;
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cate_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.productPrice.setText(categoryModel1s.get(position).getProductPrice());
        holder.ProductTitle.setText(categoryModel1s.get(position).getProductTitle());
        Glide.with(context).load(categoryModel1s.get(position).getProductImage()).into(holder.productImage);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ProductDetailsActivity.class);
                intent.putExtra("k",""+(position+1));
                intent.putExtra("title",title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModel1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productPrice,ProductTitle;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            ProductTitle=itemView.findViewById(R.id.product_title);
            productPrice=itemView.findViewById(R.id.product_price);
            constraintLayout=itemView.findViewById(R.id.constraintLayout);
        }
    }
}
