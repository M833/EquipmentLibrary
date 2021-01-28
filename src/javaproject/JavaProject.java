package javaproject;

import java.io.*;
import java.util.*;
import javax.swing.*;


public class JavaProject {
    // Space Complexity = O(1) CONSTANT
    static Scanner input = new Scanner(System.in); // constant space complexity O(1)
    static int equipmentNum = 0, varz = 0, vard;  // constant space complexity O(1)
    static String remove, viewChoices, mainChoices;   // constant space complexity O(1)
    static Equipment[] Equipments = new Equipment[9999999];  // constant space complexity O(1)
    static Equipment el  = new Equipment();  // constant space complexity O(1)

    static JPanel panel = new JPanel();   // constant space complexity O(1)

    static JFrame frame = new JFrame();   // constant space complexity O(1)

    public static String lastName ;  // constant space complexity O(1)
    public static String lastModel ;  // constant space complexity O(1)
    public static String lastManufacture ;  // constant space complexity O(1)
    public static int lastSerialNu ;  // constant space complexity O(1)
    public static String lastIpAdd ;  // constant space complexity O(1)
    public static String lastOldIpAdd ;  // constant space complexity O(1)
    public static String lastLocation ;  // constant space complexity O(1)
    public static String lastOldLocation;  // constant space complexity O(1)
    public static String lastMacAdd;  // constant space complexity O(1)
    public static String lastConnection;  // constant space complexity O(1)

// Storing and loading from file
static String nameOfFile = null;  // constant space complexity O(1)
    static EquipmentFile eqFile = new EquipmentFile();  // constant space complexity O(1)
    //static Scanner in = new Scanner(System.in);  // constant space complexity O(1)
    static boolean running = true;  // constant space complexity O(1)

// Time complexity for main class = O(1)
// Space complexity = o(1)
    public static void main( String[] args ) throws IOException, InterruptedException, ClassNotFoundException {

                JDialog.setDefaultLookAndFeelDecorated(true);
                //getLastUpdated();

                 loop:
		do{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");Thread.sleep(300);
            System.out.println("||    Welcome To Network Library Equipments!!   ||");Thread.sleep(300);
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");Thread.sleep(300);
			System.out.print("|| 1.  Add Equipments                           ||\n");Thread.sleep(300);
			System.out.print("|| 2.  Edit Equipments                          ||\n");Thread.sleep(300);
			System.out.print("|| 3.  Equipments                               ||\n");Thread.sleep(300);
			System.out.print("|| 4.  Delete Equipments                        ||\n");Thread.sleep(300);
            System.out.print("|| 5.  Get last added equipment                 ||\n");Thread.sleep(300);
            System.out.print("|| 6.  Get last updated equipment               ||\n");Thread.sleep(300);
            System.out.print("|| 7.  Find Equipment by Serial number          ||\n");Thread.sleep(300);
            System.out.print("|| 8.  Find equipment by MAC address            ||\n");Thread.sleep(300);
            System.out.print("|| 9.  Find all equipments in old Location      ||\n");Thread.sleep(300);
            System.out.print("|| 10. Find all Equipments in current Location  ||\n");Thread.sleep(300);
            System.out.print("|| 11. Add Equipment to File                    ||\n");Thread.sleep(300);
            System.out.print("|| 12. Load All Equipments From FIle            ||\n");Thread.sleep(300);
            System.out.print("|| 13. List All Equipments From File            ||\n");Thread.sleep(300);
            System.out.print("|| 14. Save to file                             ||\n");Thread.sleep(300);
            System.out.print("|| 15. Exit                                     ||\n");Thread.sleep(300);

            System.out.println("==========================================================");Thread.sleep(300);
			System.out.print("|| Enter choice: ");
			mainChoices = input.next();
                        System.out.println("==========================================================");
                        System.out.println();
//=====================================================================================================================================
                if (    "1".equals(mainChoices)){
                    addEquipment();
                }
//=====================================================================================================================================
                else if ("2".equals(mainChoices)) {
                    editEquipment();
                }
//=====================================================================================================================================
                else if ("3".equals(mainChoices)) {
                    viewEquipments();
                }
//=====================================================================================================================================
                else if ("4".equals(mainChoices)) {
                    deleteEquipment();
                }
//=====================================================================================================================================
                else if ("5".equals(mainChoices)) {
                    getLastAdded();

                }
                else if ("6".equals(mainChoices)) {
                    getLastUpdated();
                }
                else if ("7".equals(mainChoices)) {
                    System.out.println("Enter the serial number for the equipment you want to search for: ");
                   int  serialNu = input.nextInt();  // constant space complexity O(1)
                        findEquipmentBySerialNu(serialNu);

                }
                else if ("8".equals(mainChoices)) {
                    System.out.println("Enter the MAC Address for the equipment you want to search for: ");
                    String  macAdd = input.next();  // constant space complexity O(1)
                    findEquipmentByMacAdd(macAdd);
                }
                else if ("9".equals(mainChoices)) {
                    System.out.println("Enter the old location for your equipments: ");
                    String enteredOldLocation = input.next();  // constant space complexity O(1)
                    findPreviousEqLocation(enteredOldLocation);
                }
                else if ("10".equals(mainChoices)) {
                    System.out.println("Enter the current location for your equipment that you want to search for: ");
                    String enteredCurrentLocation = input.next();  // constant space complexity O(1)
                    findCurrentEqLocation(enteredCurrentLocation);
                }
                else if ("11".equals(mainChoices)) {
                    addEquipmentToFile();
                }
                else if ("12".equals(mainChoices)) {
                    System.out.println("Enter file name to load ");
                    nameOfFile=input.next();
                    loadFile(nameOfFile);
                }
                else if ("13".equals(mainChoices)) {
                    System.out.println(eqFile.toString());
                }
                else if ( "14".equals(mainChoices)) {
                    saveToFile();
                }
                else if ( "15".equals(mainChoices)) {
                    closeLibrary();
                }

//=====================================================================================================================================
            else{
                JOptionPane.showMessageDialog(panel, "INVALID INPUT. PLEASE TRY AGAIN", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(true);
    }
//=====================================================================================================================================
// closeLibrary have 0(1) time complexity
    // SPACE Complexity = o(1)
    private static void closeLibrary() throws IOException, InterruptedException, ClassNotFoundException {
        int response = JOptionPane.showConfirmDialog(null, "DO YOU REALLY WISH TO EXIT?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); // O(1)   // constant space complexity O(1)

        if (response == JOptionPane.YES_OPTION) { // 0(1)
            JOptionPane.showMessageDialog(frame, "LIBRARY TERMINATED","", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        else if (response == JOptionPane.CLOSED_OPTION) { // o(1)
            main(null);
        }
    }
//=====================================================================================================================================
// Time Complexity = o(1) + O(n) + o(1) + o(1) + o(1) + o(1) + o(1) + o(1) + O(n)
    // SPACE Complexity = O(1) + O(N) + O(N)
    private static void deleteEquipment() throws InterruptedException, IOException, ClassNotFoundException {
        if (equipmentNum == 0){  // O(1)
            JOptionPane.showMessageDialog(panel, "EMPTY Equipment DATABASE. NOTHING TO DELETE", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.print("\n");
            main(null);
        }

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("||\t\t===== DELETE EQUIPMENT =====\t\t||");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        System.out.println("__________________________________________________________");
        System.out.printf("|| \t\tEQUIPMENTS ARE READY FOR DELETING\t\t||\n");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for(int i = 0; i < equipmentNum; i++){ // O(N) // space complexity of O(n)
            System.out.printf(" [%d] - Equipment %d\n",i+1 , Equipments[i].getSerialNu());
        }

        int tryenterdel = 3; // O(1)   // constant space complexity O(1)
        delete:
        do{    //
            System.out.println("__________________________________________________________"); //1
            System.out.printf("|| ENTER EQUIPMENT NUMBER TO DELETE: "); // 1
            remove = input.next();
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"); //1
            vard = Integer.parseInt(remove); //1

            if( vard > equipmentNum ){ //1
                JOptionPane.showMessageDialog(panel, "ENTERED NUMBER DOESN'T'NT EXIST. CHOOSE ONLY\n\t\t\tWHAT'S ON THE LIST", "Warning", JOptionPane.WARNING_MESSAGE);
                tryenterdel--;

                if (tryenterdel == 0){ //1
                    int response = JOptionPane.showConfirmDialog(null, "ARE YOU STUCK ? DO YOU WISH TO EXIT?", "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);   //  space complexity of O(1)

                    if (response == JOptionPane.YES_OPTION) { //1
                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
                        main(null);
                    }
                    else if (response == JOptionPane.CLOSED_OPTION) { //1
                        continue delete;
                    }
                }
                if(tryenterdel == -3){  //1
                    JOptionPane.showMessageDialog(frame,"WE REALLY THINK YOU ARE STUCK ! AND FOR THAT REASON\n\t"
                            +"WE ARE REDIRECTING YOU TO THE MAIN MEMU.","REDIRECTING", JOptionPane.INFORMATION_MESSAGE);


                    System.out.println("__________________________________________________________");
                    System.out.printf("|| REDIRECTING. PLEASE WAIT ");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.println("\t\t\t||\n|| SUCCESSFULLY REDIRECTED!\t\t\t\t||");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                    main(null);
                }
            }
            else{
                int response = JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE Equipment"+remove+" ?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  // constant space complexity O(1)

                if (response == JOptionPane.YES_OPTION) { //1
                    for(int r = vard - 1;  r < equipmentNum - 1; r++){ //O(N)   //  space complexity of O(n)
                        Equipments [r] = Equipments [r+1];
                    }
                    equipmentNum--;
                    System.out.println("__________________________________________________________");
                    System.out.printf("|| DELETING EQUIPMENT. PLEASE WAIT ");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.printf("˳");Thread.sleep(300);
                    System.out.println("\t\t\t||\n|| EQUIPMENT SUCCESSFULLY REMOVED!\t\t\t\t||");
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
                    main(null);
                }
                else if (response == JOptionPane.CLOSED_OPTION) { //1
                    main(null);
                }
            }
        }while( varz > equipmentNum || varz == 0 ); //TIME COMPLEXITY O(N)
    }
//=====================================================================================================================================
    // Time Complexity = o(1) + O(n) + O(n)
    // SPACE Complexity = o(1) + O(N) + O(1)
    public static void editEquipment() throws InterruptedException, IOException, ClassNotFoundException {
        String n = null;
        String mo = null; 
        String ma = null;
        int ser = 0; 
        String ip = null; 
        String oIp = null;
        String lo = null; 
        String oLo = null;
        String mac = null; 
        String co = null;
        if (equipmentNum == 0){ // o(1)
            JOptionPane.showMessageDialog(panel, "EMPTY EQUIPMENT DATABASE. NOTHING TO EDIT", "Warning", JOptionPane.WARNING_MESSAGE);
            System.out.print("\n");
        }
        else{
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("||\t   ===== MODIFY USER EQUIPMENTS =====   \t\t||");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
            System.out.println("__________________________________________________________");
            System.out.println("|| \t\tEQUIPMENTS READY FOR EDITING\t\t||");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            for(int i = 0; i < equipmentNum; i++){ // time compllexity of O(n)  //  space complexity of O(n)
                System.out.printf(" [%d] - Equipment %d\n",i+1 , Equipments[i].getSerialNu());
                 n = Equipments[i].getName();
                 mo = Equipments[i].getModel();
                 ma = Equipments[i].getManufacturer();
                 ser = Equipments[i].getSerialNu();
                 ip = Equipments[i].getIpAdd();
                 oIp = Equipments[i].getOldIpAdd();
                 lo = Equipments[i].getLocation();
                 oLo = Equipments[i].getOldLocation();
                 mac = Equipments[i].getMacAdd();
                 co = Equipments[i].getConnection();


            }

            System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            int tryenter = 3;  // constant space complexity O(1)
            check:
            do{
                System.out.printf("|| ENTER ENTRY NUMBER TO MODIFY: ");
                String modify = input.next();

                varz = Integer.parseInt(modify);
                Equipments [varz-1] = el;

                if( 0 == varz || varz > equipmentNum || varz < 0){ //1
                    JOptionPane.showMessageDialog(panel, "ENTRY NUMBER DOES'NT EXIST. CHOOSE ONLY\n\t\t\tWHAT'S ON THE LIST", "Warning", JOptionPane.WARNING_MESSAGE);
                    tryenter --;

                    if (tryenter == 0){ //1
                        int response = JOptionPane.showConfirmDialog(null, "ARE YOU STUCK ? DO YOU WISH TO EXIT?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);  // constant space complexity O(1)

                        if (response == JOptionPane.YES_OPTION) {
                            System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
                            main(null);
                        }
                        else if (response == JOptionPane.CLOSED_OPTION) { //1
                            continue check;
                        }
                    }
                    if(tryenter == -3){ //1
                        JOptionPane.showMessageDialog(frame,"I REALLY THINK YOU ARE STUCK ! AND FOR THAT REASON\n\t"
                                +"I AM REDIRECTING YOU TO THE MAIN MENU.","REDIRECTING", JOptionPane.INFORMATION_MESSAGE);


                        System.out.println("__________________________________________________________");
                        System.out.printf("|| REDIRECTING. PLEASE WAIT ");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.printf("˳");Thread.sleep(300);
                        System.out.println("\t\t\t||\n|| SUCCESSFULLY REDIRECTED!\t\t\t\t||");
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        main(null);
                    }
                    continue check;
                }
                else{ //1
                    System.out.println("What do you want to change? ");
                    System.out.println("1. Change the Equipment's IP Address: ");
                    System.out.println("2. Change Equipment's Current Location: ");
                    System.out.print("Enter choice: ");
                    int choice = input.nextInt();
                    if (choice == 1){
                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        System.out.println(" ENTER THE NEW IP ADDRESS FOR EQUIPMENT "+modify);
                        System.out.println("__________________________________________________________");

                        el.setName(n);
                        el.setModel(mo);
                        el.setManufacturer(mo);
                        el.setSerialNu(ser);
                        el.setOldIpAdd(ip);

                        System.out.print("|| Enter the new IP Address   : ");
                        el.setIpAdd(input.next());
                        //System.out.print("|| Enter the new Location : ");

                        el.setLocation(lo);
                        el.setOldLocation(oLo);
                        el.setMacAdd(mac);
                        el.setConnection(co);
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                    } else if (choice == 2){
                        System.out.println("\n¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        System.out.println(" ENTER THE NEW LOCATION FOR EQUIPMENT "+modify);
                        System.out.println("__________________________________________________________");

                        el.setName(n);
                        el.setModel(mo);
                        el.setManufacturer(mo);
                        el.setSerialNu(ser);
                        el.setOldIpAdd(oIp);

                        //System.out.print("|| Enter the new IP Address   : ");
                        el.setIpAdd(ip);
                        System.out.print("|| Enter the new Location : ");
                        el.setLocation(input.next());

                        el.setOldLocation(lo);
                        el.setMacAdd(mac);
                        el.setConnection(co);
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                    }else {
                        System.out.println("Please Enter a Valid Choice !!");

                    }


                }

            }while( varz > equipmentNum || varz == 0 );  // TIME COMPLEXITY O(N)
            System.out.println("__________________________________________________________");
            System.out.printf("|| EDITING DATA. PLEASE WAIT ");Thread.sleep(300);
            System.out.printf("˳");Thread.sleep(300);
            System.out.printf("˳");Thread.sleep(300);
            System.out.printf("˳");Thread.sleep(300);
            System.out.printf("˳");Thread.sleep(300);
            System.out.printf("˳");Thread.sleep(300);
            System.out.println("\t\t\t||\n|| DATA SUCCESSFULLY EDITED!\t\t\t\t||");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        }
            lastName = el.getName();
             lastModel = el.getModel();
             lastManufacture = el.getManufacturer();
             lastSerialNu = el.getSerialNu();
        lastIpAdd = el.getIpAdd();
        lastOldIpAdd = el.getOldIpAdd();
             lastLocation = el.getLocation();
             lastOldLocation = el.getOldLocation();
             lastMacAdd = el.getMacAdd();
             lastConnection = el.getConnection();
             /*
           System.out.println("New Name is: " + el.getName());
            System.out.println("New Model is: " + el.getModel());
            System.out.println("New Manufacture is: " + el.getManufacturer());
            System.out.println("New Serial is: " + el.getSerialNu());
            System.out.println("New IP Address is: " + el.getIpAdd());
            System.out.println("New Location is: " + el.getLocation());
            System.out.println("New Old Location is: " + el.getOldLocation());
            System.out.println("New Mac Address is: " + el.getMacAdd());
            System.out.println("New Connection is: " + el.getConnection()); */

    }
//=====================================================================================================================================
// Time complexity = O(1) + O(n) + O(1) + O(n)
// SPACE complexity = O(n) + O(1)
    private static void viewEquipments() throws IOException, InterruptedException, ClassNotFoundException {
        exit:
        do{  //1
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("||\t\t===== VIEW Equipment =====\t\t||");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("|| 1. View User Equipments\t\t\t\t||");Thread.sleep(300);
            System.out.print("|| 2. Back to Main Menu\t\t\t\t\t||\n");Thread.sleep(300);

            System.out.println("==========================================================");
            System.out.print("|| Enter choice: ");viewChoices = input.next();
            System.out.println("==========================================================\n");


             if (viewChoices.equals("1")){ //1
                if (equipmentNum == 0){ //1
                    JOptionPane.showMessageDialog(panel, "EMPTY Equipment DATABASE. NOTHING TO VIEW", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                else{ //1
                    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("||\t\t===== VIEW EQUIPMENTS =====\t\t||");
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

                    for(int i=0;i<equipmentNum;i++){ //O(N)  //  space complexity of O(n)
                        System.out.println("__________________________________________________________");
                        Equipment s = Equipments[i];
                        System.out.printf("||\t\t[%d] - Equipment %d\n",i+1 , Equipments[i].getSerialNu());
                        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                        System.out.printf("|| Equipment Name   : %s\n",s.getName());Thread.sleep(300);
                        System.out.printf("|| Equipment model  : %s\n", s.getModel());Thread.sleep(300);
                        System.out.printf("|| Equipment manufacturer  : %s\n", s.getManufacturer());Thread.sleep(300);
                        System.out.printf("|| Equipment Serial Number  : %d\n", s.getSerialNu());Thread.sleep(300);
                        System.out.printf("|| Equipment IP Address    : %s\n", s.getIpAdd());Thread.sleep(300);
                        System.out.printf("|| Equipment Old IP Address    : %s\n", s.getOldIpAdd());Thread.sleep(300);
                        System.out.printf("|| Equipment Location : %s\n", s.getLocation());Thread.sleep(300);
                        System.out.printf("|| Equipment Old Location   : %s\n", s.getOldLocation());Thread.sleep(300);
                        System.out.printf("|| Equipment MAC Address  : %s\n", s.getMacAdd());Thread.sleep(300);
                        System.out.printf("|| Equipment Connection           : %s\n", s.getConnection());
                        System.out.println("==========================================================\n");
                    }
                }
            }
            else if (viewChoices.equals("2")){ //1
                main(null);
            }
            else{
                JOptionPane.showMessageDialog(panel, "INVALID INPUT. PLEASE TRY AGAIN", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(equipmentNum != 0); //TIME O(N)
    }
//=====================================================================================================================================
// Time complexity =  O(1)
// SPACE complexity =  O(1)
    private static void addEquipment() { // Time complexity =  O(1)
        if(equipmentNum<50){ //1
            int serialNu = 0;  // constant space complexity O(1)
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("||\t\t===== ADD EQUIPMENT =====\t\t\t||");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            System.out.print("|| Equipment Name           : ");
            String name = input.next();
            System.out.print("|| Equipment model          : ");
            String model = input.next();
            System.out.print("|| Equipment Manufacturer   : ");
            String manufacturer = input.next();

            System.out.print("|| Equipment Serial Number  : ");
            serialNu = input.nextInt();

            System.out.print("|| Equipment IP Address     : ");
            String ipAdd = input.next();
            System.out.print("|| Equipment Old IP Address : ");
            String oldIpAdd = input.next();
            System.out.print("|| Equipment Location       : ");
            String location = input.next();
            System.out.print("|| Equipment Old Location   : ");
            String oldLocation = input.next();
            System.out.print("|| Equipment MAC Address    : ");
            String macAdd = input.next();
            System.out.print("|| Equipment Connection     : ");
            String connection = input.next();
            System.out.println("==========================================================");

            //$$$$$$#$%^$@#$@%$#%2
            Equipment s = new Equipment(name, manufacturer, serialNu, model, ipAdd,
                    oldIpAdd, location, oldLocation, macAdd, connection);  // constant space complexity O(1)

            Equipments[equipmentNum] = s;
            equipmentNum++;
            //System.out.println(s);
            System.out.println("\n");
        }
        else{
            JOptionPane.showMessageDialog(panel, "CAN'T ADD NEW Equipment, Equipment ARRAY IS FULL", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("\n");
        }
    }
//=====================================================================================================================================
    // Time complexity =  O(1)
// SPACE complexity =  O(1)
    public static void getLastAdded() throws InterruptedException {

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("||\t\t===== VIEW Equipment =====\t\t||");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        //for(int i=0;i<equipmentNum;i++){
            System.out.println("__________________________________________________________");
            Equipment s = Equipments[equipmentNum-1];

            //System.out.printf("||\t\t[%d] - Equipment %d\n" , s.getSerialNu());
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

            System.out.printf("|| Equipment Name   : %s\n",s.getName());Thread.sleep(300);
            System.out.printf("|| Equipment model  : %s\n", s.getModel());Thread.sleep(300);
            System.out.printf("|| Equipment manufacturer  : %s\n", s.getManufacturer());Thread.sleep(300);
            System.out.printf("|| Equipment Serial Number  : %d\n", s.getSerialNu());Thread.sleep(300);
        System.out.printf("|| Equipment current IP Address    : %s\n", s.getIpAdd());Thread.sleep(300);
        System.out.printf("|| Equipment Old IP Address    : %s\n", s.getOldIpAdd());Thread.sleep(300);
            System.out.printf("|| Equipment Location : %s\n", s.getLocation());Thread.sleep(300);
            System.out.printf("|| Equipment Old Location  : %s\n", s.getOldLocation());Thread.sleep(300);
            System.out.printf("|| Equipment MAC address  : %s\n", s.getMacAdd());Thread.sleep(300);
            System.out.printf("|| connections           : %s\n", s.getConnection());
            System.out.println("==========================================================\n");
        //}

    }
    //=====================================================================================================================================
    // Time complexity =  O(N)
// SPACE complexity =  O(N)
    private static void getLastUpdated() {
        System.out.println("New Name is: " + lastName);
        System.out.println("New Model is: " + lastModel);
        System.out.println("New Manufacture is: " + lastManufacture);
        System.out.println("New Serial is: " + lastSerialNu);
        System.out.println("current IP Address is: " + lastIpAdd);
        System.out.println("Old IP Address is: " + lastOldIpAdd);
        System.out.println("New Location is: " + lastLocation);
        System.out.println("New Old Location is: " + lastOldLocation);
        System.out.println("New Mac Address is: " + lastMacAdd);
        System.out.println("New Connection is: " + lastOldLocation);
    }
    //=====================================================================================================================================
    // Time complexity = O(n)
    // constant space complexity O(n) + o(1)
    private static Equipment findEquipmentBySerialNu(int  serialNu){  // space 0(1)
        try
        {
        for (Equipment equipment: Equipments  //TIME O(N) // SPACE O(N)
             ) {
            if (equipment.getSerialNu() == serialNu ) {
                System.out.println("__________________________________________________________");
                System.out.print("||\t\t - Equipment \n" + equipment.getSerialNu());
                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                System.out.printf("|| Equipment Name   : %s\n",equipment.getName());Thread.sleep(300);
                System.out.printf("|| Equipment model  : %s\n", equipment.getModel());Thread.sleep(300);
                System.out.printf("|| Equipment manufacturer  : %s\n", equipment.getManufacturer());Thread.sleep(300);
                System.out.printf("|| Equipment Serial Number  : %d\n", equipment.getSerialNu());Thread.sleep(300);
                System.out.printf("|| Equipment IP Address    : %s\n", equipment.getIpAdd());Thread.sleep(300);
                System.out.printf("|| Equipment old IP Address    : %s\n", equipment.getOldIpAdd());Thread.sleep(300);
                System.out.printf("|| Equipment Location : %s\n", equipment.getLocation());Thread.sleep(300);
                System.out.printf("|| Equipment Old Location  : %s\n", equipment.getOldLocation());Thread.sleep(300);
                System.out.printf("|| Equipment MAC address   : %s\n", equipment.getMacAdd());Thread.sleep(300);
                System.out.printf("|| Equipment Connection           : %s\n", equipment.getConnection());
                System.out.println("==========================================================\n");

                return equipment;
            }
        }

        } catch (Exception e) {
            System.out.println("Sorry we Couldn't find your Equipment !!");;
        }

        return null;
    }
//=====================================================================================================================================
// Time complexity =  O(N)
// SPACE complexity =  O(N)
    private static Equipment findEquipmentByMacAdd(String  macAdd){
        try
        {    //@#$%^&%$#@
            for (Equipment equipment: Equipments //O(N)
            ) {
                if (equipment.getMacAdd().equals(macAdd) ) { //1
                    System.out.println("__________________________________________________________");
                    System.out.print("||\t\t - Equipment \n" + equipment.getSerialNu());
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                    System.out.printf("|| Equipment Name          : %s\n",equipment.getName());Thread.sleep(300);
                    System.out.printf("|| Equipment model         : %s\n", equipment.getModel());Thread.sleep(300);
                    System.out.printf("|| Equipment manufacturer  : %s\n", equipment.getManufacturer());Thread.sleep(300);
                    System.out.printf("|| Equipment Serial Number : %d\n", equipment.getSerialNu());Thread.sleep(300);
                    System.out.printf("|| Equipment Current IP Address: %s\n", equipment.getIpAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Old IP Address: %s\n", equipment.getOldIpAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment New Location  : %s\n", equipment.getLocation());Thread.sleep(300);
                    System.out.printf("|| Equipment Old Location  : %s\n", equipment.getOldLocation());Thread.sleep(300);
                    System.out.printf("|| Equipment MAC address   : %s\n", equipment.getMacAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Connection    : %s\n", equipment.getConnection());
                    System.out.println("==========================================================\n");

                    return equipment;
                }
            }

        } catch (Exception e) {
            System.out.println("Sorry we Couldn't find your equipment !!");;
        }

        return null;
    }
//=====================================================================================================================================
// Time Complexity = O(n) + O(1)
//  space complexity O(N)
    private static void findPreviousEqLocation(String enteredOldLocation){

        try
        {
            for(int i=0;i<equipmentNum;i++) { //O(N)

                System.out.println("__________________________________________________________");
                Equipment s = Equipments[i];  // constant space complexity O(1)
                if (s.getOldLocation().equals(enteredOldLocation)){ // constant time complexity of 0(1)
                    System.out.printf("||\t\t[%d] - Equipment %d\n", i + 1, Equipments[i].getSerialNu());
                System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                System.out.printf("|| Equipment Name   : %s\n", s.getName());Thread.sleep(300);
                System.out.printf("|| Equipment model  : %s\n", s.getModel());Thread.sleep(300);
                System.out.printf("|| Equipment manufacturer  : %s\n", s.getManufacturer());Thread.sleep(300);
                System.out.printf("|| Equipment Serial Number  : %d\n", s.getSerialNu());Thread.sleep(300);
                    System.out.printf("|| Equipment IP Address    : %s\n", s.getIpAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Old IP Address    : %s\n", s.getOldIpAdd());Thread.sleep(300);
                System.out.printf("|| Equipment Location : %s\n", s.getLocation());Thread.sleep(300);
                System.out.printf("|| Equipment Old Location  : %s\n", s.getOldLocation());Thread.sleep(300);
                System.out.printf("|| Equipment MAC Address  : %s\n", s.getMacAdd());Thread.sleep(300);
                System.out.printf("|| Equipment Connection           : %s\n", s.getConnection());
                System.out.println("==========================================================\n");

            }else{
                    System.out.println("Sorry we Couldn't find your equipment !!");;

                }
            }

        } catch (Exception e) {
            System.out.println("Sorry we Couldn't find your equipment !!");;
        }


        }
    //=====================================================================================================================================
// Time Complexity = O(n) + O(1) + O(1)
// SPACE Complexity = O(n) + O(1)
    private static void findCurrentEqLocation(String enteredCurrentLocation){

        try
        {
            for(int i=0;i<equipmentNum;i++) {  //O(N)   //  space complexity of O(n)

                System.out.println("__________________________________________________________");
                Equipment s = Equipments[i];
                if (s.getLocation().equals(enteredCurrentLocation)){ //1
                    System.out.printf("||\t\t[%d] - Equipment %d\n", i + 1, Equipments[i].getSerialNu());
                    System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

                    System.out.printf("|| Equipment Name   : %s\n", s.getName());Thread.sleep(300);
                    System.out.printf("|| Equipment model  : %s\n", s.getModel());Thread.sleep(300);
                    System.out.printf("|| Equipment manufacturer  : %s\n", s.getManufacturer());Thread.sleep(300);
                    System.out.printf("|| Equipment Serial Number  : %d\n", s.getSerialNu());Thread.sleep(300);
                    System.out.printf("|| Equipment Current IP Address    : %s\n", s.getIpAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Old IP Address    : %s\n", s.getOldIpAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Location : %s\n", s.getLocation());Thread.sleep(300);
                    System.out.printf("|| Equipment Old Location  : %s\n", s.getOldLocation());Thread.sleep(300);
                    System.out.printf("|| Equipment MAC Address  : %s\n", s.getMacAdd());Thread.sleep(300);
                    System.out.printf("|| Equipment Connection           : %s\n", s.getConnection());
                    System.out.println("==========================================================\n");
                }
                else{
                    System.out.println("Sorry we Couldn't find your equipment !!");;

                }
            }

        } catch (Exception e) {
            System.out.println("Sorry we Couldn't find your equipment !!");;
        }
    }
//=====================================================================================================================================
// Time Complexity = O(1)
// SPACE Complexity = O(1)
    private static void addEquipmentToFile(){
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("||\t\t===== ADD Equipment =====\t\t\t||");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        System.out.print("|| Equipment Name    : ");
        String nameF = input.next();   // constant space complexity O(1)
        System.out.print("|| Equipment model   : ");
        String modelF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment Manufacturer   : ");
        String manufacturerF = input.next();  // constant space complexity O(1)

        System.out.print("|| Equipment Serial Number   : ");
        int serialNuF = input.nextInt();  // constant space complexity O(1)
        System.out.print("|| Equipment IP Address     : ");
        String ipAddF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment Old IP Address     : ");
        String oldIpAddF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment Location  : ");
        String locationF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment Old Location   : ");
        String oldLocationF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment MAC Address   : ");
        String macAddF = input.next();  // constant space complexity O(1)
        System.out.print("|| Equipment connection            : ");
        String connectionF = input.next();  // constant space complexity O(1)
        System.out.println("==========================================================");

        EquipmentFromFile b = new EquipmentFromFile(nameF, manufacturerF, serialNuF,
                modelF, ipAddF,oldIpAddF, locationF, oldLocationF, macAddF, connectionF);  // constant space complexity O(1)

        eqFile.addEquipmentToFile(b);

    }
    //=====================================================================================================================================
    //Time Complexity = O(1)
    // SPACE Complexity = O(1)
    private static void saveToFile() throws IOException {
        System.out.println("Enter File name: ");
        nameOfFile = input.next() + ".ser";
        running = false;
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;
        fileOut = new FileOutputStream(nameOfFile);
        objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(eqFile);
        System.out.println("Equipment saved successfully to the file !! ");
        fileOut.close();
        objOut.close();
    }
//=====================================================================================================================================
// Time Complexity = O(1)
// constant space complexity O(1)
    private static void loadFile(String fName) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        File loadedFile = new File(nameOfFile+".ser");  // constant space complexity O(1)
        if(loadedFile.exists()){ //1
            fileIn = new FileInputStream(loadedFile);
            objIn = new ObjectInputStream(fileIn);
            eqFile = (EquipmentFile) objIn.readObject();
            fileIn.close();
            System.out.println("File Loaded Successfully!!");
        }else{
            System.out.println("\nFile does not exist!");
        }
    }

}