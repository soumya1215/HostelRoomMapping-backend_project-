package com.group24.controllers;


import com.group24.models.Mess;
import com.group24.repository.MessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/Student")
public class MessModuleController {

	@Autowired
	private MessRepository messRepository;
	
	@GetMapping("/addstudent")
	public List<Mess> getAllStudent(){
		return messRepository.findAll();
		}
	// create rest api
	@PostMapping("/addstudent")
	public Mess createMess(@RequestBody Mess ms) {
		return messRepository.save(ms);
	}
	
	
	@GetMapping("/addstudent/{id}")
	public ResponseEntity<Mess>getMessById(@PathVariable Long id) {
		Mess ms = messRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id :" + id));
		return ResponseEntity.ok(ms);
	}
	
	//upadating 
	@PutMapping("/addstudent/{id}")
	public ResponseEntity<Mess> updateStudent(@PathVariable Long id, @RequestBody Mess details){
		Mess ms= messRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id:"+ id));
		
		ms.setDay(details.getDay());
	    ms.setBreakfast(details.getBreakfast());
	    ms.setLunch(details.getLunch());
	    ms.setSnack(details.getSnack());
		ms.setDinner(details.getDinner());
		
		
	       Mess updatedstudent  =  messRepository.save(ms);
	        return ResponseEntity.ok(updatedstudent);

}
	// Delete rest api
	@DeleteMapping("/addstudent/{id}")
	public ResponseEntity<Map<String, Boolean>> deletestudent(@PathVariable Long id){
		Mess ms= messRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id:"+ id));
		messRepository.delete(ms);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
