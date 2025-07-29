package com.abaqus.portfolio.spring_boot_portfolio.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "assets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String assetName;
}
