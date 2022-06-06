package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import skynet.Statics;
import skynet.interactions.Elements;
import skynet.interactions.Wait;
import skynet.interfaces.IWebPage;
import skynet.utils.AHCustomAsserts;

import repos.InventoryPageRepo;


public class InventoryPage extends PageObject implements IWebPage {

    public InventoryPage () throws Exception {

    }

    public String getHeading () {
        return Elements.getText(InventoryPageRepo.RepositoryEnum.PageTitle.name());
    }

    public void validatePageTitle () throws Exception {
        AHCustomAsserts.VerifyEqual(getHeading(), "PRODUCTS", "The inventory page should be displayed with the correct title", "Landed on incorrect page", true);
    }

    @Override
    public void waitForLoad (int pageLoadTimeout) throws Exception {
        Statics.setRepoName(InventoryPageRepo.class.getName());
        Wait.waitForExists(InventoryPageRepo.RepositoryEnum.PageTitle.name(), 10, true);
    }
}
