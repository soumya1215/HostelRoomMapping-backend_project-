package com.group24.controllers;

import com.group24.models.Helpdesk;
import com.group24.repository.Helpdeskrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/HelpDesk")

public class Helpdeskcontroller {
	@Autowired
	private Helpdeskrepository helpdeskRepository;
	
	@GetMapping("/addhelpdesk")
	public List<Helpdesk> getAllHelpDesk(){
		return helpdeskRepository.findAll();
		}
	// create rest api
	@PostMapping("/addhelpdesk")
	public Helpdesk createHelpDesk(@RequestBody  Helpdesk hd) {
		return helpdeskRepository.save(hd);
	}
	@GetMapping("/addhelpdesk/{id}")
	public ResponseEntity<Helpdesk>getHelpDeskById(@PathVariable Long id) {
		Helpdesk hd = helpdeskRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id :" + id));
		return ResponseEntity.ok(hd);
	}
	
	//upadating 
	
	@PutMapping("/addhelpdesk/{id}")
	public ResponseEntity<Helpdesk> updateHelpDesk(@PathVariable Long id, @RequestBody Helpdesk details){
		Helpdesk hd= helpdeskRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID not exist with id :" + id));
		
		hd.setName(details.getName());		
	    hd.setRegdno(details.getRegdno());
		hd.setEmail(details.getEmail());
		hd.setData( details.getData());
		
		
		
		Helpdesk updatedhelpdesk  =  helpdeskRepository.save(hd);
	        return ResponseEntity.ok(updatedhelpdesk);

}
	// Delete rest api
	@DeleteMapping("/addhelpdesk/{id}")
	public ResponseEntity<Map<String, Boolean>> deletehelpdesk(@PathVariable Long id){
		Helpdesk hd= helpdeskRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id not exist with id :" + id));
		
		helpdeskRepository.delete(hd);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
