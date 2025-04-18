package com.tasvealsamir.Bookmanagement.Service;

import com.tasvealsamir.Bookmanagement.Models.Publication;

import com.tasvealsamir.Bookmanagement.Repository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {


    private PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<Publication> findAllPublications() {
        return publicationRepository.findAll();
    }

    public Publication getPublicationById(Long publicationId) {
        return publicationRepository.findById(publicationId).orElse(null);
    }

    public Publication savePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public void deletePublicationById(Long id) {
        publicationRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return publicationRepository.existsById(id);
    }

    public List<Publication> findPublicationsByNameContaining(String name) {
        return publicationRepository.findByPublicationNameContainingIgnoreCase(name);
    }

    public List<Publication> findPublicationsByWebsiteContaining(String website) {
        return publicationRepository.findByPublicationWebsiteContainingIgnoreCase(website);
    }

    public List<Publication> findPublicationsByAddress(String address) {
        return publicationRepository.findByPublicationAddressContainingIgnoreCase(address);
    }

    public Long getLastPublicationId() {
        Long lastid= publicationRepository.findLastPublicationId();
        if(lastid==null)
        {
            return 0L;
        }
        return lastid;
    }


}
