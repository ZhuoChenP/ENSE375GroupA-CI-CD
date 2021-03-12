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
  //  @BeforeClass
 //   public static void setup() throws Exception 
 //   {
 //       try{
  //          int age = 12;
//            String id = "123456789";
 //           String name = "Kaden";
 //       PostalCode postal = new PostalCode("K1A-0B9");
 //       Patient object = new Patient(name,id,age,postal);

  //      age = 14;
  //      id = "123456781";
//        name = "KadenG";
 ///       PostalCode postal1 = new PostalCode("K1A-1B9");
 //       Patient object2 = new Patient(name,id,age,postal1);

//    }
 //   catch (InvalidPostalCodeException e)
//    {
//        throw new InvalidPostalCodeException();
        
 //   }
 //   catch (InvalidNameException e)
 //   {
 //       throw new InvalidNameException("Invalid Name");
        
 //   }
 //   catch (InvalidAgeException e)
 //   {
 //       throw new InvalidAgeException(-1);
       
  //  }
 //   catch (InvalidIDException e)
 //   {
  //      throw new InvalidIDException("Invalid ID");
        
  //  }
 //   }




    @Test
    public void patientList_Succesful_Add() 
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();
        assertTrue(patientList.addPatient(object));
    }
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}   
    }
    
    @Test
    public void deletePatient_True()
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();

        patientList.addPatient(object);
        assertTrue(patientList.deletePatient(0));
    }
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
}


    @Test
    public void deletePatient_Fail()
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();

        patientList.addPatient(object);
        assertFalse(patientList.deletePatient(2));
    }
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
 
    }

    @Test
    public void getPatient_InvalidID_Fail()
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();
    
        boolean result = false;

   
    patientList.addPatient(object);

    if (patientList.getPatient("000000000") == null)
    {
    result = true;
    }

    assertTrue(result);
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
    }


    @Test
    //No patient with ID fail..
    public void getPatient_ID_Fail() 
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();
         boolean result = false;

    patientList.addPatient(object);


    if (patientList.getPatient("000000022") == null)
    {
        result = true;
    }
    
    assertTrue(result);
    }
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
    }
   


    @Test
    //No patient with ID fail..
    public void getPatient_ID_Success()
    {
        try{
            int age = 12;
            String id = "123456789";
            String name = "Kaden";
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient(name,id,age,postal);
        PatientList patientList = new PatientList();
         boolean result = true;
    patientList.addPatient(object);
    
    Patient patientX = patientList.getPatient("123456789");
    if (patientX.getID() == null)
    {
        result = false;
    }
    
    assertTrue(result);
    }
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
    }
    

    //2
    @Test
    public void getNumOfPatients_Success()
    {
        try{
        PatientList patientList = new PatientList();
        
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
    catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
    {}
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
