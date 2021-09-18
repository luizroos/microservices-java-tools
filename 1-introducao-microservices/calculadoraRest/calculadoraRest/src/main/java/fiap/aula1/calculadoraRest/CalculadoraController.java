package fiap.aula1.calculadoraRest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/calculadora")
public class CalculadoraController {

	@RequestMapping(value = "/somar/{valor1}/{valor2}", method = RequestMethod.GET)
	public int somar(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
		return v1 + v2;
	}

	@RequestMapping(value = "/subtrair/{valor1}/{valor2}", method = RequestMethod.GET)
	public int subtrair(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
		return v1 - v2;
	}

	@RequestMapping(value = "/dividir/{valor1}/{valor2}", method = RequestMethod.GET)
	public int dividir(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
		return v1 / v2;
	}

	@RequestMapping(value = "/multiplicar/{valor1}/{valor2}", method = RequestMethod.GET)
	public int multiplicar(@PathVariable("valor1") int v1, @PathVariable("valor2") int v2) {
		return v1 * v2;
	}

}
