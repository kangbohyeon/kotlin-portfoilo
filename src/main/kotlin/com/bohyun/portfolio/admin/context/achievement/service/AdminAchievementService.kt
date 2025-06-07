package com.bohyun.portfolio.admin.context.achievement.service

import com.bohyun.portfolio.admin.data.TableDTO
import com.bohyun.portfolio.domain.entity.Achievement
import com.bohyun.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {
    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
}