package com.springboot.selenium.page.google;

import com.springboot.selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;
@Component
public class SearchComponent extends Base {
    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButton;

    public void search(final String keyWord){
        this.searchBox.sendKeys(keyWord);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchButton
                .stream()
                .filter(e-> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement :: click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((driver -> this.searchBox.isDisplayed()));
    }
}
