package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculationResultPage;
import page.GoogleCloudHomePage;

public class HardCoreTest {

    WebDriver driver;

    private static final String TERM_FOR_SEARCHING = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCE = "4";
    private static final String OPERATION_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private static final String VM_CLASS = "Regular";
    private static final String SERIES = "N1";
    private static final String MACHINE_TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String NUMBER_OF_GPU = "1";
    private static final String GPUS_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATA_CENTER_LOCATION = "Oregon (us-west1)";
    private static final String COMMITMENT_PERIOD = "1 Year";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void resultValuesAreSimilarToTotalCostInMail() {

        CalculationResultPage calculationOfCost = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(TERM_FOR_SEARCHING)
                .chooseTheResultWeNeed()
                .activateComputeEngineChapter()
                .inputNumberOfInstance(NUMBER_OF_INSTANCE)
                .selectOperationSystem(OPERATION_SYSTEM)
                .selectVMClass(VM_CLASS)
                .selectSeriesAndMachineType(SERIES, MACHINE_TYPE)
                .addGPUAndSetParameters(NUMBER_OF_GPU, GPUS_TYPE)
                .setLocalSSD(LOCAL_SSD)
                .setDataCenterLocation(DATA_CENTER_LOCATION)
                .setCommitmentPeriod(COMMITMENT_PERIOD)
                .pressButtonAddToEstimate();

        String totalCostFromPage = calculationOfCost.getTotalCost();

        String totalCostFromMail = calculationOfCost.pressEmailEstimateButton()
                .openNewTabAndSwitchToYopmail()
                .getNewRandomMailCopyAndTurnBackToCalculating()
                .fillEmailAndSendMail()
                .switchToPostBox()
                .openMail()
                .getTotalCostFromMail();

        Assert.assertEquals(totalCostFromMail, totalCostFromPage);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
