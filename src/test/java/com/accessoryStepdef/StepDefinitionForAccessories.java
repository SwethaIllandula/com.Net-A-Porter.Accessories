package com.accessoryStepdef;

import Pageelements.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class StepDefinitionForAccessories  {

    HomePage homePage = new HomePage();
    ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();
    ShippingDetailsPage shippingDetailsPage = new ShippingDetailsPage();
    SignInGuestCheckout signInGuestCheckout = new SignInGuestCheckout();
    AccessoryPage accessoryPage = new AccessoryPage();



    @Given("^User On HomePage$")
    public void user_On_HomePage() throws Throwable {
       String Actual = homePage.getCurrentURL();
       assertThat(Actual,is(endsWith("/gb/en/"))); }

    @When("^User move-Over Accessories Department And selects All- Accessories$")
    public void user_move_Over_Accessories_Department_And_selects_All_Accessories() throws Throwable {
        homePage.allAccessories(); }

    @Then("^User should be able to see the products of  Accessories$")
    public void user_should_be_able_to_see_the_products_of_Accessories() throws Throwable {
        String Title= productDescriptionPage.pageTitle();
        System.out.println( "TitleOfThePage is  "  +  Title);
        String Actual = productDescriptionPage.getCurrentURL();
        assertThat(Actual,is(endsWith("-allaccessories"))); }



    @When("^User Selects The Product$")
    public void user_Selects_The_Product() throws Throwable {
        homePage.moveToHairAccessories();
        productDescriptionPage.selectRandomProduct(); }

    @Then("^User Should be able to add the selected product to Basket$")
    public void user_Should_be_able_to_add_the_selected_product_to_Basket() throws Throwable {
        String actual = productDescriptionPage.getProductTitle();
        System.out.println(actual);
        productDescriptionPage.addProductToBag();
        String Expected= shoppingBagPage.productTitle();
        assertEquals(actual,Expected); }




    @Given("^User On Guest CheckOut Page$")
    public void user_On_Guest_CheckOut_Page() throws Throwable {
        homePage.moveToHairAccessories();
        productDescriptionPage.selectRandomProduct();
        productDescriptionPage.addProductToBag();
        shoppingBagPage.proceedToPurchase();
       String Actual = signInGuestCheckout.getCurrentURL();
       assertThat(Actual,is(endsWith("/signinpurchasepath.nap"))); }

     @When("^User ChecksOut As A Guest$")
    public void user_ChecksOut_As_A_Guest() throws Throwable {
        signInGuestCheckout.guestCheckOut(); }

    @Then("^User should be able to Fill the Shipping Details$")
    public void user_should_be_able_to_Fill_the_Shipping_Details() throws Throwable {
         String actual = shippingDetailsPage.titleOfThePage();
         assertThat(actual,containsString("SHIPPING ADDRESS"));
    }



    @Given("^User On ShippingPage$")
    public void user_On_ShippingPage() throws Throwable {
        homePage.moveToHairAccessories();
        productDescriptionPage.selectRandomProduct();
        productDescriptionPage.addProductToBag();
        shoppingBagPage.proceedToPurchase();
        signInGuestCheckout.guestCheckOut();
        shippingDetailsPage.titleOfThePage();
        String actual = shippingDetailsPage.titleOfThePage();
        assertThat(actual,containsString("SHIPPING ADDRESS")); }

    @When("^User fills Mandatory Shipping Details in the \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\"$")
    public void user_fills_Mandatory_Shipping_Details_in_the_form(String Firstname, String Lastname, String Address1, String TownCity, String Postcode, String Telephone) throws Throwable {
    shippingDetailsPage.fillShippingForm(Firstname, Lastname, Address1, TownCity, Postcode,Telephone);
    shippingDetailsPage.checkoutForPurchase(); }

    @Then("^User should be able to proceed to Payments Page$")
    public void user_should_be_able_to_proceed_to_Payments_Page() throws Throwable {
    shippingDetailsPage.confirmPurchase();
    String actual = shippingDetailsPage.getShippingInfo();
    String exp = shippingDetailsPage.finalInfo();
    assertEquals(actual,exp); }




    @Given("^User On Accessories Page$")
    public void user_On_Accessories_Page() throws Throwable {
    homePage.allAccessories();
    String actual= accessoryPage.getCurrentURL();
    assertThat(actual,containsString("allaccessories")); }

    @When("^User Filters Categories$")
    public void user_Accessories_Using_filters() throws Throwable {
    accessoryPage.accessoriesCategory(); }

    @Then("^User should be able to see the filtered products$")
    public void user_should_be_able_to_see_the_filtered_products() throws Throwable {
    String Actual = accessoryPage.getCurrentURL();
    String filterProducts = accessoryPage.HeaderOfTheCategory().toLowerCase();
    assertThat(Actual,is(endsWith(filterProducts))); }




    @When("^User filters Types Of Categories$")
    public void user_filters_Types_Of_Categories() throws Throwable {
    accessoryPage.accessoriesCategory();
    accessoryPage.TypesOfCategory(); }

    @Then("^User should be able to see Only the Filtered Types Of Categories$")
    public void user_should_be_able_to_see_Only_the_Filtered_Types_Of_Categories() throws Throwable {
    String actual = accessoryPage.getCurrentURL();
    String TypesOFCategoryProducts = accessoryPage.HeaderOfTheCategory().toLowerCase();
    assertThat(actual,is(endsWith(TypesOFCategoryProducts)));

    }



    @When("^User Filters For Colours$")
    public void user_Filters_For_Colours() throws Throwable {
    accessoryPage.chooseProductColour();
    }

    @Then("^User should be able to see all the products with chosen colour$")
    public void user_should_be_able_to_see_all_the_products_with_chosen_colour() throws Throwable {
    String Actual = accessoryPage.getCurrentURL();
    assertThat(Actual,containsString("colour"));
    }



    @When("^User Filters for Brands$")
    public void user_Filters_for_Brands() throws Throwable {
    accessoryPage.chooseProductBrand(); }

    @Then("^User Should be able to see the products of chosen Brand$")
    public void user_Should_be_able_to_see_the_products_of_chosen_Brand() throws Throwable {
    String Actual = accessoryPage.getCurrentURL();
    assertThat(Actual,containsString("brand"));

    }

    @When("^User Search for Brands using SearchBar \"([^\"]*)\"$")
    public void user_Search_for_Brands_using_SearchBar(String DesignerName) throws Throwable {
    accessoryPage.designerSearch(DesignerName);

    }

    @Then("^User should be able to search the brands in Search-field$")
    public void user_should_be_able_to_search_the_brands_in_Search_field() throws Throwable {
    String actual = accessoryPage.brandNameBySearch();
    String expected = accessoryPage.BrandText();
    System.out.println(expected);
    assertThat(actual,is(equalToIgnoringCase(expected)));

    }





}
