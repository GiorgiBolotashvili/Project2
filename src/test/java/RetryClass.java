import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 3;
    public static int counter;

    @Override
    public boolean retry(ITestResult result) {
        System.out.println("Retry Class");
        if (!result.isSuccess()) {
            //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                result.setStatus(ITestResult.FAILURE);      //Mark test as failed

                return true;                                 //Tells TestNG to re-run the test
            }
            else {
                result.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        }
        else {
            result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }

        return false;
    }
}
