package br.prafrentex_service.loginUser;

import br.prafrentex_domain.ContaPF;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

import br.prafrentex_domain.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Guilherme
 */
public class AuthService {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Usuario> contasPF = new ArrayList<>();

    public void cadastrarUsuario() {
        Usuario usuario = coletarDadosUsuario();
        String agencia = gerarAgencia();
        String conta = gerarConta();
        adicionarContaPF(usuario, agencia, conta);
    }

    private Usuario coletarDadosUsuario() {
        Usuario usuario = new Usuario();

        System.out.println("Bem-vindo ao sistema de cadastro de usuários");

        System.out.print("Informe seu nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Informe seu sobrenome: ");
        usuario.setSobrenome(scanner.nextLine());

        System.out.print("Informe sua data de nascimento (YYYY-MM-DD): ");
        usuario.setDataNascimento(LocalDate.EPOCH.parse(scanner.nextLine()));

        System.out.print("Informe seu email: ");
        usuario.setEmail(scanner.nextLine());

        System.out.print("Informe seu CPF: ");
        usuario.setCpf(scanner.nextLine());

        System.out.print("Informe sua senha: ");
        String senha = scanner.nextLine();
        usuario.setSenhaHash(SenhaService.gerarHashSenha(senha));

        return usuario;
    }

    private void adicionarContaPF(Usuario usuario, String agencia, String conta) {
        usuario.setAgencia(agencia);
        usuario.setConta(conta);
        contasPF.add(usuario);
    }

    public List<Usuario> criarListaContasPF() {
        return new ArrayList<>(contasPF);
    }

    public void exibirDadosUsuarios() {
        List<Usuario> listaUsuarios = criarListaContasPF();
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\nExibindo todos os usuários cadastrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println("Nome: " + usuario.getNome() + " " + usuario.getSobrenome());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("Agência: " + usuario.getAgencia());
                System.out.println("Conta: " + usuario.getConta());
                System.out.println("-------------------------------");
            }
        }
    }

    private String gerarAgencia() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    private String gerarConta() {
        Random random = new Random();
        return String.format("%09d", random.nextInt(1000000000));
    }

    public void processarCadastroEExibicao() {
        cadastrarUsuario();
        exibirDadosUsuarios();
    }
}
