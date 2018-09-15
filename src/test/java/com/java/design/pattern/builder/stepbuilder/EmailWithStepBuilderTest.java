package com.java.design.pattern.builder.stepbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;





public class EmailWithStepBuilderTest {

	@Test
	public void shouldCreateAnEmailWithAllField() {
		EmailWithStepBuilder emailWithStepBuilder = 
				EmailWithStepBuilder.builder()
				.from("martin.sender@mail.com")
				.to("receiver@mail.com")
				.subject("A Mail Subject")
				.content("BLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLA")
				.bcc(new String [] {"bcc1@mail.com","bcc2@mail.com"})
				.cc(new String [] {"cc1@mail.com","cc2@mail.com"})
				.build();
	}

	@Test
	public void shouldCreateAnEmailWithMinimunField() {
		EmailWithStepBuilder emailWithStepBuilder = 
				EmailWithStepBuilder.builder()
				.from("martin.sender@mail.com")
				.to("receiver@mail.com")
				.subject("A Mail Subject")
				.content("BLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLABLA")
				.build();
	}

}
