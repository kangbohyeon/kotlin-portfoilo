package com.bohyun.portfolio.presentation.dto

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: IntroductionDTO) : this(introduction.content)
}