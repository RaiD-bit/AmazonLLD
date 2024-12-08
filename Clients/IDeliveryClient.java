package AmazonLLD.Clients;

public interface IDeliveryClient {
    void depositPackage(int lockerId, String userid, String otp);
}
