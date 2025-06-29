package br.service.RegisterUserSimples;

import java.math.BigDecimal;
import java.util.*;

import br.domain.model.usuarios.Usuario;

/**
 * @author Guilherme
 */
public class CadastroUsuarioService extends Usuario {

    private final Scanner scanner = new Scanner(System.in);
    private List<Usuario> contasPF = new ArrayList<>();
    private Map<String, BigDecimal> saldoContas = new HashMap<>();
    private static final BigDecimal SALDO_INICIAL = BigDecimal.ZERO;

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
        saldoContas.put(conta, SALDO_INICIAL);
    }

    public BigDecimal consultarSaldo(String numeroConta) {
        return saldoContas.getOrDefault(numeroConta, BigDecimal.ZERO);
    }

    public void depositar(String numeroConta, BigDecimal valor) {
        validarValor(valor);
        BigDecimal saldoAtual = consultarSaldo(numeroConta);
        saldoContas.put(numeroConta, saldoAtual.add(valor));
    }

    public void sacar(String numeroConta, BigDecimal valor) {
        validarValor(valor);
        BigDecimal saldoAtual = consultarSaldo(numeroConta);
        if (saldoAtual.compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldoContas.put(numeroConta, saldoAtual.subtract(valor));
    }

    public void transferir(String contaOrigem, String contaDestino, BigDecimal valor) {
        sacar(contaOrigem, valor);
        depositar(contaDestino, valor);
    }

    public void encerrarConta(String numeroConta) {
        if (saldoContas.get(numeroConta).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("Conta com saldo não pode ser encerrada");
        }
        saldoContas.remove(numeroConta);
        contasPF.removeIf(usuario -> usuario.getConta().equals(numeroConta));
    }

    private void validarValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
    }

    public List<Usuario> criarListaContasPF() {
        List<Usuario> listaContas = new ArrayList<>();
        for (Usuario conta : contasPF) {
            Usuario contaPF = new Usuario();
            contaPF.setNome(conta.getNome());
            contaPF.setSobrenome(conta.getSobrenome());
            contaPF.setDataNascimento(conta.getDataNascimento());
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

        System.out.print("Informe seu email: ");
        this.email = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        this.cpf = scanner.nextLine();

        return new Usuario(nome, sobrenome, email, cpf);
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
                System.out.println("Saldo: R$ " + consultarSaldo(usuario.getConta()));
                System.out.println("-------------------------------");
            }
        }
    }

    public String gerarAgencia() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String gerarConta() {
        Random random = new Random();
        return String.format("%09d", random.nextInt(1000000000));
    }

    public void processarCadastroEExibicao() {
        cadastrarUsuario();
        exibirDadosUsuarios();
    }
}
