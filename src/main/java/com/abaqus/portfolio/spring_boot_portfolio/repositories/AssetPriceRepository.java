package com.abaqus.portfolio.spring_boot_portfolio.repositories;

import com.abaqus.portfolio.spring_boot_portfolio.models.Asset;
import com.abaqus.portfolio.spring_boot_portfolio.models.AssetPrice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssetPriceRepository extends JpaRepository<AssetPrice, Long> {
  Optional<AssetPrice> findByAssetAndDate(Asset asset, LocalDate date);

  List<AssetPrice> findByAssetInAndDataBetween(List<Asset> assets, LocalDate starDate, LocalDate endDate);

  List<AssetPrice> findByDate(LocalDate date);

}
