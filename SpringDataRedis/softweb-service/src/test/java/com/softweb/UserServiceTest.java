package com.softweb;

import com.softweb.dto.UserDto;
import com.softweb.services.database.UserDbService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
/*
	@Mock – creates mocks
	@InjectMocks – creates objects and inject mocked dependencies
*/

    @InjectMocks
    private UserDbService userService;

    @Mock
    private IUserDao userDao;

    @Before
    public void setup() {
        userService =  new UserDbService();
    }

    @Test
    public void getUsersTest() {

        List<User> users =  new ArrayList<>();
        User user = new User(1,"zekiri","Abdelali");
        users.add(user);
        // I am here c'est anis
        doReturn(users).when(userDao).findAll();

        List<UserDto> result = userService.getUsers();

        assertThat(result).isNotEmpty();
        verify(userDao,times(1)).findAll();
    }

}
