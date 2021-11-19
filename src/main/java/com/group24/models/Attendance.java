package com.group24.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name ="atten_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="regdno")
	private long regdno;
	
	
	@Column(name="hostel_type")
	private String hostelType;
	
	@Column(name="name")
	private String name;
		
	@Column(name="roomno")
	private long roomno;
	
	@Column(name="attend")
	private String attend;

}