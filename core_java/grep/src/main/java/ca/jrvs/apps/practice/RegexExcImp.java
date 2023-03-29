package ca.jrvs.apps.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc{


    public boolean matchJpeg(String fileName) {
        String regex1 = "([^\\s]+(\\.(?i)(jpe?g))$)";
        return fileName.matches(regex1);
    }

    public boolean matchIp(String ip) {
        String regex2 = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(regex2);
    }



    public boolean isEmptyLine(String line) {
        String regex3= "^[ \\t\\n]*$";
        return line.matches(regex3);
    }
}
