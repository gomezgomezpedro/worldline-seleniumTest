package UtilityClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetConfigProperties {
    public Properties configProperties(){
        Properties config = new Properties();
        try{
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            config.load(input);
        } catch (IOException ex){
            System.out.println(ex);
            System.out.println("Could not find config.properties file");
        }
        return config;
    }
}
