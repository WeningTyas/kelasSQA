package com.juaracoding.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoQA {
    public static void main(String[] args) {
        // web Demo https://demoqa.com/text-box //

        String path = "E:\\Bootcam\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        System.out.println("Buka Browser dan buka URL");

        // Proses scraping
        String titlePage = driver.findElement(By.className("main-header")).getText();
        System.out.println(titlePage);
        // ambil judul halaman html yg bertag <title></title>
        String titleHeader = driver.getTitle();
        System.out.println(titleHeader);

        driver.findElement(By.id("userName")).sendKeys("Juara Coding");
        driver.findElement(By.id("userEmail")).sendKeys("email@email.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("submit")).click();
        System.out.println("Isi formnya");

        //validasi if else di assert
        if(titlePage == "Text Box"){ // atau bisa pakai .equalsIgnoreCase()
            System.out.println("Oke!");
        } else {
            System.out.println("Fail");
        }

        // Ini untuk scroll layar
        JavascriptExecutor jx = (JavascriptExecutor) driver;
        jx.executeScript("window.scrollBy(0,500)"); // scroll vertikal 500px
        //jx.executeScript("window.scrollBy(500,0)"); // scroll horizontal 500px

        //untuk membesarkan layar
        driver.manage().window().maximize();

        // delay();

        //Waiting Element (per 10 detik)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.quit();
        System.out.println("Keluar dari Browser");
    }

    public static void delay(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
