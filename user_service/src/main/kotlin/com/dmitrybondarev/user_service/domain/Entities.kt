package com.dmitrybondarev.user_service.domain

import java.io.Serializable
import java.util.*
import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
		@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null,
		var email: String = "default",
		var firstName: String = "default",
		var lastName: String = "default",
		@Column(length = 60) var password: String = "default",

		@ElementCollection(fetch = FetchType.LAZY)
		@CollectionTable(name = "user_roles")
		var roles: List<String> = Arrays.asList("ROLE_USER")
) : Serializable