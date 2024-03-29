package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_eqals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            var btn_one = (Button) activity.findViewById(R.id.btn_one);
            var btn_plus = (Button) activity.findViewById(R.id.btn_plus);
            var btn_equals = (Button) activity.findViewById(R.id.btn_equals);
            var display = (TextView) activity.findViewById(R.id.display);
            btn_one.performClick();
            btn_plus.performClick();
            btn_one.performClick();
            btn_equals.performClick();
            assertEquals(display.getText(), "2");
        });

    }
}
