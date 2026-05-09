package com.home.SplitwiseEasyToUnderstand;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {

    private String groupId;
    private String groupName;
    private User createdBy;
    private List<User> memebers;

    public Group(String groupName, User createdBy, List<User> memebers) {
        this.groupId = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.createdBy = createdBy;
        this.memebers = memebers;
    }

    public void addUser(User user){
        if(memebers.contains(user)) return; //invalid case
        memebers.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getMemebers() {
        return memebers;
    }
}
