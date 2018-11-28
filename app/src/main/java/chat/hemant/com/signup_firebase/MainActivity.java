package chat.hemant.com.signup_firebase;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity  {
  private Button button;
    private FirebaseAuth firebaseAuth;
    private static final String TAG =MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.buttonSignup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tkn = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(MainActivity.this,tkn.toString(),Toast.LENGTH_SHORT).show();
                Log.d(TAG,"TOken ID" +tkn);
                Toast.makeText(MainActivity.this,tkn,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
