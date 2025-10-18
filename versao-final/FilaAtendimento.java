public class FilaAtendimento {

    private class Node {
        Cliente cliente;
        Node proximo;

        Node(Cliente cliente) {
            this.cliente = cliente;
            this.proximo = null;
        }
    }

    private Node inicio;
    private Node fim;

    public FilaAtendimento() {
        inicio = null;
        fim = null;
    }

    public boolean filaVazia() {
        return inicio == null;
    }

    public void adicionarCliente(String nome, int id, String motivo) {
        Cliente novo = new Cliente(nome, id, motivo);
        Node novoNode = new Node(novo);

        if (filaVazia()) {
            inicio = novoNode;
            fim = novoNode;
        } else {
            fim.proximo = novoNode;
            fim = novoNode;
        }

        System.out.println("Cliente adicionado a fila: " + nome);
    }

    public Cliente atenderProximo() {
        if (filaVazia()) {
            System.out.println("Fila vazia! sem clientes");
            return null;
        }

        Cliente atendido = inicio.cliente;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        System.out.println("Cliente atendido: " + atendido.getNome());
        return atendido;
    }

    public void mostrarFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia! sem clientes");
            return;
        }

        Node atual = inicio;
        System.out.println("\n--Fila de Atendimento--");
        while (atual != null) {
            System.out.println("\nNome: " + atual.cliente.getNome() + 
                               "\nID: " + atual.cliente.getID() +
                               "\nMotivo: " + atual.cliente.getMotivo());
            atual = atual.proximo;
        }
    }
}
