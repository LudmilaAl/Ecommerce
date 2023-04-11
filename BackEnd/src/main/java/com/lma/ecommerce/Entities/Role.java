package com.lma.ecommerce.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum roleName;

    //Constructors

    public Role() {

    }

    //Getters and Setters

    public Role(RoleEnum roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }
}
