package AmazonLLD.Clients;

import AmazonLLD.Models.IDepositPackage;

public class DeliveryClient implements IDeliveryClient{
    String id;

    private final IDepositPackage depositPackage;

    public DeliveryClient(String id, IDepositPackage depositPackage) {
        this.depositPackage = depositPackage;
        this.id = id;
    }

    @Override
    public void depositPackage(int lockerId, String userid, String otp) {
        depositPackage.depositPackage(lockerId,otp, userid);
    }
}
