public class Main {
    public static void main(String[] args) {
    Banco meuBanco = new Banco("Banco Central");

  // Criando contas
  ContaBancaria conta1 = meuBanco.criarConta("Ana Carla", 1000);
  ContaBancaria conta2 = meuBanco.criarConta("João Silva", 500);

  // Verificando saldos
  System.out.println("Saldo de " + conta1.getTitular() + ": R$" + conta1.verificarSaldo());
  System.out.println("Saldo de " + conta2.getTitular() + ": R$" + conta2.verificarSaldo());

  // Transferindo dinheiro
  meuBanco.transferir(200, conta1.getNumero(), conta2.getNumero());

  // Verificando saldos após a transferência
  System.out.println("Saldo de " + conta1.getTitular() + ": R$" + conta1.verificarSaldo());
  System.out.println("Saldo de " + conta2.getTitular() + ": R$" + conta2.verificarSaldo());
  }
  }