package com.abaqus.portfolio.spring_boot_portfolio.repositories;

import com.abaqus.portfolio.spring_boot_portfolio.models.Asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
  Optional<Asset> findByAssetName(String assetName);
}
