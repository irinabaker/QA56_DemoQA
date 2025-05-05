package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.forms.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(app.driver).selectForms();
        new SidePanel(app.driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void createStudentAccountTest() {
        new PracticeFormPage(app.driver).enterPersonalData("Robert","Wide", "wide@gm.com","1234567890")
                .selectGender("Male")
                .typeOfDate("16 Aug 1987")
                .addSubject(new String[]{"Maths","Chemistry"})
                .selectHobby(new String[]{"Sports","Music"})
                .uploadFile("C:/Tools/1.jpg")
                .enterState("NCR")
                .enterCity("Delhi")
                .submit()
                .verifySuccessfulTitle("Thanks for submitting the form");
    }

    @Test
    public void createStudentAccountWithSelectDateTest() {
        new PracticeFormPage(app.driver).enterPersonalData("Robert","Wide", "wide@gm.com","1234567890")
                .selectGender("Male")
                .selectDate("August","1987","16")
                .addSubject(new String[]{"Maths","Chemistry"})
                .selectHobby(new String[]{"Sports","Music"})
                .uploadFile("C:/Tools/1.jpg")
                .enterState("NCR")
                .enterCity("Delhi")
                .submit()
                .verifySuccessfulTitle("Thanks for submitting the form");
    }
}
