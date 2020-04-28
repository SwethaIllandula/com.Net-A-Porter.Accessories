  Feature: Accessories


  Scenario: To check Functionality of Hair Accessories
  Given User On HomePage
  When User move-Over Accessories Department And selects All- Accessories
  Then User should be able to see the products of  Accessories


  @Search
  Scenario: To Check the Functionality of Search
  Given User On Home Page
  When  User search for product
  Then  User should be able to see relevant products




  @Regression
  Scenario: Add To Basket
  When User Selects The Product
  Then User Should be able to add the selected product to Basket


  @Guest
  Scenario: CheckOut As A Guest
  Given User On Guest CheckOut Page
  When User ChecksOut As A Guest
  Then User should be able to Fill the Shipping Details


  @Shipping
  Scenario Outline: To check the functionality of ShippingPage
  Given User On ShippingPage
  When  User fills Mandatory Shipping Details in the "<Firstname>"  "<Lastname>"  "<Address1>"  "<TownCity>"  "<Postcode>"  "<Telephone>"
  Then  User should be able to proceed to Payments Page
  Examples:

   | Firstname | Lastname | Address1 | TownCity | Postcode | Telephone |
   | Jaanu      | SriRam    |   23   |  ilford  | ig6 1af  |02085545595|
   #|            | SriRam    |   23   |  ilford  | 1234567 |02085545595|


   @Filters
   Scenario:To Check The Functionality of Category Using Filters
   Given User On Accessories Page
   When  User Filters Categories
   Then  User should be able to see the filtered products

   @TypeOfCategories
   Scenario: To check The Functionality Of Types Of Categories
   Given User On Accessories Page
   When  User filters Types Of Categories
   Then  User should be able to see Only the Filtered Types Of Categories

   @Colour
   Scenario: To Check The Functionality Of Colours Using Filters
   Given User On Accessories Page
   When  User Filters For Colours
   Then  User should be able to see all the products with chosen colour

   @Brand
   Scenario: To Check The Functionality Of Brands Using Filters
   Given User On Accessories Page
   When  User Filters for Brands
   Then  User Should be able to see the products of chosen Brand

   @DesignerSearch
   Scenario Outline: To check the Functionality of DesignerSearchField
   Given  User On Accessories Page
   When   User Search for Brands using SearchBar "<DesignerName>"
   Then   User should be able to search the brands in Search-field
   Examples:

     | DesignerName |
     | Alexander McQUEEN |
     | Gucci             |
     |xxxxxxx            |
