package com.eduhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author dhiren
 *
 */
@EnableAutoConfiguration
@Controller
@EnableSwagger2
@ComponentScan(basePackages = { "com.eduhub.*" })
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	public String Login() {
		return "cover.html";
	}

	// @RequestMapping("login")
	// public ResponseEntity<String> getLoggedIn() {
	// // StackExchangeApiQueryFactory apiQueryFactory =
	// // StackExchangeApiQueryFactory
	// // .newInstance("7vefr96v0CVdajRSCXy3pA((", accessToken,
	// // StackExchangeSite.STACK_OVERFLOW);
	// //
	// // StackOverflowTemplate overflowTemplate = new
	// // StackOverflowTemplate(accessToken);
	// //
	// System.out.println(overflowTemplate.userOperations().getUser().getAccountId());
	// HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new
	// HttpComponentsClientHttpRequestFactory(
	// HttpClientBuilder.create().build());
	// RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
	// UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
	// .fromHttpUrl(
	// "https://api.stackexchange.com/2.2/search/advanced")
	// .queryParam("key", "7vefr96v0CVdajRSCXy3pA((")
	// .queryParam("site", "math").queryParam("order", "desc")
	// .queryParam("sort", "activity")
	// .queryParam("title", "Sdiscontinuous-boundary-condition-in-nd");
	// ResponseEntity<String> responseEntity = restTemplate.exchange(
	// uriComponentsBuilder.build().encode().toUri(), HttpMethod.GET,
	// null, String.class);
	// return new ResponseEntity<String>(responseEntity.getBody(),
	// HttpStatus.OK);
	// }
}
