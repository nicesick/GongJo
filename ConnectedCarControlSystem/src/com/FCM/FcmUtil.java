package com.FCM;

import java.io.FileInputStream;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

import freemarker.core.Environment;

@Component
public class FcmUtil {
	String tokenID = "divxoyoPI5k:APA91bFEXFvtOdjW5aNNDgOkkbhpj9h7ITiU4I0jJOzWmZ_"
			+ "LHaEFrdRVH2lRUmVDMxxMMPcCO3tbQ6_qTe8UkT-GzO61DEfXvXuYEN-"
			+ "eYpapkbpqBWqXAHrHIyLNP50rErUEpRBYuiXw";
	String titleMSG = "CAUSE";
	String bodyMSG = "you turn on light!!";
	public void makeFCMEnvironment(String car_id) {
		
	}
	public void send_FCM(String tokenId,String title,String context) {
		try {
			FileInputStream refreshToken = new FileInputStream(
					"C:\\Users\\student\\Desktop\\GongJo\\ConnectedCarControlSystem\\resource\\gongjo-93a9f-firebase-adminsdk-qwyxy-674f31e157.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(refreshToken))
					.setDatabaseUrl("https://gongjo-93a9f.firebaseio.com")
					.build();
			if(FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
			
			String registrationToken = tokenId;
			
			Message msg = Message.builder()
					.setAndroidConfig(AndroidConfig.builder()
							.setTtl(1000)
							.setPriority(AndroidConfig.Priority.NORMAL)
							.setNotification(AndroidNotification.builder()
									.setTitle(title)
									.setBody(context)
									.build())
							.build())
//					.putData("title", title)
//					.putData("body", context)
					.setToken(registrationToken).build();
			
			String response = FirebaseMessaging.getInstance().send(msg);
			System.out.println(response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
