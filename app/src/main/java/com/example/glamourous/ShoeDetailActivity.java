package com.example.glamourous;

public class ShoeDetailActivity {

    package com.example.glamorous.Activity;



import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;

import android.widget.TextView;



import com.bumptech.glide.Glide;

import com.example.glamorous.Domain.ProductDomain;

import com.example.glamorous.Helper.ManagementCart;

import com.example.glamorous.R;



    public class ShowDetailActivity extends AppCompatActivity {

        private TextView addToCartBtn;

        private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt;

        private ImageView plusBtn,MinusBtn,picProduct;

        private ProductDomain getObject;

        private ProductDomain object;

        int numberOrder=1;

        private ManagementCart managementCart;



        @Override

        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_show_detail);





            managementCart=new ManagementCart(this);

            initView();

            getBundle();

        }



        private void getBundle() {

            object=(ProductDomain)getIntent().getSerializableExtra("object");



            int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());

            Glide.with(this)

                    .load(drawableResourceId)

                    .into(picProduct);

            titleTxt.setText(object.getTitle());

            feeTxt.setText("$"+object.getFee());

            descriptionTxt.setText(object.getDescription());

            numberOrderTxt.setText(String.valueOf(numberOrder));



            plusBtn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    numberOrder=numberOrder+1;

                    numberOrderTxt.setText(String.valueOf(numberOrder));

                }

            });



            MinusBtn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    if (numberOrder>1){

                        numberOrder=numberOrder-1;

                    }

                    numberOrderTxt.setText(String.valueOf(numberOrder));

                }

            });



            addToCartBtn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    object.setNumberInCart(numberOrder);

                    managementCart.insertProduct(object);

                }

            });







        }





        private void initView() {

            addToCartBtn=findViewById(R.id.addToCartBtn);

            titleTxt=findViewById(R.id.priceTxt);

            feeTxt=findViewById(R.id.priceTxt);

            descriptionTxt=findViewById(R.id.descriptionTxt);

            numberOrderTxt=findViewById(R.id.numberOrderTxt);

            plusBtn=findViewById(R.id.plusBtn);

            MinusBtn=findViewById(R.id.minusBtn);

            picProduct=findViewById(R.id.picproduct);





        }

    }








}
