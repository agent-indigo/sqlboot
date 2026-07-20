package com.keyin.hynes.braden.sqlboot.interfaces.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.keyin.hynes.braden.sqlboot.entities.Listing;
@Repository
public interface ListingRepository extends JpaRepository<Listing, UUID> {}