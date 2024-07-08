package com.pkg.utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    File src;
    FileInputStream fis;
    Properties prop;

    //Constructor
    public ConfigDataProvider() {
        src = new File("./Configurations/config.properties");
        try {
            fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Unable to read excel file "+ e.getMessage());
        }
    }

    //Enter Custom Value to search from config file
    public String getConfigData(String KeyToSearch)
    {
        return prop.getProperty(KeyToSearch);
    }

    //Getting browser value from config
    public String getConfigBrowserData()
    {
        return prop.getProperty("Browser");
    }
    //Getting QA-URL value from config
    public String getConfigQAurlData()
    {
        return prop.getProperty("qaURL");
    }


}
