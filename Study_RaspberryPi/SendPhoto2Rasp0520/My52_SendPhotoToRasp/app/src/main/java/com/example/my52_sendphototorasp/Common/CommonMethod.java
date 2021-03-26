package com.example.my52_sendphototorasp.Common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.Display;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CommonMethod {

    /*public static String  ipConfig = "http://192.168.200.151:8989";*/
    public static String  ipConfig = "http://192.168.0.130:8989";
    //public static String ipConfig = "http://121.148.239.200:80";

    // 네트워크에 연결되어 있는가
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService( Context.CONNECTIVITY_SERVICE );

        return cm.getActiveNetworkInfo() != null;
    }

    // 이미지 로테이트 및 사이즈 변경
    public static Bitmap imageRotateAndResize(String path){ // state 1:insert, 2:update
        BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inSampleSize = 8;

        File file = new File(path);
        if (file != null) {
            // 돌아간 앵글각도 알기
            int rotateAngle = setImageOrientation(file.getAbsolutePath());
            Bitmap bitmapTmp = BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            // 사진 바로 보이게 이미지 돌리기
            Bitmap bitmap = imgRotate(bitmapTmp, rotateAngle);

            // 이미지 돌린것 다시 저장
            //SaveBitmapToFileCache(bitmap, file.getAbsolutePath());

            return bitmap;
        }
        return null;
    }

    // 사진 찍을때 돌린 각도 알아보기 : 가로로 찍는게 기본임
    public static int setImageOrientation(String path){
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int oriention = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);
        return oriention;
    }

    // 이미지 돌리기
    public static Bitmap imgRotate(Bitmap bitmap, int orientation){

        Matrix matrix = new Matrix();

        switch (orientation) {
            case ExifInterface.ORIENTATION_NORMAL:
                return bitmap;
            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                matrix.setScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                matrix.setRotate(180);
                break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                matrix.setRotate(180);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                matrix.setRotate(90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                matrix.setRotate(90);
                break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                matrix.setRotate(-90);
                matrix.postScale(-1, 1);
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                matrix.setRotate(-90);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bmRotated;
        }
        catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }

    }

    // 새로 생성한 이미지 경로에 overwrite 하기
    public static void SaveBitmapToFileCache(Bitmap bitmap, String strFilePath) {

        File fileCacheItem = new File(strFilePath);

        Log.d("commandMathod:size1 ", fileCacheItem.length() + "");

        OutputStream out = null;

        try
        {
            //fileCacheItem.createNewFile();
            out = new FileOutputStream(fileCacheItem);

            Log.d("commandMathod:size2 ", fileCacheItem.length() + "");

            if(fileCacheItem.length() > 4000000) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);
            } else if(fileCacheItem.length() > 3000000) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 25, out);
            } else if(fileCacheItem.length() > 2000000) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, out);
            } else if(fileCacheItem.length() > 1000000) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 60, out);
            } else if(fileCacheItem.length() <= 1000000 ) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //먼저 앱이 실행되는 기기의 디스플레이 사이즈(해상도)를 반환해주는 코드입니다.

    public static Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return  size;
    }

    //다음은 기기별 해상도를 기기별 density로 나누어 모든 기기에 무관한 기준사이즈를 얻습니다.

    int standardSize_X, standardSize_Y;
    float density;

    public void getStandardSize(Activity activity) {
        Point ScreenSize = getScreenSize(activity);
//        density  = getResources().getDisplayMetrics().density;
//
//        standardSize_X = (int) (ScreenSize.x / density);
//        standardSize_Y = (int) (ScreenSize.y / density);
    }


//    해당 기준 사이즈인 standardSize를 기준으로 하여
//
//    어떤 기기에서도 화면 가로크기의 1/3으로 나타내고 싶을 경우 screenSize_X/3로 사용해주고
//
//    어떤 기기에서도 화면 세로크기의 1/5으로 나타내고 싶을 경우 screenSize_Y/5로 사용해주시면 됩니다.
//
//    textView.setTextSize((float) (standardSize_X / 3));
//
//    textView.setTextSize((float) (standardSize_Y / 5));

}
