package com.ginkei.dsvendas.controllers

import com.ginkei.dsvendas.dto.SaleDTO
import com.ginkei.dsvendas.dto.SaleSuccessDTO
import com.ginkei.dsvendas.dto.SaleSumDTO
import com.ginkei.dsvendas.dto.SellerDTO
import com.ginkei.dsvendas.services.SaleService
import com.ginkei.dsvendas.services.SellerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/sales"])
class SaleController {

    @Autowired
    lateinit var service: SaleService

    @GetMapping
    fun findAll(pageable: Pageable) : ResponseEntity<Page<SaleDTO>> {
        val list = service.findAll(pageable)
        return ResponseEntity.ok(list)
    }

    @GetMapping(value = ["/amount-by-seller"])
    fun amountGrouperBySeller() : ResponseEntity<List<SaleSumDTO>> {
        val list = service.amountGroupedBySeller()
        return ResponseEntity.ok(list)
    }

    @GetMapping(value = ["/success-by-seller"])
    fun successGrouperBySeller() : ResponseEntity<List<SaleSuccessDTO>> {
        val list = service.successGroupedBySeller()
        return ResponseEntity.ok(list)
    }

}