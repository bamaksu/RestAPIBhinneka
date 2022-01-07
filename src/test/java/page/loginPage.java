package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    private static WebDriver driver;

    private By btnLogin = By.xpath("//span[contains(text(),'Login')]");
    private By email = By.id("email");
    private By btnLanjut = By.id("next");
    private By password = By.id("password");
    private By btnMasuk = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]");

    public loginPage (WebDriver driver){this.driver = driver;}

    public WebElement login(){
        return driver.findElement(btnLogin);
    }
    public loginPage clickBtnLogin(){
        login().click();
        return this;
    }

    public loginPage inputEmail (String emailKamu) {
        WebElement emailElem = driver.findElement(email);
        emailElem.sendKeys(emailKamu);
        return this;
    }

    public WebElement lanjut(){
        return driver.findElement(btnLanjut);
    }
    public loginPage clickBtnLanjut(){
        lanjut().click();
        return this;
    }

    public loginPage inputPassword (String passwordKamu) {
        WebElement passwordElem = driver.findElement(password);
        passwordElem.sendKeys(passwordKamu);
        return this;
    }

    public WebElement masuk(){
        return driver.findElement(btnMasuk);
    }
    public loginPage clickBtnMasuk() {
        masuk().click();
        return this;
    }



}
