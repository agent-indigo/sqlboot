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
import com.keyin.hynes.braden.sqlboot.entities.Realtor;
import com.keyin.hynes.braden.sqlboot.interfaces.repositories.RealtorRepository;
@CrossOrigin
@RequestMapping("/realtors")
@RestController
public final class RealtorRestController {
  private final RealtorRepository realtorRepository;
  private Realtor target;
  public RealtorRestController(@Autowired final RealtorRepository realtorRepository) {
    this.realtorRepository = realtorRepository;
  }
  @GetMapping
  public List<Realtor> getAll() {
    return realtorRepository.findAll();
  }
  @GetMapping("/{id}")
  public Realtor getOne(@PathVariable("id") final UUID id) {
    return realtorRepository.findById(id).get();
  }
  @PostMapping
  public Realtor add(@RequestBody final Realtor realtor) {
    return realtorRepository.save(realtor);
  }
  @PatchMapping("/{id}")
  public Realtor edit(
    @PathVariable("id") final UUID id,
    @RequestBody final Realtor changes
  ) {
    target = realtorRepository.findById(id).get();
    if (changes.getFirst_name() != null) target.setFirst_name(changes.getFirst_name());
    if (changes.getLast_name() != null) target.setLast_name(changes.getLast_name());
    if (changes.getDescription() != null) target.setDescription(changes.getDescription());
    if (changes.getPhoto() != null) target.setPhoto(changes.getPhoto());
    if (changes.getEmail_address() != null) target.setEmail_address(changes.getEmail_address());
    if (changes.getPhone_number() != null) target.setPhone_number(changes.getPhone_number());
    if (changes.getIs_mvp() != null) target.setIs_mvp(changes.getIs_mvp());
    return realtorRepository.save(target);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") final UUID id) {
    realtorRepository.deleteById(id);
  }
}