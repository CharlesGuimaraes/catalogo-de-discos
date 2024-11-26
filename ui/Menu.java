package ui;

import catalog.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Catalog catalog;
    private Scanner scanner;

    public Menu() {
        this.catalog = new Catalog();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Adicionar Disco");
            System.out.println("2. Editar Disco");
            System.out.println("3. Remover Disco");
            System.out.println("4. Ver Discos");
            System.out.println("5. Adicionar Artista");
            System.out.println("6. Remover Artista");
            System.out.println("7. Ver Artistas");
            System.out.println("8. Adicionar Gênero");
            System.out.println("9. Remover Gênero");
            System.out.println("10. Ver Gêneros");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDisc();
                    break;
                case 2:
                    editDisc();
                    break;
                case 3:
                    removeDisc();
                    break;
                case 4:
                    catalog.displayDiscs();
                    break;
                case 5:
                    addArtist();
                    break;
                case 6:
                    removeArtist();
                    break;
                case 7:
                    catalog.displayArtists();
                    break;
                case 8:
                    addGenre();
                    break;
                case 9:
                    removeGenre();
                    break;
                case 10:
                    catalog.displayGenres();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void addDisc() {
        System.out.print("Digite o título do disco: ");
        String title = scanner.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o nome do artista: ");
        String artistName = scanner.nextLine();

        System.out.print("Digite o gênero musical: ");
        String genreName = scanner.nextLine();

        System.out.print("Digite as faixas (separadas por vírgula): ");
        String tracksInput = scanner.nextLine();
        List<String> tracks = Arrays.asList(tracksInput.split(","));

        Genre genre = new Genre(genreName);
        Artist artist = new Artist(artistName, genre);
        Disc disc = new Disc(title, year, tracks);
        disc.setArtist(artist);

        catalog.addDisc(disc);
        System.out.println("Disco adicionado com sucesso.");
    }

    private void editDisc() {
        System.out.print("Digite o título do disco a ser editado: ");
        String oldTitle = scanner.nextLine();

        System.out.print("Digite o novo título: ");
        String newTitle = scanner.nextLine();
        System.out.print("Digite o novo ano: ");
        int newYear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite as novas faixas (separadas por vírgula): ");
        String tracksInput = scanner.nextLine();
        List<String> newTracks = Arrays.asList(tracksInput.split(","));

        catalog.editDisc(oldTitle, newTitle, newYear, newTracks);
        System.out.println("Disco atualizado com sucesso.");
    }

    private void removeDisc() {
        System.out.print("Digite o título do disco a ser removido: ");
        String title = scanner.nextLine();
        catalog.removeDisc(title);
        System.out.println("Disco removido com sucesso.");
    }

    private void addArtist() {
        System.out.print("Digite o nome do artista: ");
        String name = scanner.nextLine();

        System.out.print("Digite o gênero do artista: ");
        String genreName = scanner.nextLine();
        Genre genre = new Genre(genreName);

        Artist artist = new Artist(name, genre);
        catalog.addArtist(artist);
        System.out.println("Artista adicionado com sucesso.");
    }

    private void removeArtist() {
        System.out.print("Digite o nome do artista a ser removido: ");
        String name = scanner.nextLine();
        catalog.removeArtist(name);
        System.out.println("Artista removido com sucesso.");
    }

    private void addGenre() {
        System.out.print("Digite o nome do gênero: ");
        String genreName = scanner.nextLine();
        Genre genre = new Genre(genreName);
        catalog.addGenre(genre);
        System.out.println("Gênero adicionado com sucesso.");
    }

    private void removeGenre() {
        System.out.print("Digite o nome do gênero a ser removido: ");
        String genreName = scanner.nextLine();
        catalog.removeGenre(genreName);
        System.out.println("Gênero removido com sucesso.");
    }
}