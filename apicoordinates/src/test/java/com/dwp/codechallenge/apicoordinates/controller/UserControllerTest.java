package com.dwp.codechallenge.apicoordinates.controller;

import com.dwp.codechallenge.apicoordinates.exceptions.InvalidCityException;
import com.dwp.codechallenge.apicoordinates.model.User;
import com.dwp.codechallenge.apicoordinates.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> userListMock;

    private String urlForPeopleLivingInLondon;

    @BeforeEach
    public void setUp(){
        userListMock = new ArrayList<>();
        urlForPeopleLivingInLondon = "http://localhost:8080/locationCoordinatorapp/city/London/users";
        userListMock.add(new User(1, "Maurise", "Shieldon", "mshieldon0@squidoo.com", "192.57.232.111", 34.003135, 34.003135));
        userListMock.add( new User(2, "Bendix", "Halgarth", "bhalgarth1@timesonline.co.uk", "4.185.73.82", -2.9623869, 104.7399789));

    }

    @Test
    public void shouldReturn2JsonObjects() throws Exception {
        when(userService.getUsersThatLiveInLondon()).thenReturn(userListMock);
        RequestBuilder request = MockMvcRequestBuilders.get(urlForPeopleLivingInLondon).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("[{id:1,first_name:Maurise, last_name: Shieldon, email: mshieldon0@squidoo.com, ip_address:192.57.232.111, latitude: 34.003135, longitude:34.003135}, {id:2,first_name:Bendix, last_name: Halgarth, email: bhalgarth1@timesonline.co.uk, ip_address:4.185.73.82,latitude: -2.9623869, longitude:104.7399789}]")).andReturn();
    }


    @Test
    public void testShouldThrow_InvalidCityExcepion_WhenWinterfellIsPassedAsParam() throws Exception {
        when(userService.getUsersThatLiveInLondon()).thenReturn(userListMock);
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/locationCoordinatorapp/city/Winterfell/users").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andExpect(status().is(500))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidCityException))
                .andExpect(result -> assertEquals("Please enter London as city.",result.getResolvedException().getMessage()));
    }


    @Test
    public void shouldReturn3JsonObjects_whenSlashUsersIsCalled() throws Exception {
        when(userService.filterUkUsersWithin50MilesOfLondon()).thenReturn(Arrays.asList(new User(266,"Ancell","Garnsworthy","agarnsworthy7d@seattletimes.com","67.4.69.137",51.6553959,0.0572553),new User(322,"Hugo","Lynd","hlynd8x@merriam-webster.com","109.0.153.166",51.6710832,0.8078532),new User(554,"Phyllys","Hebbs","phebbsfd@umn.edu","100.89.186.13",51.5489435,0.3860497)));
        RequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/locationCoordinatorapp/users").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("[{id:266,first_name:Ancell, last_name: Garnsworthy, email: agarnsworthy7d@seattletimes.com, ip_address:67.4.69.137, latitude: 51.6553959, longitude:0.0572553}, {id:322,first_name:Hugo, last_name: Lynd, email: hlynd8x@merriam-webster.com, ip_address:109.0.153.166,latitude: 51.6710832, longitude: 0.8078532},{id:554, first_name:Phyllys, last_name:Hebbs, email:phebbsfd@umn.edu, ip_address:100.89.186.13,latitude:51.5489435, longitude: 0.3860497}]")).andReturn();
    }
}
