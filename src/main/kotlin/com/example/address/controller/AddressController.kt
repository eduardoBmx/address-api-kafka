package com.example.address.controller

import com.example.address.api.AddressApi
import com.example.address.entity.AddressEntity
import com.example.address.service.AddressService
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressController(
    private val addressService: AddressService
): AddressApi{
    override fun getAll(): List<AddressEntity> {
        return addressService.getAll()
    }
}