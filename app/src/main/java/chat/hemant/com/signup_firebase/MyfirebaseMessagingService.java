package chat.hemant.com.signup_firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyfirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG ="MyfireService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG,"from" + remoteMessage.getFrom());

        if (remoteMessage.getData().size()>0){
            Log.d(TAG,"Data is " +remoteMessage.getData());


        }
        if (remoteMessage.getNotification()!=null){
            Log.d(TAG,"Message body" + remoteMessage.getNotification().getBody());
            sendnotification(remoteMessage.getNotification().getBody());
        }


    }

    private void sendnotification(String body) {

        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        // set NOtification sound
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder  notificationbuilder= new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hemant Firebase Done")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notification)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationbuilder.build());
    }
}