package br.prafrentex_service;

import br.prafrentex_domain.ContaPJ;
import java.util.Scanner;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Guilherme
 */
public class AbrirContaPJ extends ContaPJ {

    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    public AbrirContaPJ() {}

    public boolean validarCNPJ() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<AbrirContaPJ>> violations = validator.validate(this);
        if (violations.isEmpty()) {
            System.out.println("CNPJ válido!");
            return true;
        } else {
            for (ConstraintViolation<AbrirContaPJ> violation : violations) {
                System.out.println(violation.getMessage());
            }
            return false;
        }
    }

    public void solicitarCNPJValido() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Digite o CNPJ:");
            cnpj = scanner.nextLine();
            setCNPJ(cnpj);
        } while (!validarCNPJ());
        System.out.println("CNPJ armazenado: " + getCNPJ());
    }
}