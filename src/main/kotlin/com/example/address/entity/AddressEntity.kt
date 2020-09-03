package com.example.address.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class AddressEntity(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val city: String,

    val district: String,

    val state: String,

    val number: String,

    val customerId: String
)