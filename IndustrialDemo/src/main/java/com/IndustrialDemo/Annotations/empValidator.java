package com.IndustrialDemo.Annotations;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.IndustrialDemo.Entities.Database.Employee;
import com.IndustrialDemo.Entities.RequestDTO.RequestDTO;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidatorContext;

public class empValidator implements jakarta.validation.ConstraintValidator<ValidateFirstName, String> {

	private String regex = "^[a-zA-Z\\s]+$";

	@Override
	public boolean isValid(String firstname, ConstraintValidatorContext context) {

//		List<String> list =  Arrays.asList("best","good");
//		return list.contains(firstname);

		if (StringUtils.isBlank(firstname)) {
			return true;

		}

		Pattern pat = Pattern.compile(regex);
		return pat.matcher(firstname).matches();

	}
}
