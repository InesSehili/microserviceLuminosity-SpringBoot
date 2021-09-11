package org.sid.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name="appareil")
public class Appareil {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name; 
	private String status;
	private float value;
}
