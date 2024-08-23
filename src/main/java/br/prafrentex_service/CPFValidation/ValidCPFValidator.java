package br.prafrentex_service.CPFValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Guilherme
 */
public class ValidCPFValidator implements ConstraintValidator<ValidCPF, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        try {
            int digito1 = calcularDigito(cpf, 10);
            int digito2 = calcularDigito(cpf, 11);

            return cpf.endsWith(String.format("%02d", digito1 * 10 + digito2));
        } catch (Exception e) {
            return false;
        }
    }

    private int calcularDigito(String cpf, int peso) {
        int soma = 0;
        for (int i = 0; i < cpf.length() - 2; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}