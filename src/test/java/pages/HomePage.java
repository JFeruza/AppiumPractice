package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.MobileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    @AndroidFindBy(id="com.etsy.android:id/search_src_text")
    private MobileElement searchInput;

    @AndroidFindBy(accessibility="Show Navigation Drawer")
    private MobileElement searchIcon;

    @AndroidFindBy(id="com.etsy.android:id/listing_title")
    private List<MobileElement> searchResults;

    @AndroidFindBy(id="com.etsy.android:id/query_text")
    private List<MobileElement> prepopulatedSearchResults;



    public HomePage(){
       PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
   }


   public void searchFor(String text){
       MobileUtils.waitFor(3000);
       MobileUtils.clickWithWait(searchIcon);

       MobileUtils.waitFor(3000);
       Actions actions=new Actions(Driver.getDriver());
       actions.click(searchInput).pause(2000).sendKeys(text).perform();


       MobileUtils.waitFor(3000);
       prepopulatedSearchResults.get(0).click();

       MobileUtils.waitFor(3000);

   }


    /**
     * This method returns collection of search result titles
     * @return collections of search result titles
     */
   public List<String> getSearchResultTexts(){
        MobileUtils.waitFor(3000);

        /*
        List<String> allResultTexts=new ArrayList<>();

        for(MobileElement eachElement: searchResults){
           allResultTexts.add( eachElement.getText() );
        }

         */

        // :: -method reference  ClassName :: method
        // :: works when method return type is void
        //.map(MobileElement::getText) <<apply getText method from MobileElement class to every element of the collection
       //.collect(Collectors.toList());  create a new collection for elements
        return searchResults.stream()
                .map(MobileElement::getText)
                .collect(Collectors.toList());


   }


}
