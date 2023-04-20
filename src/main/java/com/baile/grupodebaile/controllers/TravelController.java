package com.baile.grupodebaile.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.baile.grupodebaile.models.Travel;
import com.baile.grupodebaile.services.TravelService;

@RestController
@RequestMapping(path = "/api")

public class TravelController {

    private TravelService service;

    public TravelController(TravelService service) {
        this.service = service;
    }

    @PostMapping(path = "/travels")
    public Travel store(@RequestBody Travel travel) {
        return service.save(travel);

    }

    // @PostMapping("/travels/{id}/imagestravel")
    // public void storeImageTravel(@RequestParam("image") MultipartFile
    // multipartFile, @PathVariable Long id)
    // throws IOException {
    // service.saveImageTravel(multipartFile, id);
    // }

    // @DeleteMapping("/travels/{idtravel}/imagestravel")
    // public void deleteImageTravel(@PathVariable Long idtravel) throws IOException
    // {
    // // service.deleteImageTravel(idtravel);
    // }

    @GetMapping("/travels")
    public List<Travel> listAll() {
        return service.listAll();
    }

    @GetMapping("/travels/{id}")
    public Travel listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

    @DeleteMapping("/travels/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/travels/{id}")
    public Travel update(@PathVariable Long id, @RequestBody Travel travelNew) {
        return service.update(id, travelNew);
    }
}
