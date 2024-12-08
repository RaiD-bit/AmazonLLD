package AmazonLLD.Models;

import AmazonLLD.Clients.UserClient;

import java.util.List;

public interface ILockerStore {
    List<Locker> getVacantLockers();

    void assignLockerToUser(int id, UserClient userid);

}
