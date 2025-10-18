public class Cliente {

    private String nome;
    private int id;
    private String motivo;

    public Cliente(String nome, int id, String motivo) {
        this.nome = nome;
        this.id = id;
        this.motivo = motivo;
    }

    public String getNome(){
        return nome;
    }

    public int getID(){
        return id;
    }

    public String getMotivo(){
        return motivo;
    }
    
}