package org.example.browser;

import com.microsoft.playwright.Playwright;

import java.util.logging.Logger;

public class PlaywrightWrapper {

    private java.util.logging.Logger logger = Logger.getLogger(BrowserFactory.class.getName());

    public Playwright createPlaywright() {
        logger.info("Creating Playwright instance");
        return Playwright.create();
    }
}
