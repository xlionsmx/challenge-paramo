package sat.recruitment.api.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import sat.recruitment.api.controller.v1.SatRecruitmentController;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.factories.UserFactory;
import sat.recruitment.api.mappers.UserMapper;
import sat.recruitment.api.services.UserServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc 
class MessagesActionsControllerTest {
    
    @Autowired 
    private MockMvc mockMvc;
    @Autowired
    private SatRecruitmentController controller;

    @MockBean
    UserServiceImpl userService;

    @MockBean
    UserMapper userMapper;

    @MockBean
    UserFactory userFactory;
    
    @Test
    @AutoConfigureMockMvc
    void whenValidInput_thenReturns200() throws Exception {
        UserDto newUser = new UserDto("Jorge", "jorge@gmail.com","Alberdi 132", "2311", "premium", 100.22);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(newUser)))
            .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
