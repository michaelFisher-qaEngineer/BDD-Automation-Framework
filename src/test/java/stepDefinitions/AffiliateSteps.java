package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.FileReader;
import java.util.Properties;

import pageObjects.AffiliatePage;
import testBase.BaseClass;

public class AffiliateSteps extends BaseClass {

    private AffiliatePage affiliate;
    public Properties properties;
    @When("user navigates to affiliate page")
    public void user_navigates_to_affiliate_page() throws InterruptedException {
        affiliate = new AffiliatePage(getDriver());
        affiliate.navigateToAffiliateForm();
        log.info("Navigated to affiliate form");
    }

    @When("user submits affiliate registration details")
    public void user_submits_affiliate_registration_details() throws InterruptedException, Exception {
        // Using safe defaults; you can parameterize later via Scenario Outline
    	FileReader file = new FileReader(".//src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);

        affiliate.fillAffiliateDetails(
        		properties.getProperty("affiliateCompany"),
        		properties.getProperty("affiliateWebsite"),
        		properties.getProperty("affiliateTaxid"),
        		properties.getProperty("affiliatePayeeName")
        );
        log.info("Submitted affiliate registration details");
    }

    @Then("affiliate registration should be successful")
    public void affiliate_registration_should_be_successful() {
        Assert.assertTrue(affiliate.isAffiliateAdded(), "Affiliate registration success message not displayed");
        log.info("Affiliate registration verified");
    }
}
