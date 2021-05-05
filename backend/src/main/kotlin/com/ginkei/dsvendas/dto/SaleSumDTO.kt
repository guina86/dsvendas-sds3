package com.ginkei.dsvendas.dto

import com.ginkei.dsvendas.entities.Seller
import java.io.Serializable

data class SaleSumDTO(
    val sellerName: String?,
    val sum: Double?
): Serializable{
    constructor(seller: Seller, sum: Double) : this(seller.name, sum)
}