package org.example.utils;

public class Utils {
    public static void logInfo(String message){
        if(ExtentReportManager.getTest() != null){
            ExtentReportManager.getTest().info(message);
        }
    }
}
