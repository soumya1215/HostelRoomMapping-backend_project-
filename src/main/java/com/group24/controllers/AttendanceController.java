package com.group24.controllers;

import com.group24.models.Attendance;
import com.group24.repository.AttendanceRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceRepository attandanceRepository;
	
	
	//get
	@GetMapping("/addpre")
	public List<Attendance> getAllRoute(){
		return attandanceRepository.findAll();
		
		}
	// create employee rest api
	@PostMapping("/addpre")
	public Attendance createRoute(@RequestBody  Attendance at) {
		return attandanceRepository.save(at);
		}
	@GetMapping("/addpre/{id}")
	public ResponseEntity<Attendance>getRouteById(@PathVariable Long id) {
		Attendance at = attandanceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException ("Id not exist with id :" + id));
		return ResponseEntity.ok(at);	}
	// update rest api
	@PutMapping("/addpre/{id}")
	public ResponseEntity<Attendance> updateRoute(@PathVariable Long id, @RequestBody Attendance Details){
		Attendance at = attandanceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID not exist with id :" + id));
		
		at.setRegdno(Details.getRegdno());		
		at.setRoomno(Details.getRoomno());		
		at.setHostelType(Details.getHostelType());
		at.setName(Details.getName());
		at.setAttend(Details.getAttend());

	       Attendance updatedata  =  attandanceRepository.save(at);
	        return ResponseEntity.ok(updatedata);
		
	}
	// Delete rest api
	@DeleteMapping("/addpre/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoute(@PathVariable Long id){
		Attendance at= attandanceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id :" + id));
		
		attandanceRepository.delete(at);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
}
