package Tests.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class DriverFactory {

    private volatile AppiumDriver<MobileElement> driver = null;

    protected final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

    protected abstract AppiumDriver<MobileElement> createDriver();

    protected final AppiumDriver<MobileElement> getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    protected DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getPlatformName());
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/" + getAppName());
        capabilities.setCapability("deviceName", getDeviceName());
        return capabilities;
    }

    protected abstract String getDeviceName();

    protected abstract String getAppName();

    protected abstract String getPlatformName();

}
