package testSuite;

import activities.youtube.MainActivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class YoutubeTest {

    private MainActivity mainActivity;

    @BeforeEach
    public void openApp(){
        mainActivity = new MainActivity();
    }
    @Test
    public void verifySearchVideo() throws InterruptedException {

        String nameVideo = "linkin park numb";
        mainActivity.searchBox.waitForVisibility(30);
        mainActivity.searchBox.click();
        mainActivity.searchEditText.setText(nameVideo);
        mainActivity.searchSuggestion.click();
        Thread.sleep(5000);
        mainActivity.firstVideoResult.click();
        Thread.sleep(5000);
        // Verificar que el reproductor de video está visible
        Assertions.assertTrue(mainActivity.videoPlayer.isControlDisplayed(),
                "El reproductor de video no está visible");

    }
}
