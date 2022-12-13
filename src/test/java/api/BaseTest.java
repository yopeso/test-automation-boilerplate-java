package api;

import dev.failsafe.event.EventListener;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.testng.annotations.BeforeTest;
import skynet.utils.Logger;

import java.util.function.Consumer;


public class BaseTest {
    @BeforeTest
    public void before(){
        Consumer<Description> descriptionConsumer = desc ->Logger.info("Assertions : "+desc.toString());
        Assertions.setDescriptionConsumer(descriptionConsumer);
    }
}
