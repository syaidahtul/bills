package com.bps.ebill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bps.ebill.dto.GenericValueNameDTO;
import com.bps.ebill.services.S3PAPIService;

@RestController
@RequestMapping("/secured/dropdown")
public class GenericController {

	@Autowired
	private S3PAPIService apiService;

	@GetMapping(value = "/votCode", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public List<GenericValueNameDTO> getAll() {
	    return apiService.getVotCodes();
	}
}
