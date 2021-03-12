package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for PatientList.
 */
public class PatientListTest 
{
    /**
     * Rigorous Test :-)
     */
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

        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","123456789",12,postal);
        assertTrue( patientList.addPatient(object));
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
     
    }
    
    @Test
    public void deletePatient_True()
    {
        PatientList patientList = new PatientList();

        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","123456789",12,postal);
        patientList.addPatient(object);
        assertTrue(patientList.deletePatient(0));
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
    }
    @Test
    public void deletePatient_Fail()
    {
        PatientList patientList = new PatientList();

        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","123456789",12,postal);
        patientList.addPatient(object);
        assertFalse(patientList.deletePatient(2));
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
    }

    @Test
    public void getPatient_InvalidID_Fail()
    {
    PatientList patientList = new PatientList(); 
    boolean result = false;

    try{
    PostalCode postal = new PostalCode("K1A-0B9");
    Patient object = new Patient("Kaden","123456789",12,postal);
    patientList.addPatient(object);

    if (patientList.getPatient("000000000") == null)
    {
    result = true;
    }

    assertTrue(result);
    }
    catch (InvalidPostalCodeException e)
    {
        throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
        assertTrue(false);
    }
    catch (InvalidNameException e1)
    {
        throw new InvalidNameException("Name Exception","Invalid Name");
        assertTrue(false);
    }
    catch (InvalidAgeException e2)
    {
        throw new InvalidAgeException("Age Exception","Invalid Age");
        assertTrue(false);
    }
    catch (InvalidIDException e3)
    {
        throw new InvalidIDException("ID Exception","Invalid ID");
        assertTrue(false);
    }
    }

    @Test
    //No patient with ID fail..
    public void getPatient_ID_Fail()
    {
    PatientList patientList = new PatientList();
    boolean result = false;

    try{
    PostalCode postal = new PostalCode("K1A-0B9");
    Patient object = new Patient("Kaden","123456789",12,postal);
    patientList.addPatient(object);

    if (patientList.getPatient("000000022") == null)
    {
        result = true;
    }
    
    assertTrue(result);
    }
    catch (InvalidPostalCodeException e)
    {
        throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
        assertTrue(false);
    }
    catch (InvalidNameException e1)
    {
        throw new InvalidNameException("Name Exception","Invalid Name");
        assertTrue(false);
    }
    catch (InvalidAgeException e2)
    {
        throw new InvalidAgeException("Age Exception","Invalid Age");
        assertTrue(false);
    }
    catch (InvalidIDException e3)
    {
        throw new InvalidIDException("ID Exception","Invalid ID");
        assertTrue(false);
    }
    }


    @Test
    //No patient with ID fail..
    public void getPatient_ID_Success()
    {
    PatientList patientList = new PatientList();
    boolean result = true;

    try{
    PostalCode postal = new PostalCode("K1A-0B9");
    Patient object = new Patient("Kaden","123456789",12,postal);
    patientList.addPatient(object);
    
    Patient patientX = patientList.getPatient("123456789");
    if (patientX == null)
    {
        result = false;
    }
    
    assertTrue(result);
    }
    catch (InvalidPostalCodeException e)
    {
        throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
        assertTrue(false);
    }
    catch (InvalidNameException e1)
    {
        throw new InvalidNameException("Name Exception","Invalid Name");
        assertTrue(false);
    }
    catch (InvalidAgeException e2)
    {
        throw new InvalidAgeException("Age Exception","Invalid Age");
        assertTrue(false);
    }
    catch (InvalidIDException e3)
    {
        throw new InvalidIDException("ID Exception","Invalid ID");
        assertTrue(false);
    }
    }

    //2
    @Test
    public void getNumOfPatients_Success()
    {
        PatientList patientList = new PatientList();
        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","12345678",12,postal);
        patientList.addPatient(object);
        PostalCode postal2 = new PostalCode("K1A-0C9");
        Patient object2 = new Patient("KadenG","12345679",14,postal2);
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
    catch (InvalidPostalCodeException e)
    {
        throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
        assertTrue(false);
    }
    catch (InvalidNameException e1)
    {
        throw new InvalidNameException("Name Exception","Invalid Name");
        assertTrue(false);
    }
    catch (InvalidAgeException e2)
    {
        throw new InvalidAgeException("Age Exception","Invalid Age");
        assertTrue(false);
    }
    catch (InvalidIDException e3)
    {
        throw new InvalidIDException("ID Exception","Invalid ID");
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
