package suite;

import tests.ContactTests;
import tests.CookieTests;
import tests.DropdownTests;
import tests.HistoryTests;
import tests.HoverTests;
import tests.LoginTests;
import tests.InteractionsTests;
import tests.JavascriptTests;
import tests.MultiPageTests;
import tests.RandomContactTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContactTests.class,
        CookieTests.class,
        DropdownTests.class,
        HistoryTests.class,
        HoverTests.class,
        LoginTests.class,
        InteractionsTests.class,
        JavascriptTests.class,
        MultiPageTests.class,
        RandomContactTests.class,

})
public class AllTests {
}