package chat.hemant.com.signup_firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyfirebaseInstanceId extends FirebaseInstanceIdService {

    private static final String TAG =MyfirebaseInstanceId.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshed_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token is"+refreshed_token);
    }
}
