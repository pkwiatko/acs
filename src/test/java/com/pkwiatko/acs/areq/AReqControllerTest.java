package com.pkwiatko.acs.areq;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileInputStream;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AReqController.class)
public class AReqControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void authorisationRequestTest() throws Exception{
        String jsonReq = IOUtils.toString(new FileInputStream(ResourceUtils.getFile(this.getClass().getResource("/AReq.json"))));
        System.out.println(jsonReq);

        this.mockMvc.perform(post("/areq")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(jsonReq)
                )
                .andExpect(status().isOk());
    }
}
