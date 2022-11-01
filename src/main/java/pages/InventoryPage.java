package pages;

import skynet.interactions.Elements;
import skynet.interactions.Wait;
import skynet.interfaces.IWebPage;
import skynet.utils.AHCustomAsserts;

import repos.InventoryPageRepo;


public class InventoryPage extends BasePage implements IWebPage {

    public InventoryPage() throws Exception {
        super(InventoryPageRepo.class);
    }

    public String getHeading() {
        return Elements.getText(InventoryPageRepo.PageTitle);
    }

    public void validatePageTitle() throws Exception {
        AHCustomAsserts.VerifyEqual(getHeading(), "PRODUCTS", "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    public void failValidatePageTitle() throws Exception {
        AHCustomAsserts.VerifyEqual(getHeading(), "PRODUCT", "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    @Override
    public void waitForLoad(int pageLoadTimeout) throws Exception {
        Wait.waitForExists(InventoryPageRepo.PageTitle, 10, true);
    }

    public void waitForIncorrectLoad(int pageLoadTimeout) throws Exception {
        Wait.waitForExists(InventoryPageRepo.IncorrectPageTitle, 10, true);
    }
}
