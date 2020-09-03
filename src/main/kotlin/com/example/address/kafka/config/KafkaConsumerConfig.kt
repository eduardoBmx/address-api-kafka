package com.example.address.kafka.config

import com.example.address.kafka.entity.Address
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig {

    @Value(value = "\${kafka.bootstrapAddress}")
    lateinit var kafkaAddress: String

    @Value(value = "\${kafka.groupId}")
    lateinit var kafkaGroupId: String

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Address> {
        val deserializer = JsonDeserializer<Address>(
            Address::class.java, false
        )

        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = kafkaGroupId
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = deserializer
        return DefaultKafkaConsumerFactory<String, Address>(
            props,
            StringDeserializer(),
            deserializer
        )
    }

    @Bean
    fun addressKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Address> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, Address> =
            ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory()
        return factory
    }

}