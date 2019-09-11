package com.jf.jf_smartsite.security.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="sys_user")
public class User implements Serializable {
    @Column(name="login_name")
    private String username;
    private String password;

}
