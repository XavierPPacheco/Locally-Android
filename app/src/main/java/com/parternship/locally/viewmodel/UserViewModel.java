package com.parternship.locally.viewmodel;

import android.app.Application;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONObject;

public class UserViewModel extends AndroidViewModel {

    public UserViewModel(@NonNull Application application) {
        super(application);
    }
    String name = "Teste";

    GraphRequest request = GraphRequest.newMeRequest(
            AccessToken.getCurrentAccessToken(),
            new GraphRequest.GraphJSONObjectCallback() {

                @Override
                public void onCompleted(
                        JSONObject object,
                        GraphResponse response) {
                    // Application code
                }
            });
Bundle param = new  Bundle();//.putString("fields","email,name,link");
  //  param.putString("fields", "email,name");


//    request.setParameters(parameters);
    //request.executeAsync();
}
