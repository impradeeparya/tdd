package in.helloroomie.controllers.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.helloroomie.commons.TestDataUtil;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.auth.IAuthService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/12/16
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationconfiguration/test/mvc-dispatcher-servlet-test.xml"})
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private IAuthService authService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void shouldAbleToLoginOnValidUserCredentials() throws Exception {

        UserDto userDto = TestDataUtil.getUserDto();

        String requestJson = objectMapper.writeValueAsString(userDto);

        Mockito.when(authService.authenticateUser(Mockito.any(UserDto.class))).thenReturn(userDto);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(authService, Mockito.times(1)).authenticateUser(Mockito.any(UserDto.class));
        Mockito.verifyNoMoreInteractions(authService);

        UserDto response = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsByteArray(), UserDto.class);

        Assert.isTrue(userDto.getEmail().equals(response.getEmail()));


    }
}
