package AmazonLLD;

import AmazonLLD.Clients.DeliveryClient;
import AmazonLLD.Clients.UserClient;
import AmazonLLD.Models.LockerStore;
import AmazonLLD.Models.UpdateTime;

public class AmazonLLDExample {
    public static void main(String[] args) {
        UpdateTime updateTime = new UpdateTime();
        LockerStore lockerStore = new LockerStore(5, updateTime);
        System.out.println(lockerStore.getVacantLockers());

        UserClient userClient = new UserClient("user1",lockerStore);
        UserClient userClient2 = new UserClient("user2",lockerStore);
        UserClient userClient3 = new UserClient("user3",lockerStore);

        DeliveryClient deliveryClient = new DeliveryClient("delivery1", lockerStore);

        lockerStore.assignLockerToUser(0, userClient);
        lockerStore.assignLockerToUser(1, userClient2);
        lockerStore.assignLockerToUser(2, userClient3);

        deliveryClient.depositPackage(0, userClient.getId(), "123");
        deliveryClient.depositPackage(1, userClient2.getId(), "123");
        deliveryClient.depositPackage(2, userClient3.getId(), "123");

        // wrong otp
        userClient.collectPackage(userClient.getId(), 0, "456");
        System.out.println(lockerStore.getVacantLockers());

        userClient.collectPackage(userClient.getId(), 0, "123");
        System.out.println(lockerStore.getVacantLockers());

        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();
        updateTime.incrementDay();

        System.out.println(lockerStore.getVacantLockers());


    }
}
