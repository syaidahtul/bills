package com.bps.ebill.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bps.ebill.dto.GenericValueNameDTO;
import com.bps.ebill.models.VotCode;
import com.bps.ebill.repository.VotCodeRepository;
import com.bps.ebill.services.S3PAPIService;

@Service
public class S3PAPIServiceImpl implements S3PAPIService {

	// private static final String VOTCODE_API_URL = "https://s3p.sabah.gov.my/api_eresit/vot";
	@Autowired
	private VotCodeRepository votCodeRepository;
	
	@Override
	public List<GenericValueNameDTO> getVotCodes() {
        List<GenericValueNameDTO> votCodes = new ArrayList<GenericValueNameDTO>();
        List<VotCode> objects = (List<VotCode>) votCodeRepository.findAll();
        if (objects != null && objects.size() > 0) {
        	votCodes = this.toVotCodeDTOList(objects);
        }
        return votCodes;
    }

	private List<GenericValueNameDTO> toVotCodeDTOList(List<VotCode> objects) {
		List<GenericValueNameDTO> votCodes = new ArrayList<GenericValueNameDTO>();
		for (VotCode obj : objects) {
			votCodes.add(new GenericValueNameDTO(obj.getBudCode(), obj.getBudCode()));
		}
		return votCodes;
	}

}
