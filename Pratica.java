import java.util.ArrayList;
import java.util.Scanner;

public class Pratica {

    class Contato {
        private String nome, email;
        private long telefone;
    
        public contato(String nome, String email, long telefone) {
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public long getTelefone() {
            return telefone;
        }
    
        public void setTelefone(long telefone) {
            this.telefone = telefone;
        }
    
        public String toString() {
            return "Contato{" +
                    "nome='" + nome + '\'' +
                    ", email='" + email + '\'' +
                    ", telefone=" + telefone +
                    '}';
        }
    }
    class Agenda {
    private ArrayList<Contato> contatos;
    private int tamanho;

    public Agenda() {
        this.contatos = new ArrayList<>();
        this.tamanho = 0;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        tamanho++;
    }

    public boolean removerContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                tamanho--;
                return true;
            }
        }
        return false;
    }

    public Contato pesquisarContatoPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato pesquisarContatoPorEmail(String email) {
        for (Contato contato : contatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato pesquisarContatoPorTelefone(long telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone() == telefone) {
                return contato;
            }
        }
        return null;
    }

    public int getTamanho() {
        return tamanho;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Procurar contato por nome");
            System.out.println("4. Procurar contato por email");
            System.out.println("5. Procurar contato por telefone");
            System.out.println("6. Verificar tamanho da Agenda");
            System.out.println("7. Finalizar o programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    long telefone = scanner.nextLong();
                    scanner.nextLine();
                    agenda.adicionarContato(new contato(nome, email, telefone));
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Nome do contato a remover: ");
                    nome = scanner.nextLine();
                    if (agenda.removerContato(nome)) {
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 3:
                    System.out.print("Nome do contato a procurar: ");
                    nome = scanner.nextLine();
                    Contato contato = agenda.pesquisarContatoPorNome(nome);
                    if (contato != null) {
                        System.out.println("Contato encontrado: " + contato);
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 4:
                    System.out.print("Email do contato a procurar: ");
                    email = scanner.nextLine();
                    contato = agenda.pesquisarContatoPorEmail(email);
                    if (contato != null) {
                        System.out.println("Contato encontrado: " + contato);
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 5:
                    System.out.print("Telefone do contato a procurar: ");
                    telefone = scanner.nextLong();
                    scanner.nextLine();
                    contato = agenda.pesquisarContatoPorTelefone(telefone);
                    if (contato != null) {
                        System.out.println("Contato encontrado: " + contato);
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                case 6:
                    System.out.println("Tamanho da Agenda: " + agenda.getTamanho());
                    break;
                case 7:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
