package com.onix.foundation.data.local

import com.onix.foundation.domain.model.Contact
import kotlinx.coroutines.delay
import kotlin.random.Random

internal class ContactsFakeDataSource : ContactsLocalDataSource {
    private val colors = listOf(
        0xFFE0BBE4,
        0xFFD291BC,
        0xFFFEC8D8,
        0xFFFFDFD3,
        0xFFFFEFAB,
        0xFFFFD055,
        0xFF313A5C,
        0xFF365F73,
        0xFFEBEBEB,
        0xFFC8D9C1,
        0xFFA1C7BD
    )

    private val names = listOf(
        "Vladislav",
        "Viktor",
        "Sergey",
        "Olha",
        "Vadim",
        "Ruslana",
        "Alex",
        "Anna",
        "Ivan",
        "Ihor",
        "Anton",
        "Ksenia",
        "Inna"
    )

    private val list = List(100) { i ->
        Contact(
            id = "$i",
            name = names.random(),
            phone = "+38-0${Random.nextInt(100000000, 999999999)}",
            imageUrl = "",
            imageColor = colors.random()
        )
    }

    override fun getAll(): List<Contact> {
        return list
    }

    override suspend fun getByPage(page: Int): List<Contact> {

        delay(1000)

        val itemsPerPage = 10
        val loadedCount = page * itemsPerPage

        return list.subList(0 + loadedCount, itemsPerPage + loadedCount)
    }

    override fun getById(contactId: String): Contact {
        return list.first { it.id == contactId }
    }
}