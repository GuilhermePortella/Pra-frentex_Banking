package br.prafrentex_service.loginUser;

import java.util.Scanner;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;

import br.prafrentex_domain.Usuario;
import br.prafrentex_service.RegisterUserSimples.CadastroUsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class AuthService {

    @Inject
    CadastroUsuarioService cadastroUsuarioService;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthService.class);


    private final Scanner scanner = new Scanner(System.in);
    private final List<Usuario> contasPF = new ArrayList<>();
    
    public void cadastrarUsuario() {
        Usuario usuario = coletarDadosUsuario();
        String agencia = cadastroUsuarioService.gerarAgencia();
        String conta = cadastroUsuarioService.gerarConta();
        adicionarContaPF(usuario, agencia, conta);
    }

    private Usuario coletarDadosUsuario() {
        Usuario usuario = new Usuario();

        logger.info("Iniciando cadastro de usuário");

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

    protected void adicionarContaPF(Usuario usuario, String agencia, String conta) {
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

    public void processarCadastroEExibicao() {
        cadastrarUsuario();
        exibirDadosUsuarios();
    }
}
