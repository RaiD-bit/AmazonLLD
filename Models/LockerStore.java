package AmazonLLD.Models;

import AmazonLLD.Clients.UserClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LockerStore implements ILockerStore, ICollectPackage, IDepositPackage{
    List<Locker> lockers;

    private final UpdateTime updateTime;

    public LockerStore(int numLockers, UpdateTime updateTime) {
        this.lockers = new ArrayList<>();
        this.updateTime = updateTime;
        for(int i = 0; i<=numLockers; i++){
            lockers.add(new Locker(true, i, -1));
            this.updateTime.addTimers(lockers.get(lockers.size()-1));
        }


    }

    @Override
    public List<Locker> getVacantLockers() {
        return this.lockers.stream().filter(locker -> locker.isVacant).toList();
    }

    @Override
    public void assignLockerToUser(int id, UserClient user) {
        Locker selectedLocker = lockers.stream().filter(locker -> locker.isVacant)
                .findFirst().orElse(null);
        if(selectedLocker == null){
            System.out.println("This locker cant be assigned");
        }else{
            selectedLocker.setVacant(false);
            selectedLocker.setAssignedUserid(user.getId());
        }
    }

    @Override
    public void collectPackage(int lockerId, String otp, String userid) {
        Locker selectedLocker = lockers.stream().filter(locker -> locker.getId() == lockerId && locker.getOtp().equals(otp))
                .findFirst().orElse(null);
        if(Objects.nonNull(selectedLocker)){
            // we can access the locker
            System.out.println("Package collected by user " + userid + "from lockerid " + lockerId);
            selectedLocker.setVacant(true);
            selectedLocker.setTimer(-1);
        }else{
            System.out.println("Invalid otp or invalid locker id");
        }

    }

    @Override
    public void depositPackage(int lockerId, String otp, String userId) {
        Locker selectedLocker = lockers.stream().filter(locker -> locker.getId() == lockerId).findFirst().orElse(null);
        if(Objects.nonNull(selectedLocker)){
            selectedLocker.setVacant(false);
            selectedLocker.setTimer(7);
            selectedLocker.setOtp(otp);
            System.out.println("Package deposited for user " + userId + "at lockerid " + lockerId);
        }
    }
}
