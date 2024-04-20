package com.loteria;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
//@AutoConfigurationMockMvc
@ActiveProfiles("test")
public abstract class AbstractIntegrationTest {

    protected MockMvc mockMvc;


}
