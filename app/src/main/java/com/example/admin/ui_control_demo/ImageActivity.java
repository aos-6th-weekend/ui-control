package com.example.admin.ui_control_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        //imageView.setImageResource(R.mipmap.ic_launcher);
        Picasso.get().load("https://image.iol.co.za/image/1/process/620x349?source=https://inm-baobab-prod-eu-west-1.s3.amazonaws.com/public/inm/media/image/iol/2018/05/18/15037191/IOLmotMay18_BMW_X7.jpg")
                .resize(350,200)
                .placeholder(R.drawable.download)
                .error(R.drawable.puppy)
                .into(imageView);
    }
}
