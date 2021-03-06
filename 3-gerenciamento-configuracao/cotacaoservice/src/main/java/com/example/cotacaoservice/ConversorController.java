package com.example.cotacaoservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/moeda")
@RefreshScope
public class ConversorController {

	@Value("${cotacaoDolar}")
	private double COTACAO_DOLAR = 4.30;

	@RequestMapping(value = "/dolarToReal/{dolar}")
	public String dolarToReal(@PathVariable(name = "dolar") double dolar) {
		return "R$ " + formatTwoDecimalPlaces(dolar * COTACAO_DOLAR);
	}

	@RequestMapping(value = "/realToDolar/{real}")
	public String realToDolar(@PathVariable(name = "real") double real) {
		return "US$ " + formatTwoDecimalPlaces(real / COTACAO_DOLAR);
	}

	private double formatTwoDecimalPlaces(double d) {
		BigDecimal bd = new BigDecimal(d);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}