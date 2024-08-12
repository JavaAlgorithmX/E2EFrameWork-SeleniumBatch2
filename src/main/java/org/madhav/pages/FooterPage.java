package org.madhav.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage {

    @FindBy(xpath = "//div[contains(text(), 'social_twitter')]")
    WebElement twitterLink;

    @FindBy(xpath = "//div[contains(text(), 'social_facebook')]")
    WebElement fbLink;

    @FindBy(xpath = "//div[contains(text(), 'social_linkedin')]")
    WebElement linkedinLink;

public void clickTwitterLink()
{
    twitterLink.click();
}
    public void clickFacebookLink()
    {
        fbLink.click();
    }
    public void clickLinkedinLink()
    {
        linkedinLink.click();
    }
}

