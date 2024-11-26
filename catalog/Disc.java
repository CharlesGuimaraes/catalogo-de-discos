package catalog;

import java.util.List;

public class Disc {
    private String title;
    private int year;
    private List<String> tracks;
    private Artist artist;

    public Disc(String title, int year, List<String> tracks) {
        this.title = title;
        this.year = year;
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(title).append("\n");
        sb.append("Ano de Lançamento: ").append(year).append("\n");
        sb.append("Artista: ").append(artist.getName()).append("\n");
        sb.append("Gênero: ").append(artist.getGenre().getName()).append("\n");
        sb.append("Faixas:\n");
        for (String track : tracks) {
            sb.append("  - ").append(track).append("\n");
        }
        return sb.toString();
    }
}