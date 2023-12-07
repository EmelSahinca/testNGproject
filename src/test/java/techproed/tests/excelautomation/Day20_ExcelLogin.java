package techproed.tests.excelautomation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day20_ExcelLogin {
    HomePage homePage;
    LoginPage loginPage;
    ExcelUtils excelUtils;
    List<Map<String,String>> allTestData;

    //1.create a login method
    public void login(){
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
homePage=new HomePage();
loginPage=new LoginPage();
        ReusableMethods.waitFor(3);

        try {
            homePage.homePageLoginLink.click();
        }catch (Exception e){

        }
        try {
            ReusableMethods.waitFor(1);
            homePage.userID.click();
            ReusableMethods.waitFor(1);
            homePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            homePage.OK.click();
            ReusableMethods.waitFor(1);
            homePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);

        }catch (Exception e){

        }

        ReusableMethods.waitFor(3);

        /*I am on the login screen
        send username
        send password
        click on login link
        I AM ON HOME PAGE


        */




    }
    @Test
    public void customerLoginTest(){
        String path="/Users/emelsahin/Desktop/testNGproject/src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName="customer_info";
excelUtils=new ExcelUtils(path,sheetName);
//getDataList() method returns all excel data we stored that in allTestData variable
allTestData=excelUtils.getDataList();
        System.out.println(allTestData);

for (Map<String,String> eachData : allTestData){
    //Takes us to the login page
    login();
    loginPage.userName.sendKeys(eachData.get("username"));
    ReusableMethods.waitFor(1);
    loginPage.password.sendKeys(eachData.get("password"));
    ReusableMethods.waitFor(1);
    loginPage.loginButton.click();
    ReusableMethods.waitFor(1);
    //verify if login is successful
    //IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
    ReusableMethods.verifyElementDisplayed(homePage.userID);




}

        }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    /*     LOGIN FLOW
        click on login LINK          ------>>>>>>  homePage.homePageLoginLink.click(); --->> TRY WHEN LINK IS THERE---> 1st TRY CATCH--> logIn
        send username
        send password                 ----->>>>> DONE
        click on login BUTTON
        I AM ON HOME PAGE
        **********PATTERN 1**********
        click on user id
        click on log out             ----->>>>>>2nd TRY CATCH -> logIn
        click on ok
        I AM ON HOME PAGE AGAIN
        click on login LINK
        *********PATTERN 2***********
        send username
        send password           ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN
        *****************
         click on user id
        click on log out
        click on ok                     ----->>>>>>2nd TRY CATCH -> logIn
        I AM ON HOME PAGE AGAIN
        click on login LINK
         ********************
        send username
        send password       ----->>>>>>>>>>>>>>>>>@Test Method is used to send credentials and verification
        click on login Button
        I AM ON HOME PAGE AGAIN
 */
}
