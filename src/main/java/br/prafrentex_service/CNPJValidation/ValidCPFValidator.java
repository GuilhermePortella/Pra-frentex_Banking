package br.prafrentex_service.CNPJValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class ValidCPFValidator implements ConstraintValidator<ValidCNPJ, String> {

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {
        if (cnpj == null || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            return false;
        }

        cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");

        if (cnpj.length() != 14) {
            return false;
        }
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
        }
        int resto = soma % 11;
        char primeiroDigitoVerificador = (resto < 2) ? '0' : (char) ((11 - resto) + '0');

        if (primeiroDigitoVerificador != cnpj.charAt(12)) {
            return false;
        }

        pesos = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
        }
        resto = soma % 11;
        char segundoDigitoVerificador = (resto < 2) ? '0' : (char) ((11 - resto) + '0');

        return segundoDigitoVerificador == cnpj.charAt(13);
    }
}
