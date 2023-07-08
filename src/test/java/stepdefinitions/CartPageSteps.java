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
    public void the_user_opens_the_Cart() {
        cartPage.open();
    }

    @When("the user updates the quantity to {int} in Cart")
    public void the_user_updates_the_quantity_to_int_in_Cart(int quantity) {
        CartEntryInfo previousCartEntryInfo = World.getCartEntryInfo();
        double originalAmountPerItem = previousCartEntryInfo.getAmount() / previousCartEntryInfo.getQuantity();
        cartPage.updateQuantity(quantity);
        World.saveCartEntryInfo(new CartEntryInfo(quantity, originalAmountPerItem * quantity));
    }

    @Then("the subtotal price in Cart should be correct")
    public void the_subtotal_price_in_Cart_should_be_correct() {
        CartEntryInfo actualCartEntryInfo = cartPage.getCartEntryInfoForFirstProduct();
        assertEquals(World.getCartEntryInfo().getAmount(), actualCartEntryInfo.getAmount());
    }

    @Then("the quantity in Cart should be correct")
    public void the_quantity_in_Cart_should_be_correct() {
        CartEntryInfo actualCartEntryInfo = cartPage.getCartEntryInfoForFirstProduct();
        assertEquals(World.getCartEntryInfo().getQuantity(), actualCartEntryInfo.getQuantity());
    }
}
