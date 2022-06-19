package org.petApi.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;   //this is predefined class used to identify the .property file

    public ConfigFileReader(String propertyFilePath){
        propertyFilePath = "src/test/resources/" + propertyFilePath;
        BufferedReader reader;     // This is predifined class used to read the file
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(".properties not found at " + propertyFilePath);
        }
    }

    public String getApiEnvironment() {
        String url = properties.getProperty("BASE_URL");
        if(url != null)
            return url;
        else
            throw new RuntimeException("base_url is not specified in the .properties file.");
    }
}
