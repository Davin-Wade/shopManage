package shopping.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    static Properties pro = null;

    static{
        pro = new Properties();
        InputStream is = DBConfig.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return pro.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getValue("url"));

    }
}
