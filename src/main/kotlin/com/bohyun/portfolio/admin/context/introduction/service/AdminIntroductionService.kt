package com.bohyun.portfolio.admin.context.introduction.service

import com.bohyun.portfolio.admin.data.TableDTO
import com.bohyun.portfolio.domain.entity.Introduction
import com.bohyun.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}