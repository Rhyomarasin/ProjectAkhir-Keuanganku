package com.papb.project.keuanganku;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class notif {
    private final int notifId = 100;
    private String chID = "ch_id" ;
    private String chName = "notif";

    public void sendNotif(String tittle, String isi, String appName, Context context){
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, chID)
                .setSmallIcon(R.drawable.picture)
                .setLargeIcon(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.ic_logo))
                .setContentTitle(tittle)
                .setContentText(isi)
                .setSubText(appName)
                .setAutoCancel(false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(chID,chName,NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(chName);
            builder.setChannelId(chID);
                    if(notificationManager != null ){
                        notificationManager.createNotificationChannel(channel);
                    }
        }
      Notification notification = builder.build();
        if(notificationManager != null){
            notificationManager.notify(notifId,notification);
        }
    }
}
