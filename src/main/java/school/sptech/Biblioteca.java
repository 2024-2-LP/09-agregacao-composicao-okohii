package school.sptech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public Biblioteca() {
    }

    public void adicionarLivro(Livro livro) {
        if (!(livro == null)) {
            if (!(livro.getTitulo() == null || livro.getTitulo().isBlank())) {
                if (!(livro.getAutor() == null || livro.getAutor().isBlank())) {
                    if (!(livro.getDataPublicacao() == null)) {
                        livros.add(livro);
                    }
                }
            }
        }
    }

    public void removerLivroPorTitulo(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livros.remove(i);
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (!(titulo == null || titulo.isBlank())) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }
        return null;
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosAteAno = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
              livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        livros.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());
        if (livros.size() >= 5) return livros.subList(0, 5);
        else return livros;
        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}