package AmazonLLD.Models;

public interface IDepositPackage {
    void depositPackage(int lockerId, String otp, String userId);
}
