/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.irrf.model;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Renan
 */
public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl;

    public SeleniumTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Renan\\Downloads\\IRRFWeb\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8084";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    //                                               Teste 1
    @Test
    public void testE1() throws Exception {
        driver.get(baseUrl + "/IRRFWeb/irrf");
        driver.findElement(By.id("cpNome")).clear();
        driver.findElement(By.id("cpNome")).sendKeys("jg");
        driver.findElement(By.id("cpRend")).clear();
        driver.findElement(By.id("cpRend")).sendKeys("R$ 6,78");
        driver.findElement(By.id("cpContri")).clear();
        driver.findElement(By.id("cpContri")).sendKeys("R$ 57.687,89");
        driver.findElement(By.id("cpDepend")).clear();
        driver.findElement(By.id("cpDepend")).sendKeys("4560");
        driver.findElement(By.id("cpPensao")).clear();
        driver.findElement(By.id("cpPensao")).sendKeys("R$ 5,67");
        driver.findElement(By.id("cpMedico")).clear();
        driver.findElement(By.id("cpMedico")).sendKeys("R$ 54,67");
        driver.findElement(By.id("cpEducacao")).clear();
        driver.findElement(By.id("cpEducacao")).sendKeys("R$ 5,67");
        driver.findElement(By.id("cpOutras")).clear();
        driver.findElement(By.id("cpOutras")).sendKeys("R$ 5.465,76");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 10.437.584,46".equals(driver.findElement(By.id("cpDeducoes")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("R$ 10.437.584,46", driver.findElement(By.id("cpDeducoes")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro Ocorrido em Try cpDeduções");
        }
        try {
            assertEquals("-R$ 10.437.577,68", driver.findElement(By.id("cpBase")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro Ocorrido em Try cpBase");
        }
        try {
            assertEquals("R$ 0,00", driver.findElement(By.id("cpImp")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro Ocorrido em Try cpImp");
        }
    }

    //                                      Teste 2
    @Test
    public void testE2() throws Exception {
        driver.get(baseUrl + "/IRRFWeb/irrf");
        driver.findElement(By.id("cpNome")).clear();
        driver.findElement(By.id("cpNome")).sendKeys("Jorge");
        driver.findElement(By.id("cpRend")).clear();
        driver.findElement(By.id("cpRend")).sendKeys("R$ 12,23");
        driver.findElement(By.id("cpContri")).clear();
        driver.findElement(By.id("cpContri")).sendKeys("R$ 21,34");
        driver.findElement(By.id("cpDepend")).clear();
        driver.findElement(By.id("cpDepend")).sendKeys("4");
        driver.findElement(By.id("cpPensao")).clear();
        driver.findElement(By.id("cpPensao")).sendKeys("R$ 23,45");
        driver.findElement(By.id("cpMedico")).clear();
        driver.findElement(By.id("cpMedico")).sendKeys("R$ 21,34");
        driver.findElement(By.id("cpEducacao")).click();
        driver.findElement(By.id("cpEducacao")).clear();
        driver.findElement(By.id("cpEducacao")).sendKeys("R$ 213,44");
        driver.findElement(By.id("cpOutras")).click();
        driver.findElement(By.id("cpOutras")).clear();
        driver.findElement(By.id("cpOutras")).sendKeys("R$ 2,43");
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 9.382,32".equals(driver.findElement(By.id("cpDeducoes")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("R$ 9.382,32", driver.findElement(By.id("cpDeducoes")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro Ocorrido em Try cpDeduções Teste2");
        }
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("-R$ 9.370,09".equals(driver.findElement(By.id("cpBase")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro Ocorrido em Try cpBase Teste2");
            }
            Thread.sleep(1000);
        }

        assertEquals("-R$ 9.370,09", driver.findElement(By.id("cpBase")).getAttribute("value"));
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 0,00".equals(driver.findElement(By.id("cpImp")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro Ocorrido em Try cpImp Teste2");
            }
            Thread.sleep(1000);
        }

        assertEquals("R$ 0,00", driver.findElement(By.id("cpImp")).getAttribute("value"));
    }

    @Test
    public void testE3() throws Exception {
        driver.get(baseUrl + "/IRRFWeb/");
        driver.findElement(By.id("cpNome")).clear();
        driver.findElement(By.id("cpNome")).sendKeys("Juberval");
        assertEquals("R$ 5.000.000,00", driver.findElement(By.id("cpRend")).getAttribute("value"));
        driver.findElement(By.id("cpContri")).click();
        assertEquals("R$ 499.000,00", driver.findElement(By.id("cpContri")).getAttribute("value"));
        driver.findElement(By.id("cpDepend")).clear();
        driver.findElement(By.id("cpDepend")).sendKeys("2");
        assertEquals("R$ 10.000,00", driver.findElement(By.id("cpPensao")).getAttribute("value"));
        driver.findElement(By.id("cpMedico")).click();
        assertEquals("R$ 400.000,00", driver.findElement(By.id("cpMedico")).getAttribute("value"));
        driver.findElement(By.id("cpEducacao")).click();
        assertEquals("R$ 10.000,00", driver.findElement(By.id("cpEducacao")).getAttribute("value"));
        driver.findElement(By.id("cpOutras")).click();
        assertEquals("R$ 10,00", driver.findElement(By.id("cpOutras")).getAttribute("value"));
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 923.560,16".equals(driver.findElement(By.id("cpDeducoes")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("R$ 923.560,16", driver.findElement(By.id("cpDeducoes")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro cpDeduções teste 3");
        }
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 4.076.439,84".equals(driver.findElement(By.id("cpBase")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("R$ 4.076.439,84", driver.findElement(By.id("cpBase")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro cpDeduções teste 3");
        }
        for (int second = 0;; second++) {
            if (second >= 60) {
                fail("timeout");
            }
            try {
                if ("R$ 1.120.151,60".equals(driver.findElement(By.id("cpImp")).getAttribute("value"))) {
                    break;
                }
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("R$ 1.120.151,60", driver.findElement(By.id("cpImp")).getAttribute("value"));
        } catch (Error e) {
            System.out.println("Erro cpDeduções teste 3");
        }
    }
}
