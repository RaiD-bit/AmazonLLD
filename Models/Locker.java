package AmazonLLD.Models;

public class Locker implements Timer{
    Boolean isVacant;

    int id;

    int timer;

    String assignedUserid;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    String otp;

    public String getAssignedUserid() {
        return assignedUserid;
    }

    public void setAssignedUserid(String assignedUserid) {
        this.assignedUserid = assignedUserid;
    }

    public Locker(Boolean isVacant, int id, int timer) {
        this.isVacant = isVacant;
        this.id = id;
        this.timer = timer;
        this.assignedUserid = null;
    }

    public Boolean getVacant() {
        return isVacant;
    }

    public void setVacant(Boolean vacant) {
        isVacant = vacant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "isVacant=" + isVacant +
                ", id=" + id +
                ", timer=" + timer +
                '}';
    }

    @Override
    public void updateTimeInLockers() {
        if(this.timer != -1){
            this.timer = this.timer - 1;
            if(!this.isVacant && this.timer == 0){
                System.out.println("Timer expired for lockerid: " + this.id + "for userid: " + this.assignedUserid
                        + ". So sending it back");
                this.isVacant = true;
                this.timer = -1;
            }
        }
    }
}
