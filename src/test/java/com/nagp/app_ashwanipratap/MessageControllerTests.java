package com.nagp.app_ashwanipratap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = MessageController.class)
@ExtendWith(SpringExtension.class)
class MessageControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testMessage() throws Exception {
        String response = mockMvc.perform(get("/testmessage")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertThat(response).isEqualTo("NAGP 2022 Technology Band III Batch");
    }

}
