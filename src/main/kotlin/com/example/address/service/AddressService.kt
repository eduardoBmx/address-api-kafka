package com.example.address.service

import com.example.address.entity.AddressEntity

interface AddressService {
    fun getAll(): List<AddressEntity>
}