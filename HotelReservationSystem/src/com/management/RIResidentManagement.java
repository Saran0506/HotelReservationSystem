package com.management;

import java.util.*;
import java.sql.*;

import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentManagement {

	public List<RIResident> insertRIResidentIntoDB(List<RIResident> riList) throws Exception{

		// TODO Auto-generated method stub
//		ApplicationUtil ap=new ApplicationUtil();
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into riresident values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
//		List<RIResident> rirList=new ArrayList<RIResident>();
		int count=riList.size();
		for(RIResident r:riList) {
			try {
				ps.setString(1,r.getResidentId());
				ps.setString(2,r.getResidentName());
				ps.setInt(3,r.getAge());
				ps.setString(4, r.getGender());
				ps.setLong(5,r.getContactNumber());
				ps.setString(6,r.getEmail());
				ps.setString(7,r.getAddress());
				ps.setInt(8, r.getNumberOfAdults());
				ps.setInt(9,r.getNumberOfChildrenAbove12());
				ps.setInt(10,r.getNumberOfChildrenAbove5());
				ps.setInt(11, r.getDurationOfStay());
				ps.setString(12, r.getResidentType());
				ps.setLong(13, r.getIdProofAadharNo());
				ps.addBatch();
				int[] row=new int[count];
				row=ps.executeBatch();
				riList.add(r);
				
			}
			catch(SQLException e) {
				System.out.println(r.getResidentName()+" is not added successfully because of "+e.getMessage());
			}
		}
		
		
		return riList;
	}
	

	

}
