package com.bohyun.portfolio.domain.repository

import com.bohyun.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>
}