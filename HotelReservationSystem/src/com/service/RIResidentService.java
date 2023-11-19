package com.service;

import java.util.*;
import java.util.List;

import com.management.RIResidentManagement;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentService {

	
	public List<RIResident> addRiResidentDetails(String[]input) throws Exception {
		// TODO Auto-generated method stub
		RIResidentManagement RiR=new RIResidentManagement();
	
		ApplicationUtil utilObj=new ApplicationUtil();
	    List<String> riRecords=utilObj.extractDetails(input);
	    List<RIResident> riList=new ArrayList<RIResident>();
		riList=buildRIResidentList(riRecords);
		 List<RIResident> insertedRecord=RiR.insertRIResidentIntoDB(riList);
	
		
		return insertedRecord;
	}

	
	private List<RIResident> buildRIResidentList(List<String> riRecords) {
		// TODO Auto-generated method stub
		List<RIResident>riList=new ArrayList<RIResident>();
		
		for(String ri:riRecords) {
			String[]field=ri.split(":");
			String residentName=field[0];
			int age=Integer.parseInt(field[1]);
			String gender=field[2];
			long contactNumber=Long.parseLong(field[3]);
			 String email=field[4];
			 String address=field[5];
			 int numberOfAdults=Integer.parseInt(field[6]);
			 int numberOfChildrenAbove12=Integer.parseInt(field[7]);
			 int numberOfChildrenAbove5=Integer.parseInt(field[8]);
			 int durationOfStay=Integer.parseInt(field[9]);
			 String residentType=field[10];
			 long idProofAadharNo=Long.parseLong(field[11]);
			 String residentId=getResidentId();
			RIResident RiR=new RIResident(residentId,residentName,age,gender,contactNumber,email,
			address,numberOfAdults,numberOfChildrenAbove12,numberOfChildrenAbove5,
			durationOfStay,residentType,idProofAadharNo);
			
			riList.add(RiR);
		}
		return riList;
	}
	
	static int i=1;
	
	public static String  getResidentId()
	{
		String s= "RIR"+String.valueOf(i);
		i++;
		return s;
	}
}
