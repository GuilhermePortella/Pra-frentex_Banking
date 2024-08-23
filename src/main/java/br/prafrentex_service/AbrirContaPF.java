package br.prafrentex_service;

import br.prafrentex_domain.ContaPF;
import br.prafrentex_service.CPFValidation.ValidCPF;
import java.util.Scanner;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Guilherme
 */
public class AbrirContaPF extends ContaPF {

    @CPF(message = "CPF inválido")
    private String cpf;

    public AbrirContaPF() {
        this.cpf = solicitarCPF();
        System.out.println("CPF válido: " + this.cpf);
    }

    private String solicitarCPF() {
        Scanner scanner = new Scanner(System.in);
        String cpf;
        boolean cpfValido;

        do {
            System.out.print("Digite o CPF (formato XXX.XXX.XXX-XX): ");
            cpf = scanner.nextLine();
            cpfValido = validarCPF(cpf);
            if (!cpfValido) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!cpfValido);

        return cpf;
    }

    private boolean validarCPF(String cpf) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        this.cpf = cpf;

        Set<ConstraintViolation<AbrirContaPF>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public String getCpf() {
        return cpf;
    }
}