package com.example.mypersonalapps;

import java.util.List;

public interface FriendView {
    void onLoad(List<FriendModel>friend);
    void onSave();
    void onDelete();
    void onUpdate();
}
