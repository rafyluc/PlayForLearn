package com.example.adi.playforlearn10;

import android.graphics.Rect;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends ActivityInstrumentationTestCase2 {
    private LoginActivityRaffaele login;
    private View mainLayout;

    public ExampleUnitTest() {
        super(LoginActivityRaffaele.class);
    }



    public void testLoginButtonOnScreen() throws Exception {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        Button login_utenti = (Button) login.findViewById(R.id.buttonUserLogin)
                ;

        login_utenti.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        login_utenti.getDrawingRect(outRect);
        assertTrue("Add button off the right of the screen", fullWidth
                + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Add button off the bottom of the screen", fullHeight
                + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }

    public void testRegisterButtonOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);
        int[] viewLocation = new int[2];
        Button registrazione = (Button)
                login.findViewById(R.id.buttonRegistrati);
        registrazione.getLocationOnScreen(viewLocation);
        Rect outRect = new Rect();
        registrazione.getDrawingRect(outRect);
        assertTrue("Multiply button off the right of the screen", fullWidth
                + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Multiply button off the bottom of the screen",
                fullHeight
                        + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }

    @Test
    public void inserimento() throws Exception {

    }
  //  public void addition_isCorrect() throws Exception {
    //   assertEquals(4, 2 + 2);
    //}
}