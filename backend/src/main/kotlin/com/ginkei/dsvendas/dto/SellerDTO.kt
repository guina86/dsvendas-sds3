package com.ginkei.dsvendas.dto

import com.ginkei.dsvendas.entities.Seller
import java.io.Serializable

data class SellerDTO(
    val id: Long?,
    val name: String?
) : Serializable {
    constructor(seller: Seller) : this(seller.id, seller.name)
}