package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodels.CartPage;
import utils.CartEntryInfo;
import utils.World;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageSteps {
    private CartPage cartPage;

    public CartPageSteps() {
        this.cartPage = new CartPage();
    }

    @When("the user opens the Cart")
    public void theUserOpensTheCart() {
        cartPage.open();
    }

    @When("the user updates the quantity to {int} in Cart")
    public void theUserUpdatesTheQuantityToIntInCart (int quantity) {
        CartEntryInfo previousCartEntryInfo = World.getCartEntryInfo();
        double originalAmountPerItem = previousCartEntryInfo.getAmount() / previousCartEntryInfo.getQuantity();
        cartPage.updateQuantity(quantity);
        World.saveCartEntryInfo(new CartEntryInfo(quantity, originalAmountPerItem * quantity));
    }

    @Then("the subtotal price in Cart should be correct")
    public void theSubtotalPriceInCartShouldBeCorrect() {
        CartEntryInfo actualCartEntryInfo = cartPage.getCartEntryInfoForFirstProduct();
        assertEquals(World.getCartEntryInfo().getAmount(), actualCartEntryInfo.getAmount());
    }

    @Then("the quantity in Cart should be correct")
    public void theQuantityInCartShouldBeCorrect() {
        CartEntryInfo actualCartEntryInfo = cartPage.getCartEntryInfoForFirstProduct();
        assertEquals(World.getCartEntryInfo().getQuantity(), actualCartEntryInfo.getQuantity());
    }
}
