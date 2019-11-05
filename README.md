# 커넥티드카 IoT 통합관제 시스템 개발 (Connected Car Control System)



## Introduction

- This Repository is for Controling Connected Car System (2019-09-21 ~ 2019-10-31)



## Content

1. [OutLine](#outline)

2. [Diagram](#diagram)

3. [ERD](#erd)

4. [Software Stacks](#software-stacks)
   - [WAS](#was)
   - [PAD](#pad)
   - [IoT & ECU](#iot-ecu)
   - [ECU Simulator](#ecu-simulator)
   - [Native App](#native-app)
   - [LogCatcher](#logcatcher)

5. [ETC](#etc)
   - CAN Protocol
   - Ref



## OutLine

![시스템 개요](https://user-images.githubusercontent.com/50862254/68084637-ae499080-fe7b-11e9-9bb8-011b637e249e.png)



## Diagram

![전체 구성도](https://user-images.githubusercontent.com/50862254/68084665-fd8fc100-fe7b-11e9-9fcf-b8cae89df835.png)



## ERD

![ERD](https://user-images.githubusercontent.com/50862254/68084613-45faaf00-fe7b-11e9-94d8-7fe38e00c41f.PNG)



## Software Stacks

![Software_Stacks_1](https://user-images.githubusercontent.com/4971222/68232288-22cd2c80-0040-11ea-825b-39fd4c5d4773.png)



![Software_Stacks_2](https://user-images.githubusercontent.com/4971222/68232441-69bb2200-0040-11ea-870d-96bbc28db6bb.png)



### WAS

![WAS구성도](https://user-images.githubusercontent.com/50862254/68084673-1c8e5300-fe7c-11e9-996f-c76246f1a28f.png)

- [WAS Code](/ConnectedCarControlSystem)
- Functions
  - Spring Framework & Tomcat : WAS is executed on Spring Framework & Tomcat
    - MainServer
      - This function is for connecting with Connected Car's PAD using socket
      - If PAD is connected with Socket in WAS, The user can control Connected Car in realtime
    - Controller
      - This function is for responsing the user's request
      - The controller make html file using JSP, JSTL and send the file to users
      - Also, Connected Car's PAD send the car's data continually using HTTP Protocol
      - Controller save the car's data in Database
      - The user can access this function in PC, Mobile both
    - MyBatis + OracleDB
      - This function is for saving or getting the data from Database
      - DataBase have the data of user and car according to ERD Tables
      - There is the mapper for connecting among Spring Framework, MyBatis, Oracle



### PAD

![Android PAD](https://user-images.githubusercontent.com/50862254/68084688-45164d00-fe7c-11e9-8c3c-3722e8631bd1.png)

- [PAD Code](/ServerIoTCommunicationExcerise)
- Functions
  - This Application is run on 10.1' Tablet
  - ConnectIoTTask
    - This function is for connecting with IoT using Socket
    - IoT send car's data formed CAN Protocol
    - PAD parse and save the data
    - PAD send the data to IoT also
  - ConnectServerTask
    - This function is for connecting with WAS using Socket
    - WAS send control data for Connected Car
    - PAD send the data to IoT
  - RealTimeController
    - This function is for saving the data of Connected car's status
  - ConsumableController
    - This function is for saving the data of Connected car's consumable items
  - ChangeTimeInRealTime
    - This function is the Thread for checking 1 second in PAD
  - SendStateWithHttp
    - When ChangeTimeInRealTime function have the every 1 second event,
    - SendStateWithHttp gather the data in RealTimeController and Consumable Controller
    - And Send the data formed JSONObject to WAS using HTTP Protocol
  - SoundPlayClass
    - This functions is for playing the sound of warning in Connected Car
  - Fragments
    - MapFragment
      - This function is for viewing the map using TMap API
    - RealTimeFragment
      - This function is for viewing the Connected Car's realtime Status data
    - ConsumableFragment
      - This function is for viewing the Connected Car's consumable items' data



### IoT, ECU

![IoT-ECU](https://user-images.githubusercontent.com/50862254/68084693-5c553a80-fe7c-11e9-863d-642ca27ca731.png)

- [IoT Code](/can) & [IoT Refactoring ver](/canM)
- [ECU Code](/ECU)
- Functions
  - IoT
    - SerialTestS
      - This function is for getting data from CAN Bus
      - SerialTestS send the data to DataCallback
    - Receiver
      - This function is for getting data from PAD
      - receiver send the data to DataCallback
    - DataCallback
      - This function is for getting datas from SerialTestS or Receiver
      - If data from Receiver, send the data to CAN Bus
      - If data from SerialTestS, send the data to PAD
  - ECU
    - ECU ServerThread
      - This function is for connecting with ECU Simulator using Socket
      - If getting data from ECU Simulator, send the data to ECU
      - If getting data from ECU, send the data to ECU Simulator also
    - ECU
      - This functions is for connecting with CAN Bus
      - If getting data from CAN Bus, send the data to ECU ServerThread
      - If getting data from ECU ServerThread, send the data to CAN Bus



### ECU Simulator

- [ECU Simulator Code](/ECUSimulator)
- Functions
  - This Application is run on 10.1' Tablet
  - MainActivity
    - This functions is for viewing Connected Car's status
    - Users can change the car's status using SeekBar
    - When changing the status, the changed data is formed by CAN Protocol
    - And sent to ECU using socket
  - ConnectServerTask
    - This functions is for connecting with ECU using socket



### Native App

- [Native App Code](/MobileApplication)
- Functions
  - WebView
    - This function is for viewing Web Site using requesting the page to WAS
  - Firebase
    - This function is setting the firebase for push notification
    - When users execute this native app, The app request the token from firebase server
    - When users try login, WAS get and save this token
    - And the phone can get push notification from firebase server



### LogCatcher

- [GPSLogTracker](/LogCatcher/GPSLogTracker)
- [GPSLogSampler](/LogCatcher/GPSLogSampler)
- [GPSLogChangeStandards](/LogCatcher/GPSLogChangeStandards)
- This Applications is for getting the sample logs
- Functions
  - GPSLogTracker
    - This function is for getting current Locations using NETWORK_PROVIDER
    - Because of other obstacles, locations accuracy is very low
    - After getting locations,
      - time, hms, latitude, longitude, distance, speed infomations is saved to txt files
  - GPSLogSampler
    - Because Tracker's location accuracy was very low, we need to use sampler
    - using the txt files which we save by tracker, we can rearrange the locations
    - We can choose 3 options
      - Save
      - Change the location to previous location
      - remove
    - After getting sample,
      - time, hms, latitude, longitude, newDistance, newSpeed infomations is saved to txt files
  - GPSLogChangeStandards
    - Distance and Speed's Standard was meter, m/s
    - this application can change the standards to kilometer, km/h
    - After changing,
      - time. hms. latitude, longitude, newNewDistance, newNewSpeed infomations is saved to txt files



- Distance Calculation Reference : https://sijoo.tistory.com/165



## ETC

- CAN Protocol

![IoT통신규야](https://user-images.githubusercontent.com/50862254/68084695-7000a100-fe7c-11e9-9fd0-a54545b6200b.png)

- Ref
  - [RFP](/Ref/RFP)
  - [Proposal](/Ref/Proposal)
  - [DB_Setting](/Ref/DB_Setting)
  - [Hadoop_Hive_Setting](/Ref/Hadoop_Hive_Setting)
  - [Final_Report](/Ref/Final_Report)