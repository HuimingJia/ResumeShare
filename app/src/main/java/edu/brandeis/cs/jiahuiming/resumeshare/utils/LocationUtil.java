package edu.brandeis.cs.jiahuiming.resumeshare.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;

import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import edu.brandeis.cs.jiahuiming.resumeshare.views.activities.HomeActivity;

/**
 * Created by Horace on 16/11/9.
 */
public class LocationUtil {

    private Context context;
    private GeoPoint p;
    private LocationManager lm;
    private LocationListener locationListener;


    public LocationUtil(Context context){

        this.context=context;
    }

    public void method(){

        lm=(LocationManager)((HomeActivity)context).getSystemService(Context.LOCATION_SERVICE);
        locationListener=new MyLocationListener();
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, locationListener);
    }
    private class MyLocationListener implements LocationListener{

        public void onLocationChanged(Location loc){
            if(loc!=null){
                Toast.makeText(context,"Lat: "+loc.getLatitude()+"Lng: "+loc.getLongitude(),Toast.LENGTH_LONG).show();

            }
            p=new GeoPoint((int)(loc.getLatitude()*1E6),(int)(loc.getLongitude()*1E6));


        }
        public void onProviderDisabled(String provider){

        }
        public void onProviderEnabled(String provider){

        }
        public void onStatusChanged(String provider,int status,Bundle extras){

        }



    }

//    public void runLocation(){
//        if(openGPSSettings()){
//
//        }
//        else{
//
//
//        }
//
//
//
//    }
//    private boolean openGPSSettings() {
//
//        LocationManager alm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//        if (alm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
//            Toast.makeText(context, "GPS模块正常", Toast.LENGTH_SHORT).show();
//            doWork();
//            return true;
//        } else {
//            Toast.makeText(context, "请开启GPS！", Toast.LENGTH_SHORT).show();
//            //Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
//            //startActivityForResult(intent, 0); // 此为设置完成后返回到获取界面
//            return false;
//        }
//
//    }
//    public void doWork() {
//
//        String msg = "";
//
//        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//
//        Criteria criteria = new Criteria();
//        // 获得最好的定位效果
//        criteria.setAccuracy(Criteria.ACCURACY_FINE);
//        criteria.setAltitudeRequired(false);
//        criteria.setBearingRequired(false);
//        criteria.setCostAllowed(false);
//        // 使用省电模式
//        criteria.setPowerRequirement(Criteria.POWER_LOW);
//        // 获得当前的位置提供者
//        String provider = locationManager.getBestProvider(criteria, true);
//        // 获得当前的位置
//        if ( ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
//
//            ActivityCompat.requestPermissions( context, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION}, LocationService.MY_PERMISSION_ACCESS_COURSE_LOCATION );
//        }
//        //
//        Location location = locationManager.getLastKnownLocation(provider);
//
//        double latitude = location.getLatitude();
//        double longitude = location.getLongitude();
//
//    }
//
//        private void getLocationByNetwork() {
//        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//        LocationListener locationListener = new LocationListener() {
//
//            // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
//            @Override
//            public void onStatusChanged(String provider, int status,
//                                        Bundle extras) {
//
//            }
//
//            // Provider被enable时触发此函数，比如GPS被打开
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            // Provider被disable时触发此函数，比如GPS被关闭
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//
//            // 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
//            @Override
//            public void onLocationChanged(Location location) {
//                if (location != null) {
//                    Log.e("Map",
//                            "Location changed : Lat: " + location.getLatitude()
//                                    + " Lng: " + location.getLongitude());
//                }
//            }
//        };
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        double latitude = 0;
//        double longitude = 0;
//        if (location != null) {
//            latitude = location.getLatitude(); // 经度
//            longitude = location.getLongitude(); // 纬度
//        }
//
//        String locationString = "&location=" + latitude + "," + longitude;
//
//        Toast.makeText(context, locationString, Toast.LENGTH_LONG).show();
//
//    }
}
