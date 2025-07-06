package org.example.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@EnableScheduling
public class Test {

    Logger logger = Logger.getLogger(BrowserFactory.class.getName());

    @Scheduled(fixedDelay = 200)
    public void oneTest() {
        logger.info("Executing one test");
        Playwright playwright = new PlaywrightWrapper().createPlaywright();
        Browser browser = new BrowserFactory(playwright).createBrowser();
        Page page = browser.newPage();
        page.navigate("http://www.google.com");
        logger.info("Navigated to page http://www.google.com");
        page.close();
        logger.info("Page closed");
        browser.close();
        logger.info("Browser closed");
        playwright.close();
        logger.info("Playwright closed");
    }
}
