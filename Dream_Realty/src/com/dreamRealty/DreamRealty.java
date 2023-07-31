package com.dreamRealty;

import java.sql.SQLException;

import com.dreamRealty.service.Service;

public class DreamRealty {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Dream Realty");
		Service service=new Service();
		service.DropTable();
        service.createTableProperties();
        service.insertInitialData();
        service.displayAllRecords();
		
	}

}
