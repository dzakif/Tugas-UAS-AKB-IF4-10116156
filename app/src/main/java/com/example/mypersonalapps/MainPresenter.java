package com.example.mypersonalapps;

public interface MainPresenter {
    void save(FriendModel friend);
    void update(FriendModel friend);
    void delete(FriendModel friend);
    void load();
}
