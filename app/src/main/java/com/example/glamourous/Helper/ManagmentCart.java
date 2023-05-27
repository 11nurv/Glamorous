package com.example.glamorous.Helper;



import android.content.Context;

import android.widget.Toast;



import com.bumptech.glide.load.data.ExifOrientationStream;

import com.example.glamorous.Domain.ProductDomain;



import java.util.ArrayList;



public class ManagementCart {

    private Context context;

    private TinyDB tinyDB;



    public ManagementCart(Context context) {

        this.context = context;

        this.tinyDB=new TinyDB(context);

    }

    public void insertProduct(ProductDomain item){

        ArrayList<ProductDomain> listProduct=getListCart();

        boolean existAlready=false;



        int n=0;

        for (int i = 0; i < listProduct.size(); i++) {

            if (listProduct.get(i).getTitle().equals(item.getTitle())){

                existAlready=true;

                n=i;

                break;

            }

        }

        if (existAlready){

            listProduct.get(n).setNumberInCart(item.getNumberInCart());

        }else{

            listProduct.add(item);



        }

        tinyDB.putListObject("cardList",listProduct);

        Toast.makeText(context, "added to your cart", Toast.LENGTH_SHORT).show();



    }



    public ArrayList<ProductDomain> getListCart(){

        return tinyDB.getListObject("CartList");

    }

}





