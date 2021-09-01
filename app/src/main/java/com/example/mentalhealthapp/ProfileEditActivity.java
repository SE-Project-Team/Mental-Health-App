package com.example.mentalhealthapp;
import static android.widget.Toast.makeText;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class ProfileEditActivity extends AppCompatActivity {
    public Button btnSave;
    public TextView nText;
    public EditText nName;
    public EditText nBio;
    public EditText nPassword;
    public ImageView image;
    Uri imageuri;
    public String Name, Bio, text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        btnSave = findViewById(R.id.btnProfileSave);

        nText = findViewById(R.id.id_edit_text);
        nName = findViewById(R.id.tvNameProfile);
        nBio = findViewById(R.id.tvBioProfile);
        nPassword = findViewById(R.id.et_password_cp);
        image = findViewById(R.id.iv_cp);
        nName.setText(getIntent().getStringExtra("Name"));
        nBio.setText(getIntent().getStringExtra("Bio"));
        text=getIntent().getStringExtra("image");
        Glide.with(ProfileEditActivity.this).load(text).into(image);

        ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {

                            imageuri = result.getData().getData();
                            text=imageuri.toString();

                            Glide.with(ProfileEditActivity.this)
                                  .load(text).into(image);
                        }
                    }
                });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(gallery,"Select Picture"),PICK_IMAGE);
                launchSomeActivity.launch(Intent.createChooser(gallery, "Select Picture"));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = nName.getText().toString();
                Bio = nBio.getText().toString();
                makeText(ProfileEditActivity.this, Name + " " + Bio, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProfileEditActivity.this, ProfileActivity.class);
                intent.putExtra("Name", Name);
                intent.putExtra("Bio", Bio);
                intent.putExtra("image",text);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
