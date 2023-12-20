package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.RoomManagement;
import com.model.Room;

public class RoomService {

	public List<Room> buildRoomList() {
		// TODO Auto-generated method stub
		List<Room> roomList=new ArrayList<Room>();
		int number=101;
		for(int i=101;i<=180;i++) {
			String roomNumber=getRoomNumerDetails(i);
			String floorNumber=getFloorNumberDetails(i);
			String isOccupied="No";
			int maxOccupancy=5;
			String hasAc="yes";
		    String hasSwimmingPoolAcces="yes";
			String hasGymAccess="yes";
			Room rd=new Room(roomNumber,floorNumber,isOccupied,maxOccupancy,hasAc,hasSwimmingPoolAcces,hasGymAccess);
			roomList.add(rd);
		
		}
		
		return roomList;
	}

	private String getFloorNumberDetails(int number) {
		// TODO Auto-generated method stub
//		String total=rim.getRoomNumber();
//		total+=number;
		if(number>=100 && number<=120) {
			return "Floor 1";
		}
		else if(number>120 && number<=140) {
			return "Floor 2";
		}
		else if(number>140 && number<=160) {
			return "Floor 3";
		}
		else {
			return "Floor 4";
		}
	
		
	}

	private String getRoomNumerDetails(int num) {
	    int num1=num;
		// TODO Auto-generated method stub
		String s= "R"+Integer.toString(num1);
		return s;
	}

	public List<Room> addRoomList() {
		// TODO Auto-generated method stub
		RoomManagement RmS=new RoomManagement();
		List<Room> roomLists= buildRoomList();
		List<Room> insertedRoomRecord=RmS.insertRoomIntoDB(roomLists);
		return insertedRoomRecord;
	}
     RoomManagement rim=new RoomManagement();
	public boolean checkRoomNumber(String rno) {
		// TODO Auto-generated method stub
		boolean i=rim.checkRoomNumber(rno);
		return i;
	}

	public int updateOccupiedStatus(String rno, String occupy) {
		// TODO Auto-generated method stub
		int i=rim.updateOccupiedStatus(rno,occupy);
		return i;
	}

	public int deleteRoomDetails(String delRoom) {
		// TODO Auto-generated method stub
		
		return rim.deleteRoomDetails(delRoom);
	}
	 
}
