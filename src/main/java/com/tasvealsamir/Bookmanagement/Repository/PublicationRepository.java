package com.tasvealsamir.Bookmanagement.Repository;

import com.tasvealsamir.Bookmanagement.Models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {
    @Query("SELECT MAX(p.id) FROM Publication p")
    Long findLastPublicationId();
    List<Publication> findByPublicationNameContainingIgnoreCase(String name);
    List<Publication> findByPublicationAddressContainingIgnoreCase(String address);
    List<Publication> findByPublicationWebsiteContainingIgnoreCase(String website);

}
