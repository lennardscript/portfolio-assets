package com.abaqus.portfolio.spring_boot_portfolio.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "asset_prices", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "asset_id", "date" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssetPrice {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "asset_id", nullable = false)
  private Asset asset;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false, precision = 19, scale = 4)
  private BigDecimal price;
}
