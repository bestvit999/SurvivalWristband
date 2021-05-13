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
public class emergencyContactPersonServer implements RescueTeamServer{
    private  String Name = "default";

    public void setName(String Name) {
        this.Name = Name;
    }
    //get a new emergencyContactPersonServer
    public static emergencyContactPersonServer getemergencyContactPersonServer(){
        emergencyContactPersonServer ecps = new emergencyContactPersonServer();
        return ecps;
    }
    //overloading checkMsg
    public boolean checkMsg(user currentUser){
        boolean confirm = true;         //select by server
        if(confirm){
            String msg = currentUser.getEmergencyContactPerson() + " confirm";
            wristBandGUI.displaMessage(msg);
            return true;
        }
        else{
            String msg = currentUser.getEmergencyContactPerson() + " doesn't confirm";
            wristBandGUI.displaMessage(msg);
            return false;
        }
    }
    @Override
    public boolean checkMsg(){
            return false;
    }

    
}
