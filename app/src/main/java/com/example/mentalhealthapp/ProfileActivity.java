package com.example.mentalhealthapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    private Button btnEdit,btnBack;
    private TextView tvName,tvBio;
    private ImageView image;

    private String imageString;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        btnBack=findViewById(R.id.btnProfileBack);
        btnEdit=findViewById(R.id.btnProfileEdit);
        tvName=findViewById(R.id.tvNameProfile);
        tvBio=findViewById(R.id.tvBioProfile);
        image=findViewById(R.id.iv_cp);


        SharedPreferences sharedPreferences=
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
        try{
            String TEXT1 = sharedPreferences.getString("TEXT", "Default");
            tvName.setText(TEXT1);
            Toast.makeText(ProfileActivity.this,"Got Prefs",Toast.LENGTH_SHORT).show();
            String txtBio = sharedPreferences.getString("bio", "One");
            tvBio.setText(txtBio);
            imageString=sharedPreferences.getString("image","");
            Glide.with(ProfileActivity.this).load(imageString).into(image);
        }
        catch(Exception e){

        }

        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent data=result.getData();

                            imageString=data.getStringExtra("image");
                            Glide.with(ProfileActivity.this).load(imageString).into(image);

                            String Name = data.getStringExtra("Name");
                            String Bio = data.getStringExtra("Bio");
                            tvName.setText(String.valueOf(Name));
                            tvBio.setText(String.valueOf(Bio));


                        }
                    }
                });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProfileActivity.this,ProfileEditActivity.class);
                intent.putExtra("Name",tvName.getText().toString());
                intent.putExtra("Bio",tvBio.getText().toString());
                intent.putExtra("image",imageString);

                launchSomeActivity.launch(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void finish(){
        SharedPreferences sharedPreferences=
                PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);

        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("TEXT", tvName.getText().toString());
        editor.putString("bio", tvBio.getText().toString());
        editor.putString("image",imageString);
        editor.apply();

        Intent intent=new Intent(ProfileActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}