/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamwork2;

/**
 *
 * @author User
 */
public class wristBandSystem {
    //define attribute
    private final medicalHistory mh = new medicalHistory();
    private final appPageUi appui = new appPageUi();
    private final dangerDetermin dangerDetermin = new dangerDetermin();
    private boolean sucessfullornot = false;
    private final rescueTeam rescueTeam = new rescueTeam();
    private user currentUser; 
    private DBserverListener DBserverListener = new DBserverListener();
    public void addUser(user currentUser){
        this.currentUser = currentUser;
    }
    //connect
    public appPageUi connect(){ //
        wristBandGUI.displaMessage("System start!!");
        wristBandGUI.displaMessage("please loging!!");
        return appui;
    }
    
    //start to recording 
    public boolean Recording(double bodytemperature,double pulse,double shakingCount,double roomtemperature,double idleTime){
        boolean normalState = true;//define normal state
        normalState = mh.record(bodytemperature,pulse,shakingCount,roomtemperature,idleTime);  //send bodyTemperature,pulse,shakingCount,roomtemperature idleTime
        DBserverListener.sendRecordingDataToMySQLServer(this);//send recording data

        if(currentUser.pressEmergencyButton(currentUser)){
            DBserverListener.sendSystemDatatoMySQLServer(this);//send system data to server
            return false;
        }
        if(normalState == true){
            return true;//Date is normal, keep tracking~~
        }else {
        String gps = GPS.locateCurrentPosition();           //locate position
        wristBandGUI.displaMessage(gps);
            try{
                String situation = dangerDetermin.identify(mh.getBodyTemperature(),mh.getIdleTime(),mh.getShakingCount(),mh.getRoomtemperature());//identify situation
                
                String tmp = "Discriminate situation is "+situation;
                wristBandGUI.displaMessage(tmp);
                    if(situation.equals("")){
                       throw (new identifyException());
                    }
                this.notifyRescueTeam(situation);//finish notify
                wristBandGUI.displaMessage("Notify sucessfully");
              }catch(identifyException e){
                  wristBandGUI.displaMessage(e.getMessage());
                  return false;
              }
        normalState  = false;           //return normalState is false
        }
        DBserverListener.sendSystemDatatoMySQLServer(this);//send system data
        return normalState;
    }
    //use for auto
    public void notifyRescueTeam(String situation){
        wristBandGUI.displaMessage("Ready to notify");
            if(situation.equals("drowning")){                           //select which notify rescue team
            while(sucessfullornot == false){
                String flag = "waterguard";
                sucessfullornot = rescueTeam.notifyEmergency(flag);
            }
        }
        else if(situation.equals("firing")){
            while(sucessfullornot == false){
             String flag = "firefighter";
                sucessfullornot = rescueTeam.notifyEmergency(flag);
            }
        }
        else if(situation.equals("moutainAccident")){
            while(sucessfullornot == false){
             String flag = "moutainguard";
                sucessfullornot = rescueTeam.notifyEmergency(flag);
            }
        }
    }
    //overolading notifyRescueTeam use for manual
    public void notifyRescueTeam(user currentUser){
        wristBandGUI.displaMessage("Ready to notify "+currentUser.getEmergencyContactPerson()+" person");
            while(sucessfullornot == false){
                sucessfullornot = rescueTeam.notifyEmergency(currentUser);
            }
        wristBandGUI.displaMessage("Notify sucessfully");
    }

    public medicalHistory getMh() {
        return mh;
    }

    public int isSucessfullornot() {
        if(sucessfullornot == true){
            return 1;
        }
        return 0;
    }

    public user getCurrentUser() {
        return currentUser;
    }
    

}
