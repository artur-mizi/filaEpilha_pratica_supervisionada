public class Solicitacao {
    
    private int id;
    private String descricao;
    private String data;
    private String hora;

    private Solicitacao solicitacao_anterior;

    public Solicitacao(int id, String descricao, String data, String hora) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;

        this.solicitacao_anterior = null;
    }

    public Solicitacao getAnterior() {
        return this.solicitacao_anterior;
    }

    public void setAnterior(Solicitacao solicitacao) {
        this.solicitacao_anterior = solicitacao;
    }

    public void printInfo() {
        System.out.println("Solicitacao id - " + this.id + " - descricao: " + this.descricao + " (data - " + this.data + " hora - " + this.hora);
    }

}