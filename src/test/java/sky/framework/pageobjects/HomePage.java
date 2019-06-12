package sky.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sky.framework.helpers.PageObjectUtility;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObjectUtility {

    private final By SKY_LOGO = By.cssSelector("body > div.sdc-site-header.sdc-site-header--news > div > div.sdc-site-header__top > a > img");

    private final By HOMEPAGE_CATEGORIES = By.cssSelector("#nav-wrap > nav > div.sdc-site-header__nav-cell.sdc-site-header__nav-cell--1 > div > ul > li > a");

    private final By CATEGORY_NEW_TITLE = By.cssSelector("body > div:nth-child(6) > div > div > div.sdc-site-tiles__item.sdc-site-tile.sdc-site-tile--has-link.sdc-site-tile--breaking--live > div > div > h3 > a > span");

    private final By COOKIES_BTN = By.xpath("/html/body/div[24]/div/div[1]/div/div/div[2]/div[2]/button[1]");


    public void goToSkyNewsHomepage() throws Throwable {
        startHomepage();
        clickAcceptCookies();
    }

    private void clickAcceptCookies(){
        driver.switchTo().activeElement();
        clickElementUsingJavascriptExecutor(driver.findElement(COOKIES_BTN));
        //driver.switchTo().alert().accept();
//        driver.switchTo().activeElement().click();
    }

    public boolean isSkyBannerLogoDisplayed(){
        return visibilityOf(driver.findElement(SKY_LOGO)).isDisplayed();
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public int numberOfCategoriesDisplayed(){
        int number = 0;
        for(WebElement element : presenceOfAllElementsLocatedBy(HOMEPAGE_CATEGORIES)){
            if(element.isDisplayed()){
                number = number + 1;
            }
        }
        return number;
    }

    public List<String> listOfCategoriesDisplayed(){
        List<String> displayedCategories = new  ArrayList<String>();

        for(WebElement element : presenceOfAllElementsLocatedBy(HOMEPAGE_CATEGORIES)){
            if(element.isDisplayed()){
                displayedCategories.add(element.getText());
            }
        }
        return displayedCategories;
    }

    public void clickACategory(String category){
        findACategory(category).click();
    }

    public boolean isCategoryFocusedUpon(WebElement category){
        return visibilityOf(category).getAttribute("aria-current").equals("true");
    }

    public WebElement findACategory(String category){
        for(WebElement element : presenceOfAllElementsLocatedBy(HOMEPAGE_CATEGORIES)){
            if(element.getText().trim().equals(category)){
                return element;
            }
        }
        System.out.println(String.format("%s category not found OR is not visible", category));
        return null;
    }
}
