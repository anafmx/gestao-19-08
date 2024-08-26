import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<ContaBancaria> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public ContaBancaria criarConta(String titular, double saldoInicial) {
        String numero = String.format("%06d", contas.size() + 1); // Gera um número de conta sequencial com 6 dígitos
        ContaBancaria novaConta = new ContaBancaria(numero, titular, saldoInicial);
        contas.add(novaConta);
        System.out.println("Conta criada com sucesso! Número da conta: " + numero);
        return novaConta;
    }

    public ContaBancaria encontrarConta(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public void transferir(double valor, String contaOrigemNumero, String contaDestinoNumero) {
        ContaBancaria contaOrigem = encontrarConta(contaOrigemNumero);
        ContaBancaria contaDestino = encontrarConta(contaDestinoNumero);

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.verificarSaldo() >= valor) {
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para realizar a transferência.");
            }
        } else {
            System.out.println("Transferência não realizada. Verifique os números das contas.");
        }
    }

    public String getNome() {
        return nome;
    }
}