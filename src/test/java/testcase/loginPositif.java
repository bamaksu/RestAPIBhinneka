package testcase;

import browser.browserChrome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.homePage;
import page.loginPage;

public class loginPositif {

    @Test
    public static void main(String[]args) throws InterruptedException {
//        public static void main(String[] args) {
        WebDriver driver = browserChrome.getChromeDriver();

        driver.get("https://www.bhinneka.com/");

        homePage beranda = new homePage(driver);
        loginPage testMasuk = new loginPage(driver);


        testMasuk.clickBtnLogin();
        testMasuk.inputEmail("bambangakbarsudibyo@gmail.com");
        testMasuk.clickBtnLanjut();
        testMasuk.inputPassword("@Qwerty123");
        testMasuk.clickBtnMasuk();
        System.out.println("Sukses ke link " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login");

        driver.close();
        driver.quit();
    }
}
