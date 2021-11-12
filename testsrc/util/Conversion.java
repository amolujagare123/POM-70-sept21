package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static  String convertCountry(String shortCounty) //db
    {
        String convertedCountry = "";

        switch (shortCounty)
        {
            case "IN" : convertedCountry ="India" ; break;
            case "CN" : convertedCountry ="China" ; break;
            case "AU" : convertedCountry ="Australia" ; break;
            case "BF" : convertedCountry ="Bahrain" ; break;
        }

        return convertedCountry;
    }


    public static String convertGender(String genderID) // db
    {
        String convertedGender ="";
        switch (genderID) {
            case "0":
                convertedGender = "Male";
                break;
            case "1":
                convertedGender = "Female";
                break;
            case "2":
                convertedGender = "Other";
                break;
        }

            return convertedGender;
    }

    public static String convertDate(String dbDate) throws ParseException //yyyy-MM-dd
    {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sd.parse(dbDate);

        SimpleDateFormat sd1 = new SimpleDateFormat("MM/dd/yyyy");

        return sd1.format(date);

    }
}
