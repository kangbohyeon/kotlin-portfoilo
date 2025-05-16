package com.bohyun.portfolio.domain.repository

import org.springframework.data.jpa.repository.JpaRepository

interface Project: JpaRepository<Project, Long> {
}