package com.rainy.login.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
  *
  * @ProjectName: login
  * @ClassName: UserAccount
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/22 21:27
  * @version v1.0
  *
  */
@ApiModel(value="com-rainy-login-domain-UserAccount")
@Data
@Table(name = "user_account")
public class UserAccount implements Serializable , UserDetails {
    @Id
    @Column(name = "UUID")
    @ApiModelProperty(value="")
    private Integer uuid;

    @Column(name = "username")
    @ApiModelProperty(value="")
    private String username;

    @Column(name = "`password`")
    @ApiModelProperty(value="")
    private String password;

    @Column(name = "`enable`")
    @ApiModelProperty(value="")
    private String enable;

    @Column(name = "`role`")
    @ApiModelProperty(value="")
    private String role;

    private static final long serialVersionUID = 1L;

    @Override
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("".equals(this.role)){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}