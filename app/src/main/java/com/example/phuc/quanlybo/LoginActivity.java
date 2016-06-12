package com.example.phuc.quanlybo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phuc.quanlybo.model.UserDetail;
import com.example.phuc.quanlybo.service.QuanlyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by phuc on 04/04/2016.
 */
public class LoginActivity extends Activity {
    private EditText phoneNumber;
    private EditText password;
    private Button btnLogin;
    public static final String BASE_URL = "http://nuoiboso.pkgs.vn/";
    //public static final String BASE_URL = "https://httpbin.org/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    QuanlyService service = retrofit.create(QuanlyService.class);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        LoginButton();
    }

    public void LoginButton(){
        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_phoneNumber = phoneNumber.getText().toString();
                String str_password = password.getText().toString();

                Call<UserDetail> userDetailCall = service.getUserLogin(str_phoneNumber, str_password);

                userDetailCall.enqueue(new Callback<UserDetail>() {
                    @Override
                    public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                        Log.d("success", Integer.toString(response.code()));

                        // if parsing the JSON body failed, `response.body()` returns null
                        UserDetail decodedResponse = response.body();
                            if (decodedResponse == null) return;

                        if(decodedResponse.getStatusID().equals("U22000")) {
                            Log.d("id", decodedResponse.getData().get("id").toString());
                            Log.d("phoneNumber", decodedResponse.getData().get("phoneNumber").toString());
                            Log.d("email", decodedResponse.getData().get("email").toString());
                        }
                        else if(decodedResponse.getStatusID().equals("32000")) {
                            Log.d("id", decodedResponse.getData().get("id").toString());
                            Log.d("phoneNumber", decodedResponse.getData().get("phoneNumber").toString());
                            Log.d("email", decodedResponse.getData().get("email").toString());
                        }

                    }

                    @Override
                    public void onFailure(Call<UserDetail> call, Throwable t) {
                        Log.d("failure",t.toString());
                    }
                });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }



    @Override
    protected void onStart() {
        super.onStart();
    }
}
