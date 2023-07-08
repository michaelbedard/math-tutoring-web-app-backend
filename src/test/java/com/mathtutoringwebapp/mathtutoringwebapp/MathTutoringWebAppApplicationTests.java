package com.mathtutoringwebapp.mathtutoringwebapp;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.UserRepository;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MathTutoringWebAppApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EquationService equationService;

//	@Test
//	void iniEquation() {
//		Equation equation = new Equation("linear",
//				"y = a*x + b",
//				"[y] = [a]*[x] + [b]");
//		System.out.println(equation);
//		equationService.save(equation);
//
//		Assertions.assertThat(equationService.getAll()).size().isGreaterThan(0);
//
//	}
}
