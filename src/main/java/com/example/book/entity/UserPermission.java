package com.example.book.entity;

import org.apache.ibatis.type.Alias;

@Alias("userMiss")
public class UserPermission {
    private Integer id;
    private User cardNumber;
    private Permission permissionId;

    public UserPermission() {
    }

    public UserPermission(Integer id, User cardNumber, Permission permissionId) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.permissionId = permissionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(User cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Permission getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Permission permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "UserPermission{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", permissionId=" + permissionId +
                '}';
    }
}
