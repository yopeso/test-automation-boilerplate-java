package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import actions.InventoryPage;

import utils.User;

public class InventoryActions extends UIInteractionSteps {
    InventoryPage inventoryPage;

    @Step("Validate Page Title is correct")
    public void as (User user) throws Exception {
        inventoryPage.waitForLoad(10);
        inventoryPage.validatePageTitle();
    }
}
