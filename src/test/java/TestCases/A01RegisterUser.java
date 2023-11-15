package TestCases;//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A01RegisterUser {
    /*

 1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' URL'sine gidin
3. Ana sayfanın başarıyla göründüğünü doğrulayın
4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
5. 'Yeni Kullanıcı Kaydı!' seçeneğini doğrulayın görünür
6. Adı ve e-posta adresini girin
7. 'Kayıt Ol' butonuna tıklayın
8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin göründüğünü doğrulayın
9. Ayrıntıları girin: Unvan, İsim, E-posta, Şifre, Doğum Tarihi
10. 'Bültenimize kaydolun!' onay kutusunu seçin.
11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
12. Ayrıntıları doldurun: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
13. 'Hesap Oluştur düğmesi'ne tıklayın
14. 'HESAP OLUŞTURULDU!' ifadesini doğrulayın. görünür
15. 'Devam' düğmesine tıklayın
16. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
17. 'Hesabı Sil' butonuna tıklayın
18. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. görünür ve 'Devam' düğmesine tıklayın
     */
    public static void main(String[] args) throws InterruptedException {
        // 1. Tarayıcıyı başlatın

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
       // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
        System.out.println(driver.getCurrentUrl().equals("https://automationexercise.com/") ? "TEST PASSED" : "TEST FAILED");

        // 4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//li[4]")).click();
       // 5. 'Yeni Kullanıcı Kaydı!' seçeneğini doğrulayın görünür
       WebElement kullaniciKaydi =driver.findElement(By.xpath("//*[.='New User Signup!']"));

        String    kkExpectedResult    =kullaniciKaydi.getText();
        String    kkActualResult="New User Signup!";

        System.out.println(kkExpectedResult.equals(kkActualResult) ? "TEST PASSED" : "TEST FAILED");
        // 6. Adı ve e-posta adresini girin
      WebElement adi = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement ePosta = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        adi.sendKeys("eyoel", Keys.TAB);
        ePosta.sendKeys("renley.narayan@forkshape.com");
       // 7. 'Kayıt Ol' butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
       // 8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin göründüğünü doğrulayın
       WebElement hesapBilgileriniGirinBasligi =driver.findElement(By.xpath("(//b)[1]"));
        String HBGBExpetedResult=  hesapBilgileriniGirinBasligi.getText();
        String HBGBActualResult="ENTER ACCOUNT INFORMATION";
        System.out.println(HBGBActualResult.equals(HBGBActualResult) ? "TEST PASSED" : "TEST FAILED");
        // 9. Ayrıntıları girin: Unvan, İsim, E-posta, Şifre, Doğum Tarihi
        driver.findElement(By.id("uniform-id_gender1")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("3",Keys.TAB,"May",Keys.TAB,"1997");
       // 10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@name='newsletter']"));
       // 11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//*[@name='optin']"));
       // 12. Ayrıntıları doldurun: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("eyoel",Keys.TAB,"abrahan",Keys.TAB,"ADL",
                Keys.TAB,"Str",Keys.TAB,"Str",Keys.TAB,"Canada",Keys.TAB,"Alberta",Keys.TAB,"Edmonton",Keys.TAB,"654578",Keys.TAB,"54784567");
       // 13. 'Hesap Oluştur düğmesi'ne tıklayın
        driver.findElement(By.xpath("//*[.='Create Account']")).click();
       // 14. 'HESAP OLUŞTURULDU!' ifadesini doğrulayın. görünür
      String hoActualResult =driver.findElement(By.xpath("(//h2)[1]")).getText();
        String hoExpectedResult="ACCOUNT CREATED!";
        System.out.println(hoActualResult.equals(hoExpectedResult) ? "TEST PASSED" : "TEST FAILED");
        // 15. 'Devam' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='Continue']")).click();


       // 16. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
       WebElement kullaniciOturumAcildi =driver.findElement(By.tagName("b"));
       String oturumAcildiExpected =kullaniciOturumAcildi.getText();
        String oturumAcildiActual="ACCOUNT CREATED!";
        System.out.println(oturumAcildiActual.equals(oturumAcildiExpected) ? "TEST PASSED" : "TEST FAILED");

        // 17. 'Hesabı Sil' butonuna tıklayın
        driver.findElement(By.xpath("//*[contains(text(),'Delete Account')]")).click();
       // 18. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. görünür ve 'Devam' düğmesine tıklayın
        String hesapSilindiActual  =driver.findElement(By.tagName("b")).getText();
        System.out.println(hesapSilindiActual);
        String hesapSilindiExpected="ACCOUNT DELETED!";
        System.out.println(hesapSilindiActual.equals(hesapSilindiExpected) ? "TEST PASSED" : "TEST FAILED");
        Thread.sleep(2000);
      // driver.close();
    }
}
