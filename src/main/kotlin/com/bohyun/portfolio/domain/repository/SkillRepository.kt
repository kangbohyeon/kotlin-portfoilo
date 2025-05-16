package com.bohyun.portfolio.domain.repository

import com.bohyun.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository: JpaRepository<Skill, Long> {
}