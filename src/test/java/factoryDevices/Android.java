package factoryDevices;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevices{
    @Override
    public AndroidDriver create() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","emulator-5554");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.google.android.youtube");
        config.setCapability("appium:appActivity","com.google.android.youtube.app.honeycomb.Shell$HomeActivity");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }
}