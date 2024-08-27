package basicCode;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {

    AndroidDriver driver;
    @BeforeEach
    public void init() throws MalformedURLException {
        //abrir la app
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","emulator-5554");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.google.android.youtube");
        config.setCapability("appium:appActivity","com.google.android.youtube.app.honeycomb.Shell$HomeActivity");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterEach
    public void clean(){
        //cerrar app
        driver.quit();
    }

    @Test
    public void thisIsATest() throws InterruptedException {
        Thread.sleep(5000);
    }
    @Test
    public void thisIsATest2(){
        System.out.println("ese es mi test 2");
    }
@Test
    public void searchVideo() throws InterruptedException {
        // steps
        // search textBox
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Search YouTube']")).click();
        // search
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.google.android.youtube:id/search_edit_text']")).sendKeys("linkin park numb");

        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.youtube:id/text' and @text='linkin park numb']")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.youtube:id/text\" and @text=\"linkin park in the end remix\"]")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Numb (Official Music Video) [4K UPGRADE] – Linkin Park - 3 minutes, 8 seconds - Go to channel - Linkin Park - 2.3B views - 17 years ago - play video']/android.widget.ImageView[2]")).click();



        Thread.sleep(5000);
        //verificacion
        // verificar que el resultado sea 12
//        String expectedResult="12";
//        String actualResult=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
//        Assertions.assertEquals(expectedResult,actualResult,
//                "La suma es incorrecta");
//        System.out.println("Resultado Esperado: " +expectedResult);
//        System.out.println("Resultado Real: " +actualResult);

    }

    @Test
    public void searchVideoYoutube() throws InterruptedException {
        // Search YouTube
        WebElement searchBox = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Search YouTube']"));
        searchBox.click();

        // Enter search query
        WebElement searchEditText = driver.findElement(By.id("com.google.android.youtube:id/search_edit_text"));
        searchEditText.sendKeys("linkin park numb");

        // Click on search suggestion
        WebElement searchSuggestion = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.youtube:id/text' and contains(@text, 'linkin park numb')]"));
        searchSuggestion.click();

        // Wait for search results to load
        Thread.sleep(5000);

        // Click on the first video result
        WebElement firstVideoResult = driver.findElement(By.xpath("(//android.view.ViewGroup[contains(@content-desc, 'Numb') and contains(@content-desc, 'Linkin Park')])[1]"));
        firstVideoResult.click();

        // Wait for video to start playing
        Thread.sleep(5000);

        // Verify video is playing
        WebElement videoPlayer = driver.findElement(By.id("com.google.android.youtube:id/player_view"));
        Assertions.assertTrue(videoPlayer.isDisplayed(), "Video player is not displayed");

        // Get video title
        WebElement videoTitle = driver.findElement(By.id("com.google.android.youtube:id/title"));
        String actualTitle = videoTitle.getText();
        Assertions.assertTrue(actualTitle.toLowerCase().contains("numb") && actualTitle.toLowerCase().contains("linkin park"),
                "Video title does not contain 'Numb' and 'Linkin Park'");

        System.out.println("Video title: " + actualTitle);

    }
}
