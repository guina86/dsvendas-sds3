package com.ginkei.dsvendas.entities

import javax.persistence.*

@Entity
@Table(name = "tb_sellers")
open class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null
    open var name: String? = null

    @OneToMany(mappedBy = "seller")
    open var sales: MutableList<Sale> = mutableListOf()

}