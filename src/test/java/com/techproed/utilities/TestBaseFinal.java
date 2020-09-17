package com.techproed.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBaseFinal {

    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;

 // Bunlar sabittir. aventstack den geliyor. bu kütüphaneyi pom.xml yapıştırdık.
  // Rapor almak için her seferinden bu 3 nesneyi oluşturmak zorundayız.

    @BeforeTest(alwaysRun = true)  // alwaysRun : her zaman çalıştır. eklemese de olur
    // BeforeTest test işlemine başlmadan hemen önce, (tüm test işleminden önce, methodan önce değil )

    public void setUpTest() {

        extentReports = new ExtentReports();// Object oluşturduk.
        String filePath = System.getProperty("user.dir") + "/test-output/benimraporum.html";//create a custom report in the current project.
        // Rapor oluşturduktan sonra, Rapor nereye kaydeetsin. dosya yolu ile belirledik. Kayd edecek yeri.

        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        // Oluşturmak istediğniz raporun HTMl formatında başlatıyoruz. filePath ile dosya yolunu belirliyoruz.

        extentReports.attachReporter(extentHtmlReporter);



        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser")); // Hangi sürücu kullandınız
        extentReports.setSystemInfo("Automation Engineer", "Fethi"); // kim hazırladı
        extentHtmlReporter.config().setDocumentTitle("Google Arama");
        extentHtmlReporter.config().setReportName("Google arama raporları");  // Rapor ismi
        // istediğimiz bilgileri buraya ekleyebiliriz.


    }

    @AfterMethod(alwaysRun = true)
//her test methodundan sonra eğer teste hatta varsa, ekran görüntüsü alıp rapora ekler
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Eğer testin sonucu başarsız ise, ekran görüntüsü alıp rapora ekliyor
            String screenshotLocation = ReusableMethods_EkranResmiAlma.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);//adding the screenshot to the report
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // Test çalşmadadan atlamışsa, geçmişse
            extentTest.skip("Test Case is skipped: " + result.getName());
        }
        Driver.closeDriver();
    }

    @AfterTest(alwaysRun = true)
    // raporlandırmayı sonlandırıyo.
    public void tearDownTest() {
        extentReports.flush();
    }
}

