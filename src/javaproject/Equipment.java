package javaproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// // SPACE COMPLEXITY FOR ALL CLASS = CONSTANT O(1)
// SPACE COMPLEXITY = CONSTANT O(1)
class Equipment implements Serializable {

	public String  name;
	public String  manufacturer;
	public  int   serialNu;
	private String  model;
	private String   ipAdd;
	private String   oldIpAdd;
	private String   location;
	private String  oldLocation;
	private String   macAdd;
	public String    connection;


	// SPACE COMPLEXITY = CONSTANT O(1)
    public Equipment(String name, String manufacturer, int serialNu, String model, String ipAdd,String oldIpAdd, String location, String oldLocation, String macAdd, String connection) {
    	this.name = name;
	this.manufacturer = manufacturer;
	this.serialNu = serialNu;
	this.model = model;
		this.ipAdd = ipAdd;
		this.oldIpAdd = oldIpAdd;
	this.location = location;
	this.oldLocation = oldLocation;
	this.macAdd = macAdd;
	this.connection = connection;
    }
    public void Eq(String ipAdd, String oldLocation){
    	this.ipAdd=ipAdd;
    	this.oldLocation=oldLocation;
	}

	Equipment() {
    	name = "";
	manufacturer = "";
	serialNu = 0;
	model = "";
		ipAdd= "";
		oldIpAdd= "";
	location = "";
	oldLocation = "";
	macAdd = "";
	connection = "";
    }


    // SPACE COMPLEXITY = CONSTANT O(1)
     void setName(String name) {
            this.name = name;
        }
     void setSerialNu(int temp) {
			serialNu = temp;
        }
    void setConnection(String connection) { this.connection = connection; }
     void setLocation(String location) {
            this.location = location;
        }
     void setOldLocation(String oldLocation) {
            this.oldLocation = oldLocation;
        }
     void setMacAdd(String macAdd) {
            this.macAdd = macAdd;
        }
     void setModel(String symbol) {
            this.model = symbol;
        }
     void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }
     void setIpAdd(String ipAdd) { this.ipAdd = ipAdd; }
     void setOldIpAdd(String oldIpAdd) { this.oldIpAdd = oldIpAdd; }

	// SPACE COMPLEXITY = CONSTANT O(1)
	public String getName(){ return name; }
	public String getManufacturer(){ return manufacturer; }
	public int getSerialNu(){ return serialNu; }
	public String getModel(){ return model; }
	public String getIpAdd() { return ipAdd; }
	public String getOldIpAdd() { return oldIpAdd; }
	public String getLocation(){ return 	location; }
	public String getOldLocation(){ return 	oldLocation; }
	public String getMacAdd(){ return 	macAdd; }
	public String getConnection(){ return 	connection; }
}