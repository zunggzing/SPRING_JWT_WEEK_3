/**
 * 
 */
package com.spring_boot_jwt_entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 48 - Tran Trung Vinh - 18079461
 *
 */
@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends BaseEntity{
	private String username;
	private String password; 
	 @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")},
	            inverseJoinColumns = {@JoinColumn(name = "role_id")})
	   private Set<Role> roles = new HashSet<>();
}