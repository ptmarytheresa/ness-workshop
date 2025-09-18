package com.stackroute.summary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class SummaryController {

	@Autowired
	SummaryRepo repo;

	@GetMapping("viewall")
	public ResponseEntity<?> getall()
	{
		List<Summary> list=repo.findAll();
		return new ResponseEntity(list,HttpStatus.OK);
	}
}
