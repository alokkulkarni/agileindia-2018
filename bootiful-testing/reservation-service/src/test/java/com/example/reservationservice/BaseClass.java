package com.example.reservationservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author <a href="mailto:josh@joshlong.com">Josh Long</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseClass {

	@MockBean
	private ReservationRepository reservationRepository;

	@Autowired
	private ReservationRestController reservationRestController;

	@Before
	public void before() throws Exception {

		Mockito.when(this.reservationRepository.findAll()).thenReturn(
				Arrays.asList(new Reservation(1L, "Jane"),
						new Reservation(2L, "John")));

		RestAssuredMockMvc.standaloneSetup(this.reservationRestController);
	}

}
