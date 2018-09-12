package com.example.pc_white.loginpruebaf;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * Created by Alexis
 * 11/09/2018
 * Proyecto: Oblea comestible
 **/

public class MainActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        LoginButton login_btn = findViewById(R.id.login_button);
        login_btn.setReadPermissions("email");
        login_btn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserDetails(loginResult);
            }

            @Override
            public void onCancel() {
                // code
            }

            @Override
            public void onError(FacebookException exception) {
                //  code
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        Intent intent = new Intent(MainActivity.this, UserProfile.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }

    protected void onResume() {
        super.onResume();


    }
    @Override
    protected void onPause() {
        super.onPause();


    }
        //generate KeyHash

        //try {
        //  PackageInfo info = getPackageManager().getPackageInfo("com.example.pc-white.loginpruebaf",
        //         PackageManager.GET_SIGNATURES);
        //for(Signature signature : info.signatures){
        //  MessageDigest md = MessageDigest.getInstance("SHA");
        //md.update(signature.toByteArray());
        //    Log.d("KeyHash:", Base64.encodeToString(md.digest(),Base64.DEFAULT));
        //}
        //} catch (PackageManager.NameNotFoundException e) {
        //  e.printStackTrace();
        //} catch (NoSuchAlgorithmException e) {
        //  e.printStackTrace();
        // }




    }
