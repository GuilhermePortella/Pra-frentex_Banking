package br.prafrentex_service;

import br.prafrentex_domain.ContaPF;
import br.prafrentex_domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Guilherme
 */
public class AbrirContaPF extends Usuario {

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

    public void solicitarNomeIdadePessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        this.nome = scanner.nextLine();

        System.out.println("Digite o seu sobrenome: ");
        this.sobrenome = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        this.idade = scanner.nextInt();
    }

    public void solicitarDadosPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de documento: ");
        System.out.println("1. RG");
        System.out.println("2. CNH");
        System.out.println("3. Ambos");

        int opcao = obterOpcao(scanner);

        switch (opcao) {
            case 1:
                configurarDocumentoTipo(tipoDocRG);
                this.documentoRG = obterDocumento(scanner, "RG");
                break;
            case 2:
                configurarDocumentoTipo(tipoDocHabilitacao);
                this.documentoCNH = obterDocumento(scanner, "CNH");
                break;
            case 3:
                configurarDocumentoTipo(tipoDocRG + " e " + tipoDocHabilitacao);
                this.documentoRG = obterDocumento(scanner, "RG");
                this.documentoCNH = obterDocumento(scanner, "CNH");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private int obterOpcao(Scanner scanner) {
        while (true) {
            System.out.print("Digite a opção (1, 2 ou 3): ");
            String input = scanner.nextLine();
            try {
                int opcao = Integer.parseInt(input);
                if (opcao >= 1 && opcao <= 3) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida. Por favor, escolha entre 1, 2 ou 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
    }

    private void configurarDocumentoTipo(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    private String obterDocumento(Scanner scanner, String tipoDocumento) {
        System.out.printf("Digite o número do %s: ", tipoDocumento);
        return scanner.nextLine().trim(); // Usa trim() para remover espaços em branco ao redor
    }

    public void exibirInformacoesPessoa() {

        System.out.println("Nome: " + this.nome);
        System.out.println("Sobrenome: " + this.sobrenome);
        System.out.println("Idade: " + this.idade);

        if (this.tipoDocumento.contains("RG") && this.documentoRG != null && !this.documentoRG.isEmpty()) {
            System.out.println("RG: " + this.documentoRG);
        }
        if (this.tipoDocumento.contains("CNH") && this.documentoCNH != null && !this.documentoCNH.isEmpty()) {
            System.out.println("CNH: " + this.documentoCNH);
        }
    }

    private List<Usuario> contasPF = new ArrayList<>();

    public void adicionarContaPF(AbrirContaPF conta) {
        contasPF.add(conta);
    }

    public List<Usuario> criarListaContasPF() {
        List<Usuario> listaContas = new ArrayList<>();
        for (Usuario conta : contasPF) {
            Usuario contaPF = new Usuario();
            contaPF.nome = conta.nome;
            contaPF.sobrenome = conta.sobrenome;
            contaPF.idade = conta.idade;
            contaPF.tipoDocumento = conta.tipoDocumento;

            if (conta.documentoRG != null && !conta.documentoRG.isEmpty()) {
                contaPF.documentoRG = conta.documentoRG;
            }
            if (conta.documentoCNH != null && !conta.documentoCNH.isEmpty()) {
                contaPF.documentoCNH = conta.documentoCNH;
            }

            listaContas.add(contaPF);
        }
        return listaContas;
    }

}
