package com.keyin.hynes.braden.sqlboot.interfaces.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.keyin.hynes.braden.sqlboot.entities.Realtor;
@Repository
public interface RealtorRepository extends JpaRepository<Realtor, UUID> {}