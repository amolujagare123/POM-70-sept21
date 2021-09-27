package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        //1. read the properties file
        FileInputStream fis = new FileInputStream("config/config.properties");

        // 2. create the object of properties
        Properties prop = new Properties();

        // 3. load the properties object with file object
        prop.load(fis);

        //4. read value of key
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }
}
