package com.sunglowsys.rest;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressResource {

    private final Logger log = LoggerFactory.getLogger (AddressResource.class);

    private final AddressService  addressService ;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping("/address")
    public ResponseEntity<Address> create(@RequestBody Address address) throws URISyntaxException {
        log.debug ("request to save address successfully{}:",address);
        Address result = addressService.save (address);
        return ResponseEntity
                .created (new URI ("/api/address"+result.getId ()))
                .body (result);
    }
    @PutMapping("/address")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        log.debug ("request to update program successfully{}:",address);
        Address result = addressService.update (address);
        return ResponseEntity
                .ok ()
                .body (result);
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        log.debug ("request program find successfully");
        List<Address> result = addressService.findAll ();
        return ResponseEntity
                .ok ()
                .body (result);
    }
    @GetMapping
    public ResponseEntity<Address> findByIdAddress(@PathVariable Long id){
        log.debug ("request program findId successfully{}:",id);
        Address result = addressService.findByID (id);
        return ResponseEntity
                .ok ()
                .body (result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        log.debug ("request program delete successfully:{}",id);
          addressService.delete (id);
          return ResponseEntity.ok ().build ();
    }
}
