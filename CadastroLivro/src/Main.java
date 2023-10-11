import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem Vindo ao sistema de cadastro de Livros");

        ArrayList<Livro> listaLivro = new ArrayList<>();

        Scanner leitor = new Scanner(System.in);

        String opcao;
        do{
            System.out.println("Digite uma opcao: 1-Cadastrar Livro / 2-Listar Livro / 0-Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":

                    Livro novoLivro = new Livro();

                    System.out.println("Digite o titulo do livro");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.println("Digite o Autor ");
                    novoLivro.nome = leitor.nextLine();

                    System.out.println("Digite o Preco ");
                    novoLivro.preco = leitor.nextFloat();

                    System.out.println("Digite a data de Lancamento: (dd/mm/aaaa)");
                    novoLivro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period dataAtual = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (dataAtual.getYears() > 5) {
                        System.out.println("Data Valida");
                    } else {
                        System.out.println("Digite data de Lancamento maior que 5 anos");
                        break;
                    }

                    listaLivro.add(novoLivro);

                    System.out.println("Cadastro realizado com sucesso!");

                    break;
                case "2":

                    if (listaLivro.size() > 0) {

                        for (Livro cadaLivro : listaLivro) {
                            System.out.println("titulo: " + cadaLivro.titulo);
                            System.out.println("Nome: " + cadaLivro.nome);
                            System.out.println("Preco: " + cadaLivro.preco);
                            System.out.println("Data da Lancamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine(); // so para para o sistema.
                        }

                    } else {
                        System.out.println("Lista Vazia!'");
                    }
                    break;
                case "0":
                    System.out.println("Voltar");
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}