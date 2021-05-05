package com.ginkei.dsvendas.services

import com.ginkei.dsvendas.dto.SellerDTO
import com.ginkei.dsvendas.repositories.SellerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SellerService {

    @Autowired
    lateinit var repository: SellerRepository

    fun findAll(): List<SellerDTO> = repository.findAll().map { seller -> SellerDTO(seller) }
}