package com.bohyun.portfolio.presentation.service

import com.bohyun.portfolio.domain.entity.Introduction
import com.bohyun.portfolio.domain.entity.Link
import com.bohyun.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroductions() {
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }

        val activeIntroductions = introductions.filter { introduction -> introduction.isActive }

        Mockito.`when`(presentationRepository.getActiveIntroductions())
            .thenReturn(activeIntroductions)

        //when
        val introductionDTOs = presentationService.getIntroductions()

        //then
        Assertions.assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLink() {

        //given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLinks = links.filter { link -> link.isActive }

        Mockito.`when`(presentationRepository.getActiveLinks())
            .thenReturn(activeLinks)
        //when
        val linkDTOs = presentationService.getLinks()

        //then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }
        assertThat(linkDTOs).hasSize(expectedSize)
        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}