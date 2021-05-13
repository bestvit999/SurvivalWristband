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
public class TeamWork2 {
    //DB test
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        wristBandSystem wbs = new wristBandSystem();
        user currentUser = new user(wbs);
        wbs.addUser(currentUser);
       // String userId = "yuntech",  password = "12345";
        appPageUi appui = wbs.connect();
        wristBandGUI.displaMessage("Please select login(1) or sign up(2)");
        String selection = scanner.next();
        
        Loop:outer:
        while(true){
        switch(selection){
            case"1":
                appui.login(currentUser);
                break outer;
            case"2":
                appui.signup(currentUser);
                break outer;
            default:
                wristBandGUI.displaMessage("Input error, please input login(1) or sign up(2) again");
                selection = scanner.next();
                        
               break;
        }
        }
 
        // start recording
        boolean normalState = true;
        //currentUser.pressEmergencyButton();//press button
        while(normalState == true){
            normalState = wbs.Recording(37, 120, 1, 30, 50);//test manually
            //normalState = wbs.Recording(Math.random()*(45-30+1)+30, Math.random()*(120-80+1)+80, Math.random()*3+1, Math.random()*(200-25+1)+25, Math.random()*(150-0+1)+0);//send bodyTemperature,pulse,shakingCount,roomtemperature idleTime
        }
        
    }
    
    
}
