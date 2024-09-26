package br.prafrentex_service.RegisterUserSimples;

import br.prafrentex_domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class CadastroUsuarioService extends Usuario {

    private final Scanner scanner = new Scanner(System.in);
    private List<Usuario> contasPF = new ArrayList<>();

    public void cadastrarUsuario() {
        Usuario usuario = coletarDadosUsuario();
        String agencia = gerarAgencia();
        String conta = gerarConta();
        adicionarContaPF(usuario, agencia, conta);
    }

    private void adicionarContaPF(Usuario usuario, String agencia, String conta) {
        usuario.setAgencia(agencia);
        usuario.setConta(conta);
        contasPF.add(usuario);
    }

    public List<Usuario> criarListaContasPF() {
        List<Usuario> listaContas = new ArrayList<>();
        for (Usuario conta : contasPF) {
            Usuario contaPF = new Usuario();
            contaPF.setNome(conta.getNome());
            contaPF.setSobrenome(conta.getSobrenome());
            contaPF.setIdade(conta.getIdade());
            contaPF.setEmail(conta.getEmail());
            contaPF.setCpf(conta.getCpf());
            contaPF.setAgencia(conta.getAgencia());
            contaPF.setConta(conta.getConta());
            listaContas.add(contaPF);
        }
        return listaContas;
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

    public void exibirDadosUsuarios() {
        List<Usuario> listaUsuarios = criarListaContasPF();
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\nExibindo todos os usuários cadastrados:");
            for (Usuario usuario : listaUsuarios) {
                System.out.println("Nome: " + usuario.getNome() + " " + usuario.getSobrenome());
                System.out.println("Idade: " + usuario.getIdade());
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
