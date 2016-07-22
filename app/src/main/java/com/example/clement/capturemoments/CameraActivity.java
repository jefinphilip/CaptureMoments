package com.example.clement.capturemoments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by CLemENt on 4/6/2016.
 */
public class CameraActivity extends Activity

{

        final static int CAM_REQUEST=1;

        private Button capture;
        private ImageButton button2;

        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.firstactivity);



            capture = (Button)findViewById(R.id.btnCapture);

            imageView = (ImageView)findViewById(R.id.capturedImage);


            capture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File file = getfile();
                    camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    startActivityForResult(camera_intent, CAM_REQUEST);


                }
            });

        }


        private File getfile(){


            File folder = new File("sdcard/images");
            if (!folder.exists()) {

                folder.mkdir();
            }

            File image_file = new File(folder,"cam_image.jpg");
            return image_file;
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            String path ="android/images/cam_image.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
        }
    }


