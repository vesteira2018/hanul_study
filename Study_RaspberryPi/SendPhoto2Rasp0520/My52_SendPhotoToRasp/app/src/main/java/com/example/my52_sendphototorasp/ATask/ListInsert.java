package com.example.my52_sendphototorasp.ATask;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.nio.charset.Charset;

import static com.example.my52_sendphototorasp.Common.CommonMethod.ipConfig;


public class ListInsert extends AsyncTask<Void, Void, Void> {

    String uploadType, RealPathA;

    // id, name, date, 업로드타입(이미지,비디오), 디비에 입력할 이미지경로, 실제업로드할 이미지경로,디비에 입력할 비디오경로, 실제업로드할 비디오경로
    public ListInsert(String uploadType, String RealPathA){
        this.uploadType = uploadType;
        this.RealPathA = RealPathA;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            // MultipartEntityBuild 생성
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));

            // 문자열 및 데이터 추가
            builder.addTextBody("uploadType", uploadType, ContentType.create("Multipart/related", "UTF-8"));
            if(uploadType.equals("image")){
                builder.addPart("image", new FileBody(new File(RealPathA)));
            } else if(uploadType.equals("video")){
                builder.addPart("video", new FileBody(new File(RealPathA)));
            }

            String postURL = ipConfig + "/app/raspSendPhoto";

            Log.d("Sub1Add2", postURL);
            // 전송
            //InputStream inputStream = null;
            HttpClient httpClient = AndroidHttpClient.newInstance("Android");
            HttpPost httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            //inputStream = httpEntity.getContent();

            // 응답
                /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }
                inputStream.close();*/

            // 응답결과
                /*String result = stringBuilder.toString();
                Log.d("response", result);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("Sub1Add:imageFilePath1", "추가성공");

    }

}
