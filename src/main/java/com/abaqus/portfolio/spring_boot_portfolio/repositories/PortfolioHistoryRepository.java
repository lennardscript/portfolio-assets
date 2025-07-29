package com.abaqus.portfolio.spring_boot_portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abaqus.portfolio.spring_boot_portfolio.models.Portfolio;
import com.abaqus.portfolio.spring_boot_portfolio.models.PortfolioHistory;

import java.util.List;

@Repository
public interface PortfolioHistoryRepository extends JpaRepository<PortfolioHistory, Long> {
  List<PortfolioHistory> findByPortfolioAndDateBetweenOrderByDateAsc(Portfolio portfolio);
}
