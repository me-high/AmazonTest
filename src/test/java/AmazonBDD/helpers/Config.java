package AmazonBDD.helpers;

import java.util.ResourceBundle;

/**
 * Created by Mihai on 11.09.2014.
 */
public class Config {

    private String browserType;
    private String baseURL;
    private ResourceBundle prop = ResourceBundle.getBundle("configuration");
    public Config(){
        if (System.getProperty("browserType") != null) {
            setBrowserType(System.getProperty("browserType"));
        } else {
//            log.debug("browser not set as system property! Getting value from file..");
            setBrowserType(prop.getString("browserType"));
        }
    }
    public void setBrowserType (String browserType){
        this.browserType = browserType;
    }

    public String getBrowserType (){
        return browserType;
    }

    public void setBaseURL (String baseURL){
        this.baseURL = baseURL;
    }

    public String getBaseURL (){
        return baseURL;
    }
}
