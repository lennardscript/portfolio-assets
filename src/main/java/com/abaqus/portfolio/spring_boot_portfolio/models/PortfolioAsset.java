package com.abaqus.portfolio.spring_boot_portfolio.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolio_assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioAsset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "portfolio_id", nullable = false)
  private Portfolio portfolio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "asset_id", nullable = false)
  private Asset asset;

  private BigDecimal initialWeight;
  private BigDecimal initialQuantity;
  private BigDecimal currentQuantity;
  private LocalDate initialDate;
}
