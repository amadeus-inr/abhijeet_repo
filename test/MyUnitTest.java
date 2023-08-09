import controllers.AssetsFinder;
import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A functional test starts a Play application for every test.
 *
 * https://www.playframework.com/documentation/latest/JavaFunctionalTest
 */
public class MyUnitTest extends WithApplication {

    @Test
    public void renderTemplate() {
        // If you are calling out to Assets, then you must instantiate an application
        // because it makes use of assets metadata that is configured from
        // the application.

        AssetsFinder assetsFinder = provideApplication().injector().instanceOf(AssetsFinder.class);

        Content html = views.html.hello.render("Abhijeet", assetsFinder);
        assertThat("text/html").isEqualTo(html.contentType());
        assertThat(html.body()).contains("Hello, Abhijeet");
    }
}
