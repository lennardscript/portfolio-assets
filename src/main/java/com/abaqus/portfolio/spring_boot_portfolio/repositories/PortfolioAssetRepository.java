package com.abaqus.portfolio.spring_boot_portfolio.repositories;

import com.abaqus.portfolio.spring_boot_portfolio.models.Asset;
import com.abaqus.portfolio.spring_boot_portfolio.models.Portfolio;
import com.abaqus.portfolio.spring_boot_portfolio.models.PortfolioAsset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioAssetRepository extends JpaRepository<PortfolioAsset, Long> {
  List<PortfolioAsset> findByPortfolio(Portfolio portfolio);

  Optional<PortfolioAsset> findByPortfolioAndAsset(Portfolio portfolio, Asset asset);
}
