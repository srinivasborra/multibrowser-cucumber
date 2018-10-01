package com.test.qa.util;

import org.openqa.selenium.By;

public class PageObject {
	
	//HomePage objects
	public static By inputSearch = By.name("q");
	public static By btnSearch = By.name("btnK");
	public static By btnFeeling = By.name("gbqfbb");
	
	//demoqa objects
	
	public static By lnkAcntLogin = By.xpath("//a[contains(@href,'your-account')]");
	public static By loginTitle = By.className("entry-title");
	public static By inputUserName = By.id("log");
	public static By inputPwd = By.id("pwd");
	public static By btnLogin = By.name("submit");
	
	public static By mnuAllProudcts = By.xpath("//nav[(@id='main-nav')]//ul//li//a[contains(@href,'products-page')]");
	public static By lnkRegister = By.xpath("//a[contains(@href,'wp-login.php?action=register')]");
	
}
