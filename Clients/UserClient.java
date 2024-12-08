package AmazonLLD.Clients;

import AmazonLLD.Models.ICollectPackage;

public class UserClient implements IUsers{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private final ICollectPackage collectPackage;

    public UserClient(String id, ICollectPackage collectPackage) {
        this.id = id;
        this.collectPackage = collectPackage;
    }

    @Override
    public void collectPackage(String userid, int lockerId, String otp) {
        collectPackage.collectPackage(lockerId,otp, userid);
    }
}
