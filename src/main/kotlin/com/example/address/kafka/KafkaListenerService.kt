package com.example.address.kafka

import com.example.address.entity.AddressEntity
import com.example.address.kafka.entity.Address
import com.example.address.repository.AddressRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaListenerService(
    private val addressRepository: AddressRepository
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(
        topics = ["\${kafka.topicName}"],
        groupId = "\${kafka.groupId}",
        containerFactory = "addressKafkaListenerContainerFactory"
    )
    fun listenerAddress(address: Address) {
        addressRepository.save(
            AddressEntity(
                city = address.city,
                customerId = address.customerId,
                number = address.number,
                district = address.district,
                state = address.state
            )
        )

        logger.info("Save this entity here!")
    }

}