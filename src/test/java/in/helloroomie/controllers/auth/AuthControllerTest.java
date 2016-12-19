package in.helloroomie.controllers.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.helloroomie.commons.TestDataUtil;
import in.helloroomie.controllers.AbstractControllerTest;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.auth.IAuthService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 8/12/16
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */

public class AuthControllerTest extends AbstractControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private IAuthService authService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected Object getTestedController() {
        return authController;
    }

    @Test
    public void shouldAbleToLoginOnValidUserCredentials() throws Exception {

        UserDto userDto = TestDataUtil.getUserDto();

        String requestJson = objectMapper.writeValueAsString(userDto);

        Mockito.when(authService.authenticateUser(Mockito.any(UserDto.class))).thenReturn(userDto);
        ResultActions resultActions = getMockMvc().perform(MockMvcRequestBuilders
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
