package com.controller;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.vo.CarGroup;
import com.vo.DeviceToken;

@Component
public class fcmController {
	private ArrayList<CarGroup> carGroups;
	
	
	
}
