package com.ginkei.dsvendas.repositories

import com.ginkei.dsvendas.dto.SaleSuccessDTO
import com.ginkei.dsvendas.dto.SaleSumDTO
import com.ginkei.dsvendas.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SaleRepository: JpaRepository<Sale, Long> {
    @Query("SELECT new com.ginkei.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) FROM Sale as obj GROUP BY obj.seller")
    fun amountGroupedBySeller() : List<SaleSumDTO>

    @Query("SELECT new com.ginkei.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) FROM Sale as obj GROUP BY obj.seller")
    fun successGroupedBySeller() : List<SaleSuccessDTO>
}
