package com.group24.controllers;


import com.group24.models.Hostel;
import com.group24.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class HostelController {

    @Autowired
    private HostelRepository hostelRepository;

    @GetMapping("hostels")
    public List<Hostel> getAllHostel(){return hostelRepository.findAll();}

    @PostMapping("hostels")
    public Hostel createHostel(@RequestBody Hostel hostel){return hostelRepository.save(hostel);}

    @GetMapping("hostels/{id}")
    public ResponseEntity<Hostel> getHostelById(@PathVariable Long id){
        Hostel hostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not exist with id :" + id));
        return ResponseEntity.ok(hostel);
    }

    @PutMapping("/hostels/{id}")
    public ResponseEntity<Hostel> updateHostel(@PathVariable Long id, @RequestBody Hostel hostelDetails){

        Hostel hostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not exist with id :" + id));
        hostel.setName(hostelDetails.getName());
        hostel.setEmail(hostelDetails.getEmail());
        hostel.setPhoneNo(hostelDetails.getPhoneNo());
        hostel.setRoomNo(hostelDetails.getRoomNo());
        hostel.setTypeOfHostel(hostelDetails.getTypeOfHostel());
        hostel.setRegistrationNo(hostelDetails.getRegistrationNo());
        Hostel updatedHostel = hostelRepository.save(hostel);
        return ResponseEntity.ok(updatedHostel);
    }

    @DeleteMapping("/hostels/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHostel(@PathVariable Long id){
        Hostel hostel = hostelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hostel not exist with id :" + id));
        hostelRepository.delete(hostel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
