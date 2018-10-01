package com.udemy.entity;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "role", "username" }))
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(unique = true, nullable = false)
	private Integer userRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User user;

	@Column(nullable = false, length = 45)
	private String role;

	/**
	 * 
	 */
	public UserRole() {
		super();
	}

	/**
	 * @param user
	 * @param role
	 */
	public UserRole(User user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
