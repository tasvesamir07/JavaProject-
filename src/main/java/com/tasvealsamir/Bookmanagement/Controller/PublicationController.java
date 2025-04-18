package com.tasvealsamir.Bookmanagement.Controller;

import com.tasvealsamir.Bookmanagement.Models.Book;
import com.tasvealsamir.Bookmanagement.Models.Publication;
import com.tasvealsamir.Bookmanagement.Service.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/publication")
public class PublicationController {
   private PublicationService publicationService;


    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/")
    public List<Publication> getAllPublications() {
        return publicationService.findAllPublications();
    }

    @GetMapping("/{publicationId}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable Long publicationId) {
        Publication publication = publicationService.getPublicationById(publicationId);
        if(publication!=null)
        {
            return new ResponseEntity<>(publication,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<String> createPublication(@RequestBody Publication publication) {
        try {
            Long lastid = publicationService.getLastPublicationId();
            publication.setPublicationId(++lastid);
            publicationService.savePublication(publication);
            return new ResponseEntity<>("Publication Added Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }


@PutMapping("/{id}/")
    public ResponseEntity<String> updatePublication(@PathVariable Long id,
                                                    @RequestBody Publication publication)
    {
        boolean has = publicationService.existsById(id);
        if(!has)
        {
            return new ResponseEntity<>("Publication doesn't exists",HttpStatus.NOT_FOUND);
        }
        Long pId = publicationService.getPublicationById(id).getPublicationId();
        publication.setPublicationId(pId);
        publicationService.savePublication(publication);
        return new ResponseEntity<>("Publication Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}/")
   public ResponseEntity<String> deletePublication(@PathVariable Long id)
    {
        boolean has = publicationService.existsById(id);
        if(!has)
        {
            return new ResponseEntity<>("Publication Doesn't Exists",HttpStatus.NOT_FOUND);
        }
        publicationService.deletePublicationById(id);
        return new ResponseEntity<>("Publication Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Publication>> searchPublicationsByName(@RequestParam String name) {
        List<Publication> publications = publicationService.findPublicationsByNameContaining(name);
        if (publications.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(publications);
    }
}
