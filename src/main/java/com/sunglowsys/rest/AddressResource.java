package com.sunglowsys.rest;

import com.sunglowsys.domain.Address;
import com.sunglowsys.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

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
}
