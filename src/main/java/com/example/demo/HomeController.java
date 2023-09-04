package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Item;
import com.example.demo.validation.XmlValidator;

@RestController
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/")
	public String index() {

		try {
			XmlValidator xmlValidator = new XmlValidator("person.xsd", "person-valid.xml");
			boolean isValidXml = xmlValidator.isValid();
			logger.info("isValidXML-->" + isValidXml);

			xmlValidator = new XmlValidator("full-person.xsd", "person-valid.xml");
			isValidXml = xmlValidator.isValid();
			logger.info("isValidXML Second -->" + isValidXml);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/process")
	public String parseXML(@RequestBody Item item) {

		try {
			logger.info("individual.getName()-->" + item.getName());
			logger.info("individual.getId()-->" + item.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "XML is Processed";
	}

	@PostMapping("/validate")
	public String processXML(@RequestBody String xml) {
		boolean isValidXml = false;
		try {
			logger.info("Passed xml -->" + xml);

			XmlValidator xmlValidator = new XmlValidator("person.xsd", null);
			isValidXml = xmlValidator.isValid(xml);
			logger.info("isValidXML-->" + isValidXml);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isValidXml) {
			return "Passed XML is Valid";
		} else {
			return "Passed XML is not Valid";
		}
	}

}