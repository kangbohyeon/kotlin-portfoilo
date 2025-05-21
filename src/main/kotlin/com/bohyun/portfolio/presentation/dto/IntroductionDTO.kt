package com.bohyun.portfolio.presentation.dto

import com.bohyun.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(introduction.content)
}