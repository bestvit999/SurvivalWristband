/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamwork2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class appPageUi {
   DBserverListener DBserverListener = new DBserverListener();
    Scanner scanner = new Scanner(System.in);
    //login 
    public void login(user currentUser){
        String userId,password;
        //this.currentUser = currentUser;
        scanner = new Scanner(System.in);
                  wristBandGUI.displaMessage("Please log in  account\n");
                  wristBandGUI.displaMessage("Please input account:");
                  userId = scanner.next();
                  wristBandGUI.displaMessage("Please input password:");
                 password = scanner.next();
                 boolean result = currentUser.confirm(userId, password);
                if(result){
                    currentUser.connect();                                   //connect to device
                    return;
                 }
                else{
                    this.handleLoginError(currentUser);
                }
        
    }
    //handleLoginError
    void handleLoginError(user currentUser){
        while(true){
           wristBandGUI.displaMessage("Account or password is error, please input account again(1) or sign up(2)");
           String select = scanner.next();
           switch(select){
               case "1":
                   this.login(currentUser);
                   return;
               case "2":
                   this.signup(currentUser);
                   return;
               default:
                   wristBandGUI.displaMessage("Please input 1 or 2");
                   break;
           }
        }
    }
    //sign up
    public void signup(user currentUser){
        this.fillpersonalInformation(currentUser);
        this.login(currentUser);
    }
    //fill personal info
    public void fillpersonalInformation(user currentUser){
        String userId,password,emergencyContactPerson,addressNumber,address;

        wristBandGUI.displaMessage("First use, please signup account\n");
        wristBandGUI.displaMessage("Please input account:");
       userId = scanner.next();
       wristBandGUI.displaMessage("Please input password:");
       password = scanner.next();
        wristBandGUI.displaMessage("Please input emergencyContactPerson:");
       emergencyContactPerson = scanner.next();
       wristBandGUI.displaMessage("Please input emergencyContactPerson phone Number:");
       addressNumber = scanner.next();
       wristBandGUI.displaMessage("Please input address:");
       address = scanner.next();
       currentUser.record(userId, password,emergencyContactPerson,addressNumber,address);    //record new data in userDB
       wristBandGUI.displaMessage("Signup sucessfully\n") ;
       DBserverListener.sendDataToMySQLServer(currentUser);
    }
}
