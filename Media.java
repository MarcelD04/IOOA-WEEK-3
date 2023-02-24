public class Media {
    private String naam;
    private MediaType type;
    private GenreType genre;
    private float rating;
    private int ratingCount;
    private int episodes;
    private String beschrijving;

    public Media(String naam, MediaType type, GenreType genre, float rating, int ratingCount, int episodes, String beschrijving) {
        this.naam = naam;
        this.type = type;
        this.genre = genre;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.episodes = episodes;
        this.beschrijving = beschrijving;
    }

    @Override
    public String toString() {
        return "Media{" +
                "naam='" + naam + '\'' +
                ", type=" + type +
                ", genre=" + genre +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", episodes=" + episodes +
                ", beschrijving='" + beschrijving + '\'' +
                '}';
    }

    public String getNaam(){
        return this.naam;
    }

    public MediaType getType(){
        return this.type;
    }

    public GenreType getGenre(){
        return this.genre;
    }

    public float getRating(){
        return this.rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public double getRatingCount(){
        return this.ratingCount;
    }

    public int getEpisodes(){
        return this.episodes;
    }

    public String getBeschrijving(){
        return this.beschrijving;
    }

}
