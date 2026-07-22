package com.keyin.hynes.braden.sqlboot.controllers;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keyin.hynes.braden.sqlboot.entities.Listing;
import com.keyin.hynes.braden.sqlboot.interfaces.RestCrud;
import com.keyin.hynes.braden.sqlboot.interfaces.repositories.ListingRepository;
@CrossOrigin
@RequestMapping("/listings")
@RestController
public final class ListingRestController implements RestCrud<Listing, UUID> {
  private final ListingRepository listingRepository;
  private Listing target;
  public ListingRestController(@Autowired final ListingRepository listingRepository) {
    this.listingRepository = listingRepository;
  }
  @GetMapping
  @Override
  public List<Listing> getAll() {
    return listingRepository.findAll();
  }
  @GetMapping("/{id}")
  @Override
  public Listing getOne(@PathVariable("id") final UUID id) {
    return listingRepository.findById(id).get();
  }
  @Override
  @PostMapping
  public Listing add(@RequestBody final Listing post) {
    return listingRepository.save(post);
  }
  @Override
  @PatchMapping("/{id}")
  public Listing edit(
    @PathVariable("id") final UUID id,
    @RequestBody final Listing changes
  ) {
    target = listingRepository.findById(id).get();
    if (changes.getTitle() != null) target.setTitle(changes.getTitle());
    if (changes.getAddress() != null) target.setAddress(changes.getAddress());
    if (changes.getCity() != null) target.setCity(changes.getCity());
    if (changes.getState() != null) target.setState(changes.getState());
    if (changes.getZipcode() != null) target.setZipcode(changes.getZipcode());
    if (changes.getDescription() != null) target.setDescription(changes.getDescription());
    if (changes.getPrice() != null) target.setPrice(changes.getPrice());
    if (changes.getBedrooms() != null) target.setBedrooms(changes.getBedrooms());
    if (changes.getBathrooms() != null) target.setBathrooms(changes.getBathrooms());
    if (changes.getGarage() != null) target.setGarage(changes.getGarage());
    if (changes.getSqft() != null) target.setSqft(changes.getSqft());
    if (changes.getLot_size() != null) target.setLot_size(changes.getLot_size());
    if (changes.getExterior_photo() != null) target.setExterior_photo(changes.getExterior_photo());
    if (changes.getInterior_photo_1() != null) target.setInterior_photo_1(changes.getInterior_photo_1());
    if (changes.getInterior_photo_2() != null) target.setInterior_photo_2(changes.getInterior_photo_2());
    if (changes.getInterior_photo_3() != null) target.setInterior_photo_3(changes.getInterior_photo_3());
    if (changes.getInterior_photo_4() != null) target.setInterior_photo_4(changes.getInterior_photo_4());
    if (changes.getInterior_photo_5() != null) target.setInterior_photo_5(changes.getInterior_photo_5());
    if (changes.getInterior_photo_6() != null) target.setInterior_photo_6(changes.getInterior_photo_6());
    if (changes.getIs_published() != null) target.setIs_published(changes.getIs_published());
    if (changes.getRealtor() != null) target.setRealtor(changes.getRealtor());
    return listingRepository.save(target);
  }
  @DeleteMapping("/{id}")
  @Override
  public void delete(@PathVariable("id") final UUID id) {
    listingRepository.deleteById(id);
  }
}