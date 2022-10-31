package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView editBtn;
    private ImageView profile;
    private CardView lanjutCard;
    private TextView nextBtn;
    private Uri profileUri;
    private Bitmap bitmap;
    private static final int GALLERY_REQUEST_CODE = 1;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        editBtn = findViewById(R.id.pinkCircle);
        profile = findViewById(R.id.profilePic);
        nextBtn = findViewById(R.id.lewati);
        lanjutCard = findViewById(R.id.lanjutCard);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            try {
                profileUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), profileUri);
                profile.setImageBitmap(bitmap);
                lanjutCard.setVisibility(View.VISIBLE);

            }catch (IOException e){
                Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage());
            }
        }

    }
}