package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import reports.ExtentManager;

public class Hooks {
    private static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void beforeAll() {
        // Initialize ExtentReports once before all scenarios
        extent = ExtentManager.getExtentReports();
        System.out.println("Extent Reports initialized.");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extent == null) {
            // Fallback (safety) in case beforeAll was skipped
            extent = ExtentManager.getExtentReports();
        }
        test = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (test == null) {
            return; // avoid NPE if init failed
        }
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
    }

    @AfterAll
    public static void afterAll() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent Report generated at: " + ExtentManager.getReportPath());
        }
    }
}
