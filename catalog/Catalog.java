package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Disc> discs;
    private List<Artist> artists;
    private List<Genre> genres;

    public Catalog() {
        this.discs = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public void addDisc(Disc disc) {
        discs.add(disc);
    }

    public void removeDisc(String title) {
        discs.removeIf(d -> d.getTitle().equalsIgnoreCase(title));
    }

    public void editDisc(String oldTitle, String newTitle, int newYear, List<String> newTracks) {
        for (Disc disc : discs) {
            if (disc.getTitle().equalsIgnoreCase(oldTitle)) {
                disc.setTitle(newTitle);
                disc.setYear(newYear);
                disc.setTracks(newTracks);
                break;
            }
        }
    }

    public void displayDiscs() {
        if (discs.isEmpty()) {
            System.out.println("Nenhum disco disponível.");
        } else {
            for (Disc disc : discs) {
                System.out.println(disc);
            }
        }
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void removeArtist(String name) {
        artists.removeIf(a -> a.getName().equalsIgnoreCase(name));
    }

    public void displayArtists() {
        if (artists.isEmpty()) {
            System.out.println("Nenhum artista disponível.");
        } else {
            for (Artist artist : artists) {
                System.out.println(artist);
            }
        }
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(String genreName) {
        genres.removeIf(g -> g.getName().equalsIgnoreCase(genreName));
    }

    public void displayGenres() {
        if (genres.isEmpty()) {
            System.out.println("Nenhum gênero disponível.");
        } else {
            for (Genre genre : genres) {
                System.out.println(genre);
            }
        }
    }
}