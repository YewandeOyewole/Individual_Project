import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.annotation.Priority;

public class KongaTest {
    private By ClickCard = By.xpath("//*[@id=\\\\\\\"channel-template\\\\\\\"]/div[2]/div/div[2]/button/div/span[1]");
    private By CardNumber = By.id("card-number");
    private By Date = By.id("expiry");
    private By CVV = By.id("cvv");
    private By Submit = By.id("ValiddateCardForm");
    private By Close = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");

    //import selenium Webdriver

    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException{
        //locate the
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        //1. open edge browser
        driver = new EdgeDriver();
        //2. Input the konga page url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        // verify that the user input the right url and is on the right webpage
        if (driver.getCurrentUrl() .contains("https://www.konga.com/"))
            //pass
            System.out.println("current webpage");
        else
            //fail
             System.out.println("wrong webpage");
        Thread.sleep(5000);
        //3. maximize the driver
        driver.manage().window().maximize();
        //4. click on login button to open login page
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 0)
    public void Invalidusernamelogin () throws InterruptedException {
        // test1 .verify that the user cannot log in with an invalid username
        //5. Input invalid email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("wan01@mailnator.com");
        //6. input valid password in the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin25");
        //7. click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //8. verify error message (the username or password you have entered is incorrect. please try again)is displayed
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[1]/div")).isDisplayed();
        Thread.sleep(5000);

     }
     @Test (priority = 1)
    public void LessThan6CharactersPasswordLogin () throws InterruptedException {
          //Test2. verify that user cannot log in with less than 6 characters password
         //9. clear the email field
         driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
         //10. input a valid email in the email field
         driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("wande25@mailnator.com");
         //11. clear password field
         driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
         //12. input less than 6 character password
         driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
         //13. click on the login button
         driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
         //14. Verify  the error message (The password must be at least 6 characters) is displayed
         driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[2]/div")).isDisplayed();
         Thread.sleep(5000);

      }
    @Test (priority = 2)
    public void BlankRequiredFieldLogin () throws  InterruptedException {
        //Test3 verify user cannot log in with blank required field
        // clear the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        //15. clear the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        //16. click on login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 3)
    public void BlankEmailFieldLogin () throws InterruptedException{
        //Test4. verify user cannot log in with a blank email field
        // clear the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        //17. input valid password in the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin25");
        //18. click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 4)
    public void positiveLogin() throws  InterruptedException{
        //Test5. verify user can log in with a valid login details
        // clear the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
        //19. clear the password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
        Thread.sleep(5000);
        //20. input valid email in the email field
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("wande25@mailnator.com");
        //21. input valid password in password field
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin25");
        //22. click on the login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);

    }
    @Test (priority = 5)
    public void ClickOnComputerAndAccessories () throws InterruptedException{
        //Test6. verify user can navigate and click on computer and accessories
        //23. click on computer and accessories
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(30000);

    }
    @Test (priority = 6)
    public void ClickOnLaptop () throws InterruptedException{
        //Test7. verify user can navigate and click on laptop
        //24. click on laptop on the item list
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(20000);

    }
    @Test (priority = 7)
    public void ClickOnAppleMacbook () throws InterruptedException{
        //Test8 verify user can navigate and click on Applemacbook
        //25. click on Apple macbooks
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(15000);

    }
    @Test (priority = 8)
    public void AddItemTOCart () throws InterruptedException{
        //Test9 verify user can click on add to cart
        //26. click on item
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[13]/div/div/div[2]/a/div[1]/h3")).click();
        Thread.sleep(10000);
        //27. Click on buy now to add to cart
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div[4]/div[3]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(5000);
        //28. click on continue to checkout
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[4]/div/div[6]/div/a")).click();

    }
    @Test (priority = 9)
    public void PaymentOption () throws InterruptedException{
        //Test10. verify user can click on the payment option
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        //29. click on pay now to select payment option
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        //30. click on continue to make payment
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 10)
    public void SelectPaymentMethood () throws InterruptedException{
        // click on the card option on the selected payment method
        click(ClickCard);
    }
    private void click(By clickCard){

    }
    @Test (priority = 11)
    public void InsertCardDetails () throws InterruptedException{
        // insert invalid card number in card field
        setText(CardNumber, 123456);
        //insert an invalid expiry date in the date field
        setText(Date,1/25);
        //insert an invalid cvv
        setText(CVV, 321);

    }
    public void setText(By cardNumber, int i){

    }
    @Test (priority = 12)
    public void PayNow () throws InterruptedException{
        // click on the pay now button
        click(Submit);
        Thread.sleep(5000);
        // close the iFrame
        click(Close);
        Thread.sleep(5000);
        // verify that user  is unable to complete order with invalid card details
        String actualErrorMessage = "invalid card number";
        if (actualErrorMessage.contains("invalid card number"))
            // pass
            System.out.println("invalid card number");
        else
            //fail
            System.out.println("valid card number");

    }
    @AfterTest
    public void CloseBrowser () {
        // quit the browser
        driver.quit();

    }

}
