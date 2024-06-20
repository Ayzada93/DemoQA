import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

@Test(description = "Verify double click button is working propertly")
    public  void doubleClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.doubleClick(demoQaPages.getButtonsPage().doubleClickBtn);
    Assert.assertEquals(demoQaPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");

}
@Test(description = "Verify right click button is working propertly")
    public void rightClickTest(){
    browserHelper.open("https://demoqa.com/buttons");
    webElementActions.rightClick(demoQaPages.getButtonsPage().rightClickBtn);
    Assert.assertEquals(demoQaPages.getButtonsPage().rightClickMessage.getText(),"You have done a right click");
}

}
