package school.sptech;

public class Avaliacao {
    private String descricao;
    private Double qtdEstrelas;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQtdEstrelas() {
        return qtdEstrelas;
    }

    public void setQtdEstrelas(Double qtdEstrelas) {
        this.qtdEstrelas = qtdEstrelas;
    }

    public Avaliacao(String descricao, Double qtdEstrelas) {
        this.descricao = descricao;
        this.qtdEstrelas = qtdEstrelas;
    }

    public Avaliacao() {
    }

    @Override
    public String toString() {
        return """
                Descricão:%s
                qtdEstrelas: %.2f
                """.formatted(descricao, qtdEstrelas);
    }
}
