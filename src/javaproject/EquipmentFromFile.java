package javaproject;

import java.io.Serializable;
import java.util.List;


// constant space complexity O(1)
// constant time complexity O(1)
class EquipmentFromFile implements Serializable {

	private List<EquipmentFromFile> collection;


	private String    nameFi;
	private String    manufacturerFi;
	private   int   serialNuFi;
	private String    modelFi;

	private String   ipAddFi;
	private String   oldIpAddFi;

	private String   locationFi;
	private String   oldLocationFi;
	private String  macAddFi;
	private String   connectionFi;

	public EquipmentFromFile( String nameFi, String manufacturerFi, int serialNuFi, String modelFi, String ipAddFi,String oldIpAddFi, String locationFi, String oldLocationFi, String macAddFi, String connectionFi) {
		this.collection = collection;
		this.nameFi = nameFi;
		this.manufacturerFi = manufacturerFi;
		this.serialNuFi = serialNuFi;
		this.modelFi = modelFi;
		this.ipAddFi = ipAddFi;
		this.oldIpAddFi = oldIpAddFi;
		this.locationFi = locationFi;
		this.oldLocationFi = oldLocationFi;
		this.macAddFi = macAddFi;
		this.connectionFi = connectionFi;
	}

	EquipmentFromFile() {
		nameFi = "";
		manufacturerFi = "";
		serialNuFi = 0;
		modelFi = "";
		ipAddFi= "";
		oldIpAddFi= "";
		locationFi = "";
		oldLocationFi = "";
		macAddFi = "";
		connectionFi = "";
	}

	@Override
	public String toString(){ // 1
		return "\n*******" +"\nName: " + nameFi + "\nModel: " + modelFi + "\nManufacture: " + manufacturerFi +
				"\nSerial Number: " + serialNuFi + "\nCurrent IP: " +
				ipAddFi + "\nOld IP Address:" + oldIpAddFi + "\nLocation: "+ locationFi + "\nOld Location: " + oldLocationFi + "\nMAC address: " + macAddFi +
				"\nConnection: " + connectionFi + "\n***********" ;
	}
}