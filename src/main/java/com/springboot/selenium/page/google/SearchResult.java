package com.springboot.selenium.page.google;

import com.springboot.selenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SearchResult extends Base {
    @FindBy(xpath = "//*[@id='rso']/div")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until((driver -> !this.results.isEmpty()));
    }
}
