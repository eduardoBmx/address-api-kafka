package com.example.address.service

import com.example.address.entity.AddressEntity
import com.example.address.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
    private val addressRepository: AddressRepository
): AddressService {
    override fun getAll(): List<AddressEntity> {
        return addressRepository.findAll()
    }

}