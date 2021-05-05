package com.ginkei.dsvendas.services

import com.ginkei.dsvendas.dto.SaleDTO
import com.ginkei.dsvendas.repositories.SaleRepository
import com.ginkei.dsvendas.repositories.SellerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SaleService {

    @Autowired
    lateinit var repository: SaleRepository

    @Autowired
    lateinit var sellerRepository: SellerRepository

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<SaleDTO> {
        sellerRepository.findAll()
        return repository.findAll(pageable).map { sale -> SaleDTO(sale) }
    }
}