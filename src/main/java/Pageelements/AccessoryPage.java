package Pageelements;

import UtilitiesForElements.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverbase.DriverManager;

import java.util.List;

import static junit.framework.TestCase.fail;

public class AccessoryPage extends DriverManager {


    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[3]")
    private WebElement filterColoursUsingCategories;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[2]")
    private WebElement filterOnlyColours;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[4]")
    private WebElement filterBrands;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[3]")
    private WebElement filterOnlyBrands;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[1]")
    private WebElement filterCategories;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[2]")
    private WebElement filterTypesOfAccessories;

    @FindBy(xpath = "(//label[@class='AccordionSection2__heading openLabel'])[4]")
    private WebElement filterOnlySizes;

    @FindBy(css=" ul.SchemaFilterGroup43__filtersWrapper li a")
    private List<WebElement> sizes;

    @FindBy(css= ".Swatch6.Filter43__swatch")
    private List<WebElement> colours;

    @FindBy(css = ".DesignerFilterGroup43__list div a")
    private List<WebElement> brands;

    @FindBy(css="a[href ^='/en-gb/shop/accessories/sunglasses/']")
    private List<WebElement> typesOfSunglasses;

    @FindBy(css = ".Filter43__filterLineLabel")
    private List<WebElement> all;

    @FindBy(linkText = "Sunglasses")
    private WebElement sunGlasses;

    @FindBy(css = ".Header5__subtitle")
    private WebElement headerOfTheCategory;

    @FindBy(xpath = "(//div[contains(text(),'All')])[2]")
    private WebElement allColours;

    @FindBy(id="designerFilter")
    private WebElement DesignerSearchField;

    @FindBy(css="div.DesignerFilterGroup43__list")
    //(css="a> span.checkBox")
    private WebElement checkBox;

    @FindBy(css = ".FilterTags43__tag")
    private WebElement brandSearchName;

    @FindBy(xpath = "(//div[@class='SelectedFilterLabel43__subTitle SelectedFilterLabel43__subTitle--new'])[3]")
    private WebElement brandText;




    public String HeaderOfTheCategory(){
      return  headerOfTheCategory.getText();
    }

    public String brandNameBySearch(){
    return brandSearchName.getText();
    }

    public String BrandText(){
    return brandText.getText();
    }


    public void chooseSize(){
    filterOnlySizes.click();
    int SizesAvailable = sizes.size();
    System.out.println(SizesAvailable);
    if(SizesAvailable==0){
    fail("No Sizes Available on the Product");
    }
   int chooseSize = GenericMethods.randomNumberHelper(SizesAvailable);
    WebElement chooseRandomSize= sizes.get(chooseSize);
        System.out.println(chooseRandomSize.getText());
    chooseRandomSize.click();

    }



    public void chooseProductColour(){

        filterOnlyColours.click();
        int ColoursAvailable= colours.size();
        System.out.println(" Number of Colours Available " +ColoursAvailable);
        if(ColoursAvailable==0){
        fail("No Colours to choose"); }
        int coloursToChoose= GenericMethods.randomNumberHelper(ColoursAvailable);
        WebElement chooseColour =colours.get(coloursToChoose);
        String colourChose= chooseColour.getText();
        System.out.println("Chosen Colour is  " + colourChose);
        chooseColour.click();
        GenericMethods.refreshPage(driver);
    }

    public void chooseAllColours(){
        filterOnlyColours.click();
        allColours.click();
        allColours.getText();
    }


    public void chooseProductBrand(){
        filterOnlyBrands.click();
        int selectBrand = brands.size();
        System.out.println(" Brands Available are :" +selectBrand);
        if(selectBrand==0){
        fail("No Brands Available "); }
        int randomBrands = GenericMethods.randomNumberHelper(selectBrand);
        WebElement chooseAnyBrand = brands.get(randomBrands);
        System.out.println("Chosen Brand is "+chooseAnyBrand.getText());
        chooseAnyBrand.click();
        GenericMethods.refreshPage(driver);

    }


    public void designerSearch(String DesignerName){
        filterOnlyBrands.click();
        DesignerSearchField.click();
        DesignerSearchField.sendKeys(DesignerName);
        checkBox.click();
        GenericMethods.refreshPage(driver);

    }


    public void accessoriesCategory(){
        filterCategories.click();
        sunGlasses.click();
        GenericMethods.refreshPage(driver);}


     public void TypesOfCategory(){
     filterTypesOfAccessories.click();
     int sunGlassTypes = typesOfSunglasses.size();
     System.out.println("SunGlasses available are " + sunGlassTypes);
     if (sunGlassTypes == 0) {
                fail("No Sunglass Varieties to filter");
      }
     int selectSunGlasses = GenericMethods.randomNumberHelper(sunGlassTypes);
     WebElement chooseSunGlasses = typesOfSunglasses.get(selectSunGlasses);
     System.out.println("Chosen Accessory is " + chooseSunGlasses.getText());
     chooseSunGlasses.click();
     GenericMethods.refreshPage(driver);
        }


    public void chooseAll(){
    int allProducts = all.size();
    System.out.println(allProducts);
    if(allProducts==0){
    fail("Cannot Choose all products");
    }
    WebElement chooseall= all.get(allProducts);
    chooseall.click();
    }


    }


