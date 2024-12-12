package common;

public class Constants {
    public static String HEADELESS = System.getProperty("headless", "false");
    public static String USERNAME = System.getProperty("username", "Admin");
    public static String PASSWORD = System.getProperty("password", "admin123");
    public static String INVALID_PASSWORD = System.getProperty("invalid.password", "admin12");

}
