public class PilhaSolicitacoes {

    private Solicitacao topo;

    public PilhaSolicitacoes() {
        this.topo = null;
    }

    private boolean estaVazia() {
        return this.topo == null;
    }

    public void adicionarSolicitacao(int id, String descricao, String data, String hora) {
        insereElemento(new Solicitacao(id, descricao, data, hora));
    }   

    private void insereElemento(Solicitacao novaSolicitacao) { 

        if (this.estaVazia()) {
            this.topo = novaSolicitacao;
        } else {
            novaSolicitacao.setAnterior(this.topo);
            this.topo = novaSolicitacao;
        }

    }

    public void cancelarOperacao() {

        if (!this.estaVazia()) {
            Solicitacao temp = this.topo;
            this.topo = this.topo.getAnterior();
            temp.setAnterior(null);
        } else {
            System.out.println("\nerro: nao ha nenhuma solicitacao no historico");
        }

    }

    public void imprimirHistorico() {
        
        if (this.estaVazia()) {

            System.out.println("\nHistorico vazio - nenhuma solicitacao pendente");

        } else {

            System.out.println("\n#### IMPRIMINDO O HISTORICO DE SOLICITACOES ####");
            Solicitacao atual = this.topo;
            while (atual != null) {
                atual.printInfo();
                atual = atual.getAnterior();
            }

        }

    }

}