package com.example.evaluacion.models;

public class UserMapping {
    private IUser user;

    public UserMapping(IUser user) {
        this.user = user;
    }

    public UserEntity toEntity() {
        return new UserEntity(
                this.user.getId(),
                this.user.getFirstName(),
                this.user.getLastName(),
                this.user.getUsername(),
                this.user.getBirthday(),
                this.user.getPassword(),
                this.user.getHeight()
        );
    }

    public User toBase() {
        User userBase = new User(
                this.user.getFirstName(),
                this.user.getLastName(),
                this.user.getUsername(),
                this.user.getBirthday(),
                this.user.getHeight()
        );
        userBase.setPassword(this.user.getPassword());
        userBase.setId(this.user.getId());
        return userBase;
    }
}
