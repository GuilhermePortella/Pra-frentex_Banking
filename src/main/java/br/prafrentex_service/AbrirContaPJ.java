package br.prafrentex_service;

import br.prafrentex_domain.ContaPJ;
import java.util.ArrayList;
import java.util.List;
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

    public AbrirContaPJ() {
    }

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

    public void solicitarDadosEmpresa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a razão social: ");
        this.razaoSocial = scanner.nextLine();

        System.out.print("Digite o nome fantasia: ");
        this.nomeFantasia = scanner.nextLine();

        System.out.print("Digite a inscrição estadual: ");
        this.inscricaoEstadual = scanner.nextLine();
    }
    
    public ContaPJ apresentarDadosEmLista() {
        List<ContaPJ> contas = new ArrayList<>();

        AbrirContaPJ usuarioPJ = new AbrirContaPJ();
        usuarioPJ.solicitarDadosEmpresa();
        usuarioPJ.solicitarCNPJValido();
        contas.add(usuarioPJ);

        for (ContaPJ conta : contas) {
            System.out.println("Razão Social: " + conta.getRazaoSocial());
            System.out.println("Nome Fantasia: " + conta.getNomeFantasia());
            System.out.println("Inscrição Estadual: " + conta.getInscricaoEstadual());
            System.out.println("CNPJ: " + conta.getCNPJ());
            System.out.println("----------------------------");
        }
        return usuarioPJ;
    }
}
