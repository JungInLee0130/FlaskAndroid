package com.example.flaskokhttp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button btn;

    private static String getUrl = "http://" + "10.0.2.2" + ":" + 5000 + "/ex2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.connect_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectServer();
                //sendServer();
                Intent intent = new Intent(MainActivity.this, LandmarkList.class);
                startActivity(intent);
            }
        });
    }

    void connectServer(){
        /*IP 주소, 포트넘버가 유동적일때 변수만들어서 입력하는 변수들*/
        /*EditText ipv4AddressView = findViewById(R.id.IPAddress);
        String ipv4Address = ipv4AddressView.getText().toString();
        EditText portNumberView = findViewById(R.id.portNumber);
        String portNumber = portNumberView.getText().toString();*/
        // String postUrl= "http://"+ipv4Address+":"+portNumber+"/";









        // GET 리퀘스트 실행
        getRequest();
        //postRequest();
        //postRequestExam();
        // POST 리퀘스트 실행
        //postRequest(postUrl, postBody);
    }

    void getRequest(){

        /*EditText urlTextView = findViewById(R.id.urlText);
        String urlName = urlTextView.getText().toString();
        String getUrl = "http://" + "10.0.2.2" + ":" + 5000 + "/" + urlName;*/
        //String getUrl = "http://" + "10.0.2.2" + ":" + 5000 + "/landmark/yongsan";
        String getUrl = "http://" + "54.180.105.143" + "/landmark/yongsan";
        OkHttpClient client = new OkHttpClient();
        // GET 사용
        Request request = new Request.Builder()
                .url(getUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        responseText.setText("Failed to Connect to Server");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        try {
                            responseText.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    void postRequest() {

        String postUrl = "http://" + "10.0.2.2" + ":" + 5000 + "/";

        String postBodyText="Hello";
        //MediaType mediaType = MediaType.parse("text/plain");
        // 아마 한국어 입력하는 미디어 타입인듯
        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
        RequestBody postBody = RequestBody.create(mediaType, postBodyText);

        OkHttpClient client = new OkHttpClient();

        // POST 사용
        Request request = new Request.Builder()
                .url(postUrl)
                .post(postBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Cancel the post on failure.
                call.cancel();

                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        responseText.setText("Failed to Connect to Server");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        try {
                            responseText.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    void postRequestExam() {

        String postUrl = "http://" + "172.30.1.23" + ":" + 5000 + "/landmark/jangchung";

        String postBodyText="Hello";
        //MediaType mediaType = MediaType.parse("text/plain");
        // 아마 한국어 입력하는 미디어 타입인듯
        MediaType mediaType = MediaType.parse("text/plain; charset=utf-8");
        RequestBody postBody = RequestBody.create(mediaType, postBodyText);

        OkHttpClient client = new OkHttpClient();

        // POST 사용
        Request request = new Request.Builder()
                .url(postUrl)
                .post(postBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Cancel the post on failure.
                call.cancel();

                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        e.printStackTrace();
                        TextView responseText = findViewById(R.id.responseText);
                        responseText.setText("Failed to Connect to Server");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // In order to access the TextView inside the UI thread, the code is executed inside runOnUiThread()
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView responseText = findViewById(R.id.responseText);
                        try {
                            responseText.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void sendServer(){
        class sendData extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onCancelled() {
                super.onCancelled();
            }

            @Override
            protected String doInBackground(Void... voids) {

                try {
                    OkHttpClient client = new OkHttpClient();
                    JSONObject jsonInput = new JSONObject();
                    jsonInput.put("creator_email",  "21800007@handong.edu");
                    jsonInput.put("creator_name",  "yebin.kang");

                    RequestBody reqBody = RequestBody.create(
                            MediaType.parse("application/json; charset=utf-8"),
                            jsonInput.toString()
                    );

                    Request request = new Request.Builder()
                            .post(reqBody)
                            .url(getUrl)
                            .build();

                    Response responses = null;
                    responses = client.newCall(request).execute();
                    System.out.println(responses.body().string());

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        sendData sendData = new sendData();
        sendData.execute();
    }
}