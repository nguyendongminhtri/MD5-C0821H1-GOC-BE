package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nameCategory"
        })
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameCategory;
    private String avatarCategory;
    @ManyToOne
    User user;

    public Category() {
    }

    public Category(Long id, String nameCategory, String avatarCategory, User user) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.avatarCategory = avatarCategory;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getAvatarCategory() {
        return avatarCategory;
    }

    public void setAvatarCategory(String avatarCategory) {
        this.avatarCategory = avatarCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
