package com.bohyun.portfolio.domain.repository

import com.bohyun.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExperienceRepository: JpaRepository<Experience, Long> {
    @Query("select e from Experience e left join fetch e.details where e.isActive =:isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}