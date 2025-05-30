package com.bohyun.portfolio.domain

import com.bohyun.portfolio.domain.constant.SkillType
import com.bohyun.portfolio.domain.entity.*
import com.bohyun.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
) {
    @PostConstruct
    fun initializeData() {

        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(

            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2022, 6, 17),
                isActive = true
            ),
            Achievement(
                title = "SQLD",
                description = "데이터베이스, SQL 등",
                host = "한국데이터산업진흥원",
                achievedDate = LocalDate.of(2021, 12, 17),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.", isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/kangbohyeon", isActive = true),
            Link(name = "Linkedin", content = "linkedin.com", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "세종대학교",
            description = "수학통계학부 수학과",
            startYear = 2017,
            startMonth = 3,
            endYear = 2022,
            endMonth = 2,
            isActive = true
        )

        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 3.0/4.5", isActive = true),
            )
        )

        val experience2 = Experience(
            title = "세종텔레콤",
            description = "보이스기술팀 백엔드 개발자",
            startYear = 2022,
            endYear = null,
            startMonth = 11,
            endMonth = null,
            isActive = true
        )

        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "성능 최적화와 안정성을 위한 시스템 개선 프로젝트", isActive = true),
                ExperienceDetail(content = "통화 시스템 개선 프로젝트", isActive = true)
            )
        )

        experienceRepository.saveAll(mutableListOf(experience2, experience1));

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val javaScript = Skill(name = "Java Script", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val oracle = Skill(name = "Oracle", type = SkillType.DATABASE.name, isActive = true)
        val mysql = Skill(name = "Mysql", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val grafana = Skill(name = "Grafana", type = SkillType.TOOL.name, isActive = true)
        val prometheus = Skill(name = "Prometheus", type = SkillType.TOOL.name, isActive = true)

        skillRepository.saveAll(
            mutableListOf(
                java,
                kotlin,
                javaScript,
                spring,
                oracle,
                mysql,
                redis,
                grafana,
                prometheus
            )
        )

        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "",
            startYear = 2017,
            startMonth = 3,
            endYear = 2022,
            endMonth = 2,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "구글 맴스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
                ProjectDetail(content = "redis 적용하여 인기 게시글의 조회 속도 1.5초 -> 0.5초로 개선", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis),
            )
        )
        projectRepository.save(project1);
    }
}