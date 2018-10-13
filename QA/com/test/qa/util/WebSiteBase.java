package com.test.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriverService;

import com.test.qa.page.HomePage;

public class WebSiteBase {
	final static Logger logger = Logger.getLogger(WebSiteBase.class);
	
	public static WebDriver webdriver;
	private static String chromebrowser;
	private static String safaribrowser;
	private static String firefoxbrowser;
	private static String iebrowser;

	private static ChromeDriverService chromeService;
	private static GeckoDriverService fireFoxService;
	private static SafariDriverService safariService;
    private static InternetExplorerDriverService ieService;
	private static String chromepath;
	private static String safaripath;
	private static String firefoxpath;
	private static String iepath;

	static {
		initProperties();
	}

	public WebDriver initiateBrowser(String browser) throws Exception {
		if (browser != null && browser.length() > 0) {
			
			String brw = browser.toLowerCase();
			switch (brw) {
			case "chrome":
				chromeService = new ChromeDriverService.Builder().usingDriverExecutable(new File(chromepath))
						.usingAnyFreePort().build();
				chromeService.start();
				DesiredCapabilities ch = DesiredCapabilities.chrome();
				ch.acceptInsecureCerts();
				ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				webdriver = new RemoteWebDriver(chromeService.getUrl(), ch);
				break;
			case "safari":
				safariService = new SafariDriverService.Builder().usingDriverExecutable(new File(safaripath))
						.usingAnyFreePort().build();
				safariService.start();
				webdriver = new RemoteWebDriver(safariService.getUrl(), DesiredCapabilities.safari());
				break;
			case "firefox":
				fireFoxService = new GeckoDriverService.Builder().usingDriverExecutable(new File(firefoxpath))
						.usingAnyFreePort().build();
				fireFoxService.start();
				webdriver = new RemoteWebDriver(fireFoxService.getUrl(), DesiredCapabilities.firefox());
				break;
			case "ie":
				ieService = new InternetExplorerDriverService.Builder().usingDriverExecutable(new File(iepath)).usingAnyFreePort().build();
				ieService.start();
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				webdriver = new RemoteWebDriver(ieService.getUrl(),DesiredCapabilities.internetExplorer());
				break;
			}
		}
		return webdriver;
	}

	public static void initProperties() {
		Properties prop = new Properties();

		try {
			Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
			prop.load(new FileInputStream(new File(path + "/QA/com/test/qa/config/qa.properties")));
			chromebrowser = prop.getProperty(GlobalConstants.QA_CHROME_BROWSER);
			safaribrowser = prop.getProperty(GlobalConstants.QA_SAFARI_BROWSER);
			firefoxbrowser = prop.getProperty(GlobalConstants.QA_FIREFOX_BROWSER);
			iebrowser = prop.getProperty(GlobalConstants.QA_IE_BROWSER);

			chromepath = prop.getProperty(GlobalConstants.QA_CHROME_PATH);
			safaripath = prop.getProperty(GlobalConstants.QA_SAFARI_PATH);
			firefoxpath = prop.getProperty(GlobalConstants.QA_FIREFOX_PATH);
			iepath = prop.getProperty(GlobalConstants.QA_IE_PATH);
			
			logger.info("Initial Properties are loaded");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}
	
}
