package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class A02LoginUserwithcorrectemailandpassword extends TestBase {
    public static void main(String[] args) {
      // 1. Tarayıcıyı başlatın
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      // 2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
      // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
   String actualURL   = driver.getCurrentUrl();
   String expectedURL="https://automationexercise.com/";
        Assert.assertEquals(actualURL,expectedURL);
        // 4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//li[4]")).click();
      // 5. 'Hesabınıza giriş yapın' seçeneğinin görünür olduğunu doğrulayın
       WebElement loginText =driver.findElement(By.xpath("(//h2)[1]"));
       Assert.assertTrue(loginText.isDisplayed());
      // 6. Doğru e-posta adresini ve şifreyi girin
       driver.findElement(By.xpath("//input[@data-qa='login-email']"))
               .sendKeys("deneme@gmail.com", Keys.TAB,"12345");
      // 7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
      // 8. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement userNameVerify=driver.findElement(By.xpath("//b[text()='testEmre']"));
        Assert.assertTrue(userNameVerify.isDisplayed());
      // 9. 'Hesabı Sil' düğmesine tıklayın
        driver.findElement(By.xpath("//a[text()=' Delete Account']"));
      // 10. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. görünür
        WebElement deleteInfoMessage=driver.findElement(By.xpath("//b"));

        Assert.assertTrue(deleteInfoMessage.isDisplayed());
    }
}
