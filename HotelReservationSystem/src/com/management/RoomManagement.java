package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Room;

public class RoomManagement {

	public List<Room> insertRoomIntoDB(List<Room> buildRoomList) {
		// TODO Auto-generated method stub
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into room value(?,?,?,?,?,?,?)");
			for(Room r:buildRoomList) {
				ps.setString(1,r.getRoomNumber() );
				ps.setString(2,r.getFloorNumber());
				ps.setInt(4,r.getMaxOccupancy());
				ps.setString(3,r.getIsOccupied());
				ps.setString(5,r.getHasAc());
				ps.setString(6,r.getHasSwimmingPoolAcces());
				ps.setString(7,r.getHasGymAccess());
				ps.addBatch();
			}
			ps.executeBatch();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return buildRoomList;
	}

	public boolean checkRoomNumber(String rno) {
		// TODO Auto-generated method stub
		String sql="select count(*) from room where room_number=?";
		boolean roomNumberExists=false;
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, rno);
			ResultSet rs=ps.executeQuery();
			try {
				if(rs.next()) {
					int count=rs.getInt(1);
					roomNumberExists=count>0;
				}
			}finally {
				rs.close();
			}
			}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return roomNumberExists;
	}

	public int updateOccupiedStatus(String rno, String occupy) {
		String sql="update room set is_occupied=? where room_number=?";
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,occupy);
			ps.setString(2,rno);
			return ps.executeUpdate();
			
			}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
			
		}
		
		
	}

	public int deleteRoomDetails(String delRoom) {
		// TODO Auto-generated method stub
		String sql="delete from room where room_number=?";
		try {
			Connection con=DBConnectionManager.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,delRoom);
		
			return ps.executeUpdate();
			
			}
		catch(SQLException e) {
			e.printStackTrace();
			return 0;
			
		}
		
	}

	

}
