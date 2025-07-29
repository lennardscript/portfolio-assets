package com.abaqus.portfolio.spring_boot_portfolio.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "portfolio_history", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "portfolio_id", "date" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "portfolio_id", nullable = false)
  private Portfolio portfolio;

  @Column(nullable = false)
  private LocalDate date;

  @Column(nullable = false, precision = 19, scale = 4)
  private BigDecimal totalValue;

}
