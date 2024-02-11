package com.example.h2demo;

import com.example.h2demo.dao.UserRepository;
import com.example.h2demo.entity.User;
import com.example.h2demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTests {
    private UserServiceImpl userinfoService;
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = mock(UserRepository.class);
        userinfoService = new UserServiceImpl(userRepository);
    }

    @Test
    public void checkEntry() {
        User mockUser = mock(User.class);
        when(userinfoService.save((User) mockUser)).thenReturn((User) mockUser);
        assertEquals(userinfoService.save(mockUser), mockUser);
    }
}
