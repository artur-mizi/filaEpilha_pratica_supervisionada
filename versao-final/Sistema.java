import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    private static final String SIMULA_DATA = "15/10/2025";
    private static final String SIMULA_HORA = "13:00"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PilhaSolicitacoes solicitacoes = new PilhaSolicitacoes();
        FilaAtendimento fila = new FilaAtendimento(); // nova fila de clientes

        System.out.println("######## INICIANDO SISTEMA ##########\n\n");
        boolean flag_sistema_ativo = true;

        int escolha_usuario;
        int criador_ids = 0;
        int confirmacao;
        int id_cliente_fila = 0;

        do {
            try {

                System.out.println("\n-->Digite 1 para criar um novo procedimento"
                                    + "\n-->Digite 2 para imprimir o historico de solicitacoes"
                                    + "\n-->Digite 3 para adicionar cliente a fila de atendimento"
                                    + "\n-->Digite 4 para atender o proximo cliente"
                                    + "\n-->Digite 5 para mostrar fila de atendimento"
                                    + "\n-->Digite 6 para encerrar o sistema");
                escolha_usuario = scanner.nextInt();
                scanner.nextLine();

                if (escolha_usuario == 6) {

                    flag_sistema_ativo = false;

                } else if (escolha_usuario == 2) {

                    solicitacoes.imprimirHistorico();

                } else if (escolha_usuario == 1) {

                    int id_solicitacao = criador_ids;
                    String data_atual = SIMULA_DATA;
                    String hora_atual = SIMULA_HORA;
                    String descricao;

                    System.out.println("\nQual o motivo da solicitacao?");
                    descricao = scanner.nextLine();

                    boolean confirmado = false;
                    do {

                        System.out.println("\nDIGITE 1 PARA CONFIRMAR A OPERACAO E 2 PARA CANCELAR A OPERACAO E REVERTER AS MUDANCAS:");
                        confirmacao = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmacao == 1) {
                            solicitacoes.adicionarSolicitacao(id_solicitacao, descricao, data_atual, hora_atual);
                            criador_ids++;
                            System.out.println("Solicitacao confirmada e registrada com sucesso!");
                            confirmado = true;
                        } else if (confirmacao == 2) {
                            System.out.println("Operacao cancelada. Solicitacao removida do historico.");
                            confirmado = true;
                        } else {
                            System.out.println("Opcao invalida, tente novamente!");
                        }

                    } while (!confirmado);

                } else if (escolha_usuario == 3) {

                    System.out.println("\nDigite o nome do cliente:");
                    String nome = scanner.nextLine();

                    id_cliente_fila ++;

                    System.out.println("Digite o motivo do atendimento:");
                    String motivo = scanner.nextLine();

                    fila.adicionarCliente(nome, id_cliente_fila, motivo);

                } else if (escolha_usuario == 4) {

                    fila.atenderProximo();

                } else if (escolha_usuario == 5) {

                    fila.mostrarFila();

                } else {
                    System.out.println("Opcao invalida! Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada invalida. Digite apenas numeros!");
                scanner.nextLine();
                escolha_usuario = 0;
            }

        } while (flag_sistema_ativo);

        System.out.println("\n######## SISTEMA ENCERRADO ########");
        scanner.close();
    }
}
