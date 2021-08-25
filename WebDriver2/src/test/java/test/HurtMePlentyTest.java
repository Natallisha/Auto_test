package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculationResultPage;
import page.GoogleCloudHomePage;

public class HurtMePlentyTest {

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

    private static final String EXPECTED_VM_CLASS = "VM class: regular";
    private static final String EXPECTED_INSTANCE_TYPE = "Instance type: n1-standard-8";
    private static final String EXPECTED_REGION = "Region: Oregon";
    private static final String EXPECTED_LOCAL_SSD = "Total available local SSD space 2x375 GiB";
    private static final String EXPECTED_COMMITMENT_TERM = "Commitment term: 1 Year";
    private static final String EXPECTED_TOTAL_COST = "5,413.06";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void resultValuesAreSimilarToEntered() {

        CalculationResultPage calculationResultPage = new GoogleCloudHomePage(driver)
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

        Assert.assertEquals(calculationResultPage.getValueOfItem("VM class"), EXPECTED_VM_CLASS);
        Assert.assertEquals(calculationResultPage.getValueOfItem("Instance type"), EXPECTED_INSTANCE_TYPE);
        Assert.assertEquals(calculationResultPage.getValueOfItem("Region"), EXPECTED_REGION);
        Assert.assertEquals(calculationResultPage.getValueOfItem("local SSD"), EXPECTED_LOCAL_SSD);
        Assert.assertEquals(calculationResultPage.getValueOfItem("Commitment term"), EXPECTED_COMMITMENT_TERM);
    }

    @Test
    public void resultPriceAreEqualsToExpectedResult() {



        String totalCost = new GoogleCloudHomePage(driver)
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
                .pressButtonAddToEstimate()
                .getTotalCost();

        Assert.assertEquals(totalCost, EXPECTED_TOTAL_COST);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}

