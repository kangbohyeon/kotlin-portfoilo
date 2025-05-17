package com.bohyun.portfolio.domain.repository

import com.bohyun.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository: JpaRepository<Link, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Link>
}