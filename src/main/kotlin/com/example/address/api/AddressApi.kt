package com.example.address.api

import com.example.address.entity.AddressEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/address")
interface AddressApi {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<AddressEntity>

}