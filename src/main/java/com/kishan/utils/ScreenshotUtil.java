package com.kishan.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String take(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String folder = "screenshots";
            File dest = new File(folder, name + "_" + ts + ".png");
            dest.getParentFile().mkdirs();
            FileHandler.copy(src, dest);
            return dest.getPath();
        } catch (IOException e) {
            return null;
        }
    }
}
