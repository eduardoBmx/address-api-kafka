package com.example.address.repository

import com.example.address.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<AddressEntity, String> {
}