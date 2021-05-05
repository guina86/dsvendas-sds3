package com.ginkei.dsvendas.dto

import com.ginkei.dsvendas.entities.Sale
import java.time.LocalDate

data class SaleDTO(
    val id: Long?,
    val visited: Int?,
    val deals: Int?,
    val amount: Double?,
    val date: LocalDate?,
    val seller: SellerDTO?
) {

    constructor(entity: Sale) : this(
        id = entity.id,
        visited = entity.visited,
        deals = entity.deals,
        amount = entity.amount,
        date = entity.date,
        seller = entity.seller?.let { SellerDTO(it) }
    )

}