# GPSLogTracker



## I. Introduction

- This Application is for tracking GPS location using NETWORK_PROVIDER



## II. functions

- catch current GPS location
  - LocationManager
  - LocationListener



- see mapView markers using TMap API
  - TMapView
  - TMapMarkerItem



- calculate distance and speed using the location info
  - calcDistance
  - calcSpeed
  - Ref : https://sijoo.tistory.com/165



- save the data to txt files
  - saveTheData
  - format (delimeter : ',')
    - yyyy-MM-dd
    - kk:mm:ss
    - latitude
    - longitude
    - distance
    - speed