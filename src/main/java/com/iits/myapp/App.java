package com.iits.myapp;

import java.io.File;
import java.io.IOException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class App {
    public static void main( String[] args ) throws JAXBException, IOException {
        System.out.println("--start jvm--");
        System.out.println("Perform Marshalling");
        performeMarshalling();
        System.in.read();
        System.in.read();
        System.out.println("Perform UnMarshalling");
        performeUnMarshalling();
        
        System.out.println("--end jvm--");
    }

	private static void performeUnMarshalling() throws JAXBException {
		 //converting back XML back to Java Object
		 JAXBContext jaxb=JAXBContext.newInstance(Employee.class);
		
		 Unmarshaller un=jaxb.createUnmarshaller();
		 Object o=un.unmarshal(new File("src/main/resources/employee.xml"));
		 if(o instanceof Employee emp) {
			 System.out.println(emp);
		 }
	}

	private static void performeMarshalling() throws JAXBException {
		 Employee emp=new Employee();
		 emp.setId(1001);
		 emp.setName("RAJU");
		 emp.setSalary(30000.00);
		 JAXBContext jaxb=JAXBContext.newInstance(Employee.class);
		 Marshaller marshaller=jaxb.createMarshaller();
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
		 marshaller.marshal(emp,System.out);
		 marshaller.marshal(emp, new File("src/main/resources/employee.xml"));
	}
}
