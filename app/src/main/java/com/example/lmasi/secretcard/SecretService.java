package com.example.lmasi.secretcard;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by lmasi on 2016-11-07.
 */
public class SecretService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    NotificationManager manager;
    NotificationCompat.Builder builder;
    Notification notification;
    Handler hd;

    @Override
    public void onCreate() {
        super.onCreate();

        hd = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                noti();
                sendEmptyMessageDelayed(0, 1000);
            }
        };

        hd.sendEmptyMessage(0);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
    }

    public void noti()
    {
        //알림(Notification)을 관리하는 NotificationManager 얻어오기
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //알림(Notification)을 만들어내는 Builder 객체 생성
        //API 11 버전 이하도 지원하기 위해 NotificationCampat 클래스 사용
        //만약 minimum SDK가 API 11 이상이면 Notification 클래스 사용 가능
        builder = new NotificationCompat.Builder(getApplicationContext());
        //Notification.Builder에게 Notification 제목, 내용, 이미지 등을 설정//////////////////////////////////////

        builder.setSmallIcon(R.drawable.keypad_01);//상태표시줄에 보이는 아이콘 모양
        builder.setTicker("Secret Card"); //알림이 발생될 때 잠시 보이는 글씨

        //상태바를 드래그하여 아래로 내리면 보이는 알림창(확장 상태바)의 아이콘 모양 지정
        //builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.noti_icon));
        builder.setContentTitle("Secret Card");    //알림창에서의 제목
        builder.setContentText("");   //알림창에서의 글씨
        builder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), Secret.class), PendingIntent.FLAG_UPDATE_CURRENT));
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        notification = builder.build();   //Notification 객체 생성
        manager.notify(1, notification);             //NotificationManager가 알림(Notification)을 표시
    }


}
