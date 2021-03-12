package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;

import org.junit.Test;
import org.junit.BeforeClass;
import jdk.jfr.Timestamp;

/**
 * Unit test for PatientList.
 */




public class PatientListTest 
{
    /**
     * Rigorous Test :-)
     */

    private static PostalCode postal;
    private static Patient object;
    private static PostalCode postal2;
    private static Patient object2;

    @BeforeClass
    public static void setup() throws Exception 
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);

        age = 14;
        id = "123456781";
        name = "KadenG";
        PostalCode postal1 = new PostalCode("K1A-1B9");
        Patient object2 = new Patient(name,id,age,postal1);

    }
    catch (InvalidPostalCodeException e)
    {
        throw new InvalidPostalCodeException();
        
    }
    catch (InvalidNameException e)
    {
        throw new InvalidNameException("Invalid Name");
        
    }
    catch (InvalidAgeException e)
    {
        throw new InvalidAgeException(-1);
       
    }
    catch (InvalidIDException e)
    {
        throw new InvalidIDException("Invalid ID");
        
    }
    }



    @Test
    public void patientList_Fail_To_Add()
    {
        PatientList patientList = new PatientList();
        //error in name.     
        assertFalse(patientList.addPatient(null));          
    }
    @Test
    public void patientList_Succesful_Add() 
    {
        PatientList patientList = new PatientList();    
        assertTrue(patientList.addPatient(object));
       
     
    }
    
    @Test
    public void deletePatient_True()
    {
        PatientList patientList = new PatientList();

        patientList.addPatient(object);
        assertTrue(patientList.deletePatient(0));
       
    }
    @Test
    public void deletePatient_Fail()
    {
        PatientList patientList = new PatientList();

       
        patientList.addPatient(object);
        assertFalse(patientList.deletePatient(2));
       
    }

    @Test
    public void getPatient_InvalidID_Fail()
    {
    PatientList patientList = new PatientList(); 
    boolean result = false;

   
    patientList.addPatient(object);

    if (patientList.getPatient("000000000") == null)
    {
    result = true;
    }

    assertTrue(result);
   
    }

    @Test
    //No patient with ID fail..
    public void getPatient_ID_Fail() 
    {
    PatientList patientList = new PatientList();
    boolean result = false;

    patientList.addPatient(object);


    if (patientList.getPatient("000000022") == null)
    {
        result = true;
    }
    
    assertTrue(result);
    }
   


    @Test
    //No patient with ID fail..
    public void getPatient_ID_Success()
    {
    PatientList patientList = new PatientList();
    boolean result = true;
    patientList.addPatient(object);
    
    Patient patientX = patientList.getPatient("123456789");
    if (patientX == null)
    {
        result = false;
    }
    
    assertTrue(result);
    }
   
    

    //2
    @Test
    public void getNumOfPatients_Success()
    {
        PatientList patientList = new PatientList();
       
    
        patientList.addPatient(object);
        patientList.addPatient(object2);


        int number = patientList.getNumberofPatients();

        if(number == 2)
        {
            assertTrue(true);
        }
        else
        {
        assertTrue(false);
        }
    }
   

    @Test
    public void getNumOfPatients_Empty()
    {
        PatientList patientList = new PatientList();

        int number = patientList.getNumberofPatients();

        if(number == 0)
        {
            assertTrue(true);
        }
        else{
        assertTrue(false);
        }
    }


}
