package com.ginkei.dsvendas.dto

import com.ginkei.dsvendas.entities.Seller
import java.io.Serializable

data class SaleSuccessDTO(
    val sellerName: String?,
    val visited: Long?,
    val deals: Long?
): Serializable{
    constructor(seller: Seller, visited: Long?, deals: Long?) : this(seller.name, visited, deals)
}