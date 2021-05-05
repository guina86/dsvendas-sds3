package com.ginkei.dsvendas.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_sales")
open class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open var visited: Int? = null
    open var deals: Int? = null
    open var amount: Double? = null
    open var date: LocalDate? = null

    @ManyToOne
    @JoinColumn(name = "seller_id")
    open var seller: Seller? = null
}