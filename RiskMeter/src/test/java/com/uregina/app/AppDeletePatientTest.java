package com.uregina.app;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.junit.Before;


@RunWith(Parameterized.class)
public class AppDeletePatientTest {
    private String patientID;
    private boolean expected_output;
    private App app;

    @Before
    public void initialize() {
        app = new App();
        app.addPatient("Julie Doe", "123456789", "K1A-0B7", 31);
        app.addPatient("Julie Do", "123498765", "K1A-9B2", 31);
        app.addPatient("Juliec", "987654321", "K1A-3B9", 31);
        app.addPatient("Juliea", "123453769", "K1T-0B7", 33);
        app.addPatient("Julieb", "123452763", "K1T-9B2", 33);
        app.addPatient("Julied", "123451762", "K1T-3B9", 33);
        app.addPatient("Juliee", "963852741", "K1D-0B7", 36);
        app.addPatient("Julief", "369258147", "K1D-9B2", 36);
        app.addPatient("Julieg", "951376248", "K1D-3B9", 36);
    }

    public AppDeletePatientTest(String patientID, boolean output)
    {
        this.patientID=patientID;
        this.expected_output=output;
    }

    @Parameterized.Parameters(name="{index}: DeletePatient({0})={1}")
    public static Collection<Object[]> data() {
       return Arrays.asList(new Object[][] {
          {"123456789",true},{"123498765",true},{"987654321",true},{"123453769",true},{"123452763",true}
          ,{"123451762",true},{"88888888",false},{"",false},{"963852741",true},{"369258147",true},{"951376248",true}
       });
    }

    @Test
    public void appDeletePatientTest_Boundary() {
    assertEquals(expected_output, app.deletePatient(patientID));
    }
}
