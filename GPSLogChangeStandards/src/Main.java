import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat hmsFormat = new SimpleDateFormat("kk-mm-ss");
	
	private static ArrayList<LocationInfo> locationInfos;
	
	public static void main(String[] args) {
		locationInfos = new ArrayList<LocationInfo>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("넣을 파일이름을 입력해 주세욧");
		String fileName = sc.next();
		
		getDataFromFile(fileName);
		
		for (LocationInfo locationInfo : locationInfos) {
			System.out.println(locationInfo.toString());
		}
		
		saveTheData(new Date());
	}
	
	private static void saveTheData(Date date) {
		File file = null;
        FileOutputStream fos = null;
        String dataName = "ChangedStandards_GPSData" + "_" + dayFormat.format(date) + "_" + hmsFormat.format(date) + ".txt";

        try {
            file = new File(System.getProperty("user.dir"),dataName);
            fos = new FileOutputStream(file);

            String msg = "";

            for (LocationInfo locationInfo : locationInfos) {
                msg = locationInfo.getDateStr() +
                        "," + locationInfo.getHmsStr() +
                        "," + locationInfo.getLatitude() +
                        "," + locationInfo.getLongitude() +
                        "," + locationInfo.getDistance() +
                        "," + locationInfo.getSpeed() + "\n";

                fos.write(msg.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	private static void getDataFromFile(String fileName) {
		File file = null;
		FileInputStream fin = null;
		BufferedReader br = null;
		double totalDistance = 0;
		
		try {
			file = new File(System.getProperty("user.dir"), fileName);
			fin = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fin));
			
			String oneLine = "";
			
			while((oneLine = br.readLine()) != null) {
				String[] oneLineSpliter = oneLine.split(",");
				
				String dateStr = oneLineSpliter[0];
				String hmsStr = oneLineSpliter[1];
				double latitude = Double.parseDouble(oneLineSpliter[2]);
				double longitude = Double.parseDouble(oneLineSpliter[3]);
				double distance = Double.parseDouble(oneLineSpliter[4]);
				double speed = Double.parseDouble(oneLineSpliter[5]);
				
				double newDistance = makeKiloMeter(distance);
				double newSpeed = makeKiloPerHour(speed);
				
				totalDistance += newDistance;
				
				LocationInfo locationInfo = new LocationInfo(latitude, longitude, dateStr, hmsStr, totalDistance, newSpeed);
				locationInfos.add(locationInfo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static double makeKiloPerHour(double speed) {
		double kiloPerHourSpeed = speed * 3.6;
		
		return kiloPerHourSpeed;
	}
	
	private static double makeKiloMeter(double distance) {
		double kiloDistance = distance / 1000.0d;
		
		return kiloDistance;
	}
}

class LocationInfo {
    private double latitude;
    private double longitude;
    private String dateStr;
    private String hmsStr;
    private double distance;
    private double speed;
    
	public LocationInfo(double latitude, double longitude, String dateStr, String hmsStr, double distance,
			double speed) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateStr = dateStr;
		this.hmsStr = hmsStr;
		this.distance = distance;
		this.speed = speed;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getDateStr() {
		return dateStr;
	}

	public String getHmsStr() {
		return hmsStr;
	}

	public double getDistance() {
		return distance;
	}

	public double getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return "LocationInfo [latitude=" + latitude + ", longitude=" + longitude + ", dateStr=" + dateStr + ", hmsStr="
				+ hmsStr + ", distance=" + distance + ", speed=" + speed + "]";
	}
}
