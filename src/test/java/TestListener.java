import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener extends BaseClass implements ITestListener {

    private static String GetTestMethodName(ITestResult iTestResult){
        return  iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] SaveScreenshot(WebDriver driver) {
        System.out.println("CREATE SCREENSHOT !");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method " + GetTestMethodName(result)+" failed");

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).GetDriver();

        if(driver instanceof WebDriver){
            SaveScreenshot(driver);
        }
    }
}