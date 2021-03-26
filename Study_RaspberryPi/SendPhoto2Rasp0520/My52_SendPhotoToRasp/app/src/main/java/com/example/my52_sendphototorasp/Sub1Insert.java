package com.example.my52_sendphototorasp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;


import com.example.my52_sendphototorasp.ATask.ListInsert;
import com.example.my52_sendphototorasp.Common.CommonMethod;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import static com.example.my52_sendphototorasp.Common.CommonMethod.ipConfig;
import static com.example.my52_sendphototorasp.Common.CommonMethod.isNetworkConnected;


public class Sub1Insert extends AppCompatActivity {

    Button btnPhoto, btnPhotoLoad;
    Button btnVideo, btnVideoLoad;

    ImageView imageView;
    VideoView videoView;
    MediaController m;

    public String uploadType = "", imageRealPathA = "", videoRealPathA = "";

    final int CAMERA_REQUEST = 1000;
    final int LOAD_IMAGE = 1001;
    final int VIDEO_REQUEST = 1003;
    final int LOAD_VIDEO = 1004;

    File file = null;
    long fileSize = 0;

    java.text.SimpleDateFormat tmpDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1_insert);

        tmpDateFormat = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss");

        btnPhoto = findViewById(R.id.btnPhoto);
        btnPhotoLoad = findViewById(R.id.btnLoad);

        btnVideo = findViewById(R.id.btnVideo);
        btnVideoLoad = findViewById(R.id.btnLoadVideo);

        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        videoViewSetting();

        imageView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    file = createFile();
                    Log.d("FilePath ", file.getAbsolutePath());

                }catch(Exception e){
                    Log.d("Sub1Add:filepath", "Something Wrong", e);
                }

                imageView.setVisibility(View.VISIBLE);

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { // API24 이상 부터
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                            FileProvider.getUriForFile(getApplicationContext(),
                                    getApplicationContext().getPackageName() + ".fileprovider", file));
                    Log.d("sub1:appId", getApplicationContext().getPackageName());
                }else {
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                }

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_REQUEST);
                }

            }
        });

        btnPhotoLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), LOAD_IMAGE);
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);

                Intent intent=new Intent("android.media.action.VIDEO_CAPTURE");
//                intent.putExtra("android.intent.extra.durationLimit", VIDEO_DURATION);
//                intent.putExtra("android.intent.extra.videoQuality",1);
                intent.putExtra(android.provider.MediaStore.EXTRA_SIZE_LIMIT,30485760);
                intent.putExtra(android.provider.MediaStore.EXTRA_VIDEO_QUALITY,-1);

                startActivityForResult(intent, VIDEO_REQUEST);
            }
        });

        btnVideoLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, LOAD_VIDEO);
            }
        });

    }
    private void videoViewSetting() {
        m = new MediaController(this);
        m.setVisibility(View.GONE);
        videoView.setMediaController(m);
    }

    private File createFile() throws IOException {

        String imageFileName = "My" + tmpDateFormat.format(new Date()) + ".jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File curFile = new File(storageDir, imageFileName);

        return curFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            uploadType = "image";
            try {
                // 이미지 돌리기 및 리사이즈
                Bitmap newBitmap = CommonMethod.imageRotateAndResize(file.getAbsolutePath());
                if(newBitmap != null){
                    imageView.setImageBitmap(newBitmap);
                }else{
                    Toast.makeText(this, "이미지가 null 입니다...", Toast.LENGTH_SHORT).show();
                }

                imageRealPathA = file.getAbsolutePath();
                Log.d("Sub1Add", "imageFilePathA Path : " + imageRealPathA);

            } catch (Exception e){
                e.printStackTrace();
            }
        }else if (requestCode == LOAD_IMAGE && resultCode == RESULT_OK) {
            uploadType = "image";
            try {
                String path = "";
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    // Get the path from the Uri
                    path = getPathFromURI(selectedImageUri);
                }
                // 이미지 돌리기 및 리사이즈
                Bitmap newBitmap = CommonMethod.imageRotateAndResize(path);
                if(newBitmap != null){
                    imageView.setImageBitmap(newBitmap);
                }else{
                    Toast.makeText(this, "이미지가 null 입니다...", Toast.LENGTH_SHORT).show();
                }

                imageRealPathA = path;
                Log.d("Sub1Add", "imageFilePathA Path : " + imageRealPathA);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

        else if ((requestCode == VIDEO_REQUEST || requestCode == LOAD_VIDEO)  && resultCode == RESULT_OK) {
            uploadType = "video";
            try {
                String path = "";
                // Get the url from data
                Uri selectedVideoUri = data.getData();
                if (null != selectedVideoUri) {
                    // Get the path from the Uri
                    path = getPathFromURI(selectedVideoUri);
                    Log.d("Sub1Add", path);
                }

                File file = new File(path);
                fileSize = file.length();
                Log.d("Sub1Add11:fileSize", "" + fileSize);

                videoRealPathA = path;

                Log.d("Sub1Add11", path + " : " + videoRealPathA);

                videoView.setVideoURI(selectedVideoUri);
                videoView.start();

                videoView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        m.show(0);
                        videoView.pause();
                    }
                }, 1000);

            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            Log.d("Sub1Add => ", "imagepath is null, whatever something is wrong!!");
        }

    }

    // Get the real path from the URI
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    public void btnAddClicked(View view){
        if(uploadType == ""){
            Toast.makeText(this, "업로드 할 파일을 선택해주세요!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(isNetworkConnected(this) == true){

            if(fileSize <= 30000000){  // 파일크기가 30메가 보다 작아야 업로드 할수 있음

                if(uploadType.equals("image")){
                    ListInsert listInsert = new ListInsert(uploadType, imageRealPathA);
                    listInsert.execute();
                }else if(uploadType.equals("video")){
                    ListInsert listInsert = new ListInsert(uploadType, videoRealPathA);
                    listInsert.execute();
                }


                /*Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
                showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |   // 이 엑티비티 플래그를 사용하여 엑티비티를 호출하게 되면 새로운 태스크를 생성하여 그 태스크안에 엑티비티를 추가하게 됩니다. 단, 기존에 존재하는 태스크들중에 생성하려는 엑티비티와 동일한 affinity(관계, 유사)를 가지고 있는 태스크가 있다면 그곳으로 새 엑티비티가 들어가게됩니다.
                        Intent.FLAG_ACTIVITY_SINGLE_TOP | // 엑티비티를 호출할 경우 호출된 엑티비티가 현재 태스크의 최상단에 존재하고 있었다면 새로운 인스턴스를 생성하지 않습니다. 예를 들어 ABC가 엑티비티 스택에 존재하는 상태에서 C를 호출하였다면 여전히 ABC가 존재하게 됩니다.
                        Intent.FLAG_ACTIVITY_CLEAR_TOP); // 만약에 엑티비티스택에 호출하려는 엑티비티의 인스턴스가 이미 존재하고 있을 경우에 새로운 인스턴스를 생성하는 것 대신에 존재하고 있는 엑티비티를 포그라운드로 가져옵니다. 그리고 엑티비티스택의 최상단 엑티비티부터 포그라운드로 가져올 엑티비티까지의 모든 엑티비티를 삭제합니다.
                startActivity(showIntent);*/

                finish();
            }else{
                // 알림창 띄움
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("알림");
                builder.setMessage("파일 크기가 30MB초과하는 파일은 업로드가 제한되어 있습니다.\n30MB이하 파일로 선택해 주십시요!!!");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }

        }else {
            Toast.makeText(this, "인터넷이 연결되어 있지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void btnCancelClicked(View view){
        finish();
    }

}
