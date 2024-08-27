package activities.youtube;

import controls.*;
import org.openqa.selenium.By;

public class MainActivity {

    //public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public TextBox searchBox = new TextBox(By.xpath("//android.view.ViewGroup[@content-desc='Search YouTube']"));

    public TextBox searchEditText = new TextBox(By.id("com.google.android.youtube:id/search_edit_text"));

    public Label searchSuggestion = new Label(By.xpath("//android.widget.TextView[@resource-id='com.google.android.youtube:id/text' and contains(@text, 'linkin park numb')]"));

    public View firstVideoResult = new View(By.xpath("(//android.view.ViewGroup[contains(@content-desc, 'Numb') and contains(@content-desc, 'Linkin Park')])[1]"));

    public View videoPlayer = new View(By.id("com.google.android.youtube:id/player_view"));

    public Title videoTitle = new Title(By.id("com.google.android.youtube:id/title"));

//    public boolean isVideoDisplayed(String nameTask){
//        View videoPlayer = new View(By.id("com.google.android.youtube:id/player_view"));
//        return videoPlayer.isDisplayed();
//    }

}

