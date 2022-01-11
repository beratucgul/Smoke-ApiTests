import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;
import static org.testng.Assert.*;

public class SmokeTest extends BaseTest {


    @Test
    public void goToTrendyolHomepage() {
        WebElement modalCloseButton = driver.findElement(By.cssSelector(".modal-close"));
        Boolean modalVisibility = modalCloseButton.isDisplayed();
        assertFalse(modalVisibility);


        //CSS Selector
        // class için başına . koyuyoruz
        // birden fazla class varsa bitişik olarak ve . koyarak yazıyoruz  ()
        // hiyerarşik olarak sıralamak istersek (.container-right-content .pr-in-w .pr-in-cn) arada boşluk olacak. 1. class'ın 1 altındaki 2. class'ın 1 atlındaki 3. class
        // > işareti bir alt a iniyor.

        // XPath
        // Assertion
        // Modal'ın görünür olup olmadığını kontrol ediyoruz
    }

    @Test
    public void searchAKeyword() {
        WebElement searchBoxTextBox = driver.findElement(By.cssSelector(".search-box"));
        searchBoxTextBox.sendKeys("kitap" + ENTER);

        WebElement productCard = driver.findElement(By.cssSelector(".prdct-cntnr-wrppr"));
        assertTrue(productCard.isDisplayed());

        WebElement searchResultTextElement = driver.findElement(By.cssSelector(".dscrptn  h1"));
        String searchResultText = searchResultTextElement.getText();
        assertEquals(searchResultText, "kitap");
    }

    @Test
    public void searchAKeywordWithButton() {
        String keyword = "kitap";
        Homepage homepage = new Homepage(driver);
        SearchResultPage searchResultPage = homepage.search(keyword + ENTER);

        assertTrue(searchResultPage.isProductCardsDisplayed());

        String resultText = searchResultPage.getResultText();
        assertEquals(resultText, keyword);
    }

    @Test
    public void shouldLogin() {
        Homepage homepage = new Homepage(driver);
        LoginPage loginPage = homepage.goToLoginPage();
        homepage = loginPage.login();

        String accountText = homepage.getAccountText();
        assertEquals(accountText, "Hesabım");
    }

}
