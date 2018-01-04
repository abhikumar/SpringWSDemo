package com.xav;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.xav.controller.ClientController;
import com.xav.controller.Main;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringWsApplicationTests {
	@Autowired
	private ClientController helloWorldClient;

	@Test
	public void testSayHello() {
		assertThat(helloWorldClient.get()).isEqualTo(
				"Hello a k!");
	}
}
