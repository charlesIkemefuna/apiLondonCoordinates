package com.dwp.codechallenge.apicoordinates.service;

import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    void contextLoads() {
    }

/**I have decided not to create tests for the service layer because while trying to mock the restTemplate contained in all UserService methods
 * I received this error   org.mockito.exceptions.misusing.PotentialStubbingProblem:
 * Possible solution to this could be to alter STRCTNESS to LENINIENT
 * @ExtendWith(MockitoExtension.class)
 * @MockitoSettings(strictness = Strictness.LENIENT)
 *
 * However this could compromise the integrity of unit tests an lead to further bugs in the future
 * Nappy to discuss this further.*/




}
