package com.ginkei.dsvendas.repositories

import com.ginkei.dsvendas.entities.Sale
import com.ginkei.dsvendas.entities.Seller
import org.springframework.data.jpa.repository.JpaRepository

interface SaleRepository: JpaRepository<Sale, Long> {



}