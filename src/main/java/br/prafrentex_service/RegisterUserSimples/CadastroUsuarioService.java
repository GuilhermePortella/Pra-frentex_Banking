package br.prafrentex_service.RegisterUserSimples;

import br.prafrentex_domain.Usuario;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class CadastroUsuarioService extends Usuario {

    private final Scanner scanner = new Scanner(System.in);

    public void cadastrarUsuario() {
        Usuario usuario = coletarDadosUsuario();

        String agencia = gerarAgencia();
        String conta = gerarConta();
        exibirDadosUsuario(usuario, agencia, conta);
    }

    private Usuario coletarDadosUsuario() {
        System.out.println("Bem-vindo ao sistema de cadastro de usuários");

        System.out.print("Informe seu nome: ");
        this.nome = scanner.nextLine();

        System.out.print("Informe seu sobrenome: ");
        this.sobrenome = scanner.nextLine();

        System.out.print("Informe sua idade: ");
        this.idade = Integer.parseInt(scanner.nextLine());

        System.out.print("Informe seu email: ");
        this.email = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        this.cpf = scanner.nextLine();

        return new Usuario(nome, sobrenome, idade, email, cpf);
    }

    private void exibirDadosUsuario(Usuario usuario, String agencia, String conta) {
        System.out.println("\nUsuário cadastrado com sucesso!");
        System.out.println("Nome: " + usuario.getNome() + " " + usuario.getSobrenome());
        System.out.println("Idade: " + usuario.getIdade());
        System.out.println("Email: " + usuario.getEmail());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + conta);
    }

    private String gerarAgencia() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    private String gerarConta() {
        Random random = new Random();
        return String.format("%09d", random.nextInt(1000000000));
    }
}
