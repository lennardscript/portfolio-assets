package com.abaqus.portfolio.spring_boot_portfolio.repositories;

import com.abaqus.portfolio.spring_boot_portfolio.models.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
