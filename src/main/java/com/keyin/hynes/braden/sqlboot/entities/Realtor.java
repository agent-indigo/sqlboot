package com.keyin.hynes.braden.sqlboot.entities;
import com.keyin.hynes.braden.sqlboot.abstracts.EntityBase;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "realtors")
@ToString(callSuper = true)
public final class Realtor extends EntityBase {
  @Nonnull
  private String first_name;
  @Nonnull
  private String last_name;
  @Nonnull
  private String photo;
  private String description;
  @Nonnull
  private String email_address;
  @Nonnull
  private String phone_number;
  @Nonnull
  private Boolean is_mvp;
}