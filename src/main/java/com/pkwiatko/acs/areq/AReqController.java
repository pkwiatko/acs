package com.pkwiatko.acs.areq;

import com.pkwiatko.acs.areq.dto.AReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AReqController {

    @PostMapping("/areq")
    ResponseEntity authorisationRequest(@RequestBody AReq areq) {
        System.out.println(areq);
        return ResponseEntity.ok(areq);
    }
}
