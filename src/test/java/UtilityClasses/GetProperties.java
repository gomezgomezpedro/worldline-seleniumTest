package UtilityClasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class GetProperties {
    Logger logger = LoggerFactory.getLogger(GetProperties.class);
    public Properties getProperties(String fileName){
        Properties props = new Properties();
        try{
            InputStream input = Files.newInputStream(Paths.get("src/test/resources/" + fileName));
            props.load(input);
        } catch (IOException ex){
            logger.debug("Could not find " + fileName + " file");
        }
        return props;
    }
}