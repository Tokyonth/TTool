package com.ttrpstudio.ttool.phoneinfo;

/**
 * Created by TOKYONTH on 2018/4/23/023.
 */

public class PhoneMsg {
/*
    //BOARD 主板
    String phoneInfo = "BOARD: " + android.os.Build.BOARD;
    phoneInfo += ", BOOTLOADER: " + android.os.Build.BOOTLOADER;
//BRAND 运营商
    phoneInfo += ", BRAND: " + android.os.Build.BRAND;
    phoneInfo += ", CPU_ABI: " + android.os.Build.CPU_ABI;
    phoneInfo += ", CPU_ABI2: " + android.os.Build.CPU_ABI2;

//DEVICE 驱动
    phoneInfo += ", DEVICE: " + android.os.Build.DEVICE;
//DISPLAY Rom的名字
    phoneInfo += ", DISPLAY: " + android.os.Build.DISPLAY;
//指纹
    phoneInfo += ", FINGERPRINT: " + android.os.Build.FINGERPRINT;
//HARDWARE 硬件
    phoneInfo += ", HARDWARE: " + android.os.Build.HARDWARE;
    phoneInfo += ", HOST: " + android.os.Build.HOST;
    phoneInfo += ", ID: " + android.os.Build.ID;
//MANUFACTURER 生产厂家
    phoneInfo += ", MANUFACTURER: " + android.os.Build.MANUFACTURER;
//MODEL 机型
    phoneInfo += ", MODEL: " + android.os.Build.MODEL;
    phoneInfo += ", PRODUCT: " + android.os.Build.PRODUCT;
    phoneInfo += ", RADIO: " + android.os.Build.RADIO;
    phoneInfo += ", RADITAGSO: " + android.os.Build.TAGS;
    phoneInfo += ", TIME: " + android.os.Build.TIME;
    phoneInfo += ", TYPE: " + android.os.Build.TYPE;
    phoneInfo += ", USER: " + android.os.Build.USER;
//VERSION.RELEASE 固件版本
    phoneInfo += ", VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE;
    phoneInfo += ", VERSION.CODENAME: " + android.os.Build.VERSION.CODENAME;
//VERSION.INCREMENTAL 基带版本
    phoneInfo += ", VERSION.INCREMENTAL: " + android.os.Build.VERSION.INCREMENTAL;
//VERSION.SDK SDK版本
    phoneInfo += ", VERSION.SDK: " + android.os.Build.VERSION.SDK;
    phoneInfo += ", VERSION.SDK_INT: " + Android.os.Build.VERSION.SDK_INT;
    */

    public static String model() {
        return android.os.Build.MODEL;
    }
    public static String version() {
        return String.valueOf(android.os.Build.VERSION.SDK_INT);
    }
}
