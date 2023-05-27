package com.example.glamorous.Adaptor;



import android.content.Intent;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;



import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;



import com.example.glamorous.Activity.ShowDetailActivity;

import com.example.glamorous.Domain.ProductDomain;

import com.example.glamorous.R;



import java.util.ArrayList;



public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {

    ArrayList<ProductDomain> popularProduct;

    private int position;



    public PopularAdaptor(ArrayList<ProductDomain> ProductDomain) {

        this.popularProduct = ProductDomain;

    }



    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);

        return new ViewHolder(inflate);

    }



    @Override



    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {

        holder.title.setText(popularProduct.get(position).getTitle());

        holder.fee.setText(String.valueOf(popularProduct.get(position).getFee()));



        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularProduct.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());



        holder.addBtn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent= new Intent(holder.itemView.getContext(), ShowDetailActivity.class);

                intent.putExtra("object",popularProduct.get(holder.getAdapterPosition()));

                holder.itemView.getContext();

            }

        });

    }









    @Override

    public int getItemCount() {

        return popularProduct.size();

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,fee;

        ImageView pic;

        TextView addBtn;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            title=itemView.findViewById(R.id.title);

            fee=itemView.findViewById(R.id.fee);

            pic=itemView.findViewById(R.id.pic);

            addBtn=itemView.findViewById(R.id.addBtn);

        }

    }

}



