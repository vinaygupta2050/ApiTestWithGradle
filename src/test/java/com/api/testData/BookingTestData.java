package com.api.testData;

import org.testng.annotations.DataProvider;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class BookingTestData {
    @DataProvider
    public static Object[][] newUserData() {
        return new Object[][]{
                        {"Vinaykumar","Gupta",11,true,"2020-01-02","2020-01-03","Breakfast"},
                        {"Vinaykumar1","Gupta",12,true,"2020-01-02","2020-01-03","Breakfast"},
                        {"Vinaykumar2","Gupta",13,true,"2020-01-02","2020-01-03","Breakfast"}
                };
        }
    }
