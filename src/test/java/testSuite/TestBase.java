package testSuite;

import activities.youtube.TaskFormActivity;
import activities.youtube.MainActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

public class TestBase {
    public MainActivity mainActivity;
    public TaskFormActivity taskFormActivity;

    @BeforeEach
    public void openApp(){
        mainActivity = new MainActivity();
        taskFormActivity = new TaskFormActivity();
    }
    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }

}
