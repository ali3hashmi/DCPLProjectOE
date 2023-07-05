package com.dcpl.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.dcpl.utility.NewExcelLibrary;

public class OrderExecutionDataProvider {
	
	NewExcelLibrary obj =new NewExcelLibrary();

	//Class -> OELoginPageTest
	//TestCase -> OELoginTest

	@DataProvider(name = "OELoginCredentials")
	public Object[][] getSearchCustomerDetails() {

		//total row count
		int rows=obj.getRowCount("OELogin");

		//total column
		int column =obj.getColumnCount("OELogin");

		int actRows=rows-1;

		//Created an object of array to store data
		Object[][] data =new Object[actRows][1];

		for(int i=0;i<actRows;i++) {

			Map<String, String> hashMap=new HashMap<>();
			for(int j=0;j<column;j++) {

				hashMap.put(obj.getCellData("OELogin", j, 1),
						obj.getCellData("OELogin", j, i+2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}
	
	//Class -> ReleaseOrderPageTest.java
		//TestCase -> verifyReleaseOrderByStoreCode,verifyReleaseOrderByOrderNo,verifyReleaseOrderByOrderType,verifyReleaseOrderByVendor,
	//verifyReleaseOrderBySegment,verifyReleaseOrderByOrderKind

		@DataProvider(name = "ReleaseOrderData")
		public Object[][] getReleaseOrderDetails() {

			//total row count
			int rows=obj.getRowCount("ReleaseOrder");

			//total column
			int column =obj.getColumnCount("ReleaseOrder");

			int actRows=rows-1;

			//Created an object of array to store data
			Object[][] data =new Object[actRows][1];

			for(int i=0;i<actRows;i++) {

				Map<String, String> hashMap=new HashMap<>();
				for(int j=0;j<column;j++) {

					hashMap.put(obj.getCellData("ReleaseOrder", j, 1),
							obj.getCellData("ReleaseOrder", j, i+2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}

		//Class -> FloorPercentageCreateTest.java
				//TestCase -> //Create Test

				@DataProvider(name = "PSQFloorPercentageData")
				public Object[][] getPSQFloorPercentageData() {

					//total row count
					int rows=obj.getRowCount("PSQFloorPercentage");

					//total column
					int column =obj.getColumnCount("PSQFloorPercentage");

					int actRows=rows-1;

					//Created an object of array to store data
					Object[][] data =new Object[actRows][1];

					for(int i=0;i<actRows;i++) {

						Map<String, String> hashMap=new HashMap<>();
						for(int j=0;j<column;j++) {

							hashMap.put(obj.getCellData("PSQFloorPercentage", j, 1),
									obj.getCellData("PSQFloorPercentage", j, i+2));
						}
						data[i][0]=hashMap;
					}
					return data;
				}

}
