package com.example.glamorous;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Button;

import com.example.glamorous.Adaptor.CategoryAdaptor;
import com.example.glamorous.Adaptor.PopularAdaptor;
import com.example.glamorous.Domain.CategoryDomain;
import com.example.glamorous.Domain.ProductDomain;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupEmail, signupUsername, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_Username);
        signupPassword = findViewById(R.id.signup_password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);


                class MainActivity extends AppCompatActivity {
                    private RecyclerView.Adapter adapter,adapter2;
                    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);

                        recyclerViewCategory();
                        recyclerViewPopular();
                    }

                    private void recyclerViewCategory() {
                        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
                        recyclerViewCategoryList=findViewById(R.id.recyclerView);
                        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

                        ArrayList<CategoryDomain> category=new ArrayList<>();
                        category.add(new CategoryDomain("Hair dryer ", "cat_1"));
                        category.add(new CategoryDomain("Flat Iron","cat_2"));
                        category.add(new CategoryDomain("Manicure","cat_3"));
                        category.add(new CategoryDomain("Makeup","cat_4"));
                        category.add(new CategoryDomain("vector","cat_5"));

                        adapter=new CategoryAdaptor(category);
                        recyclerViewCategoryList.setAdapter(adapter);
                    }
                    private void recyclerViewPopular() {
                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
                        recyclerViewPopularList=findViewById(R.id.recyclerView2);
                        recyclerViewPopularList.setLayoutManager(linearLayoutManager);


                        ArrayList<ProductDomain> productList=new ArrayList<>();
                        productList.add(new ProductDomain("Hairdryer (2400 Watts)","hair1","2400 watts",50.5));
                        productList.add(new ProductDomain("Hairdryer","p1.","1500 watts",40.9));
                        productList.add(new ProductDomain("Hairdryer (3000 Watts)","hairdryer","3000 watts",65.2));


                        adapter2=new PopularAdaptor(productList);
                        recyclerViewPopularList.setAdapter(adapter2);



                    }

                };