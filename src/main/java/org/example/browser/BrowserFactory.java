package org.example.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

import java.util.logging.Logger;

public class BrowserFactory {

    private Logger logger = Logger.getLogger(BrowserFactory.class.getName());

    Playwright playwright;

    public BrowserFactory(Playwright playwright) {
        this.playwright = playwright;
    }

    public Browser createBrowser() {
        logger.info("Creating Browser");
      return playwright.chromium().launch();
    }
}
