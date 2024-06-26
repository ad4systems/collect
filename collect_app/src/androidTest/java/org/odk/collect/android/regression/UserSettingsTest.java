package org.odk.collect.android.regression;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.runner.RunWith;
import org.odk.collect.android.support.rules.CollectTestRule;
import org.odk.collect.android.support.rules.TestRuleChain;
import org.odk.collect.android.support.pages.MainMenuPage;

//Issue NForm Plus-241
@RunWith(AndroidJUnit4.class)
public class UserSettingsTest {

    public CollectTestRule rule = new CollectTestRule();

    @Rule
    public RuleChain ruleChain = TestRuleChain.chain()
            .around(rule);

    @Test
    public void typeOption_ShouldNotBeVisible() {
        //TestCase1
        new MainMenuPage()
                .openProjectSettingsDialog()
                .clickSettings()
                .clickAccessControl()
                .openUserSettings()
                .assertTextDoesNotExist("Type")
                .assertTextDoesNotExist("Submission transport")
                .assertText(org.odk.collect.strings.R.string.server_settings_title);
    }
}
