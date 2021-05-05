package com.ginkei.dsvendas.controllers

import com.ginkei.dsvendas.dto.SellerDTO
import com.ginkei.dsvendas.services.SellerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/sellers"])
class SellerController {

    @Autowired
    lateinit var service: SellerService

    @GetMapping
    fun findAll() : ResponseEntity<List<SellerDTO>> {
        val list = service.findAll()
        return ResponseEntity.ok(list)
    }


}