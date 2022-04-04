package sg.edu.nus.iss.day21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {
    private Integer gameId;
    private String image;
    private String name;
    private Integer ranking;
    private Integer year;
    private Integer usersRated;
    private String url;

    
    
    public Integer getGameId() {
        return gameId;
    }



    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }



    public String getImage() {
        return image;
    }



    public void setImage(String image) {
        this.image = image;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public Integer getRanking() {
        return ranking;
    }



    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }



    public Integer getYear() {
        return year;
    }



    public void setYear(Integer year) {
        this.year = year;
    }



    public Integer getUsersRated() {
        return usersRated;
    }



    public void setUsersRated(Integer usersRated) {
        this.usersRated = usersRated;
    }



    public String getUrl() {
        return url;
    }



    public void setUrl(String url) {
        this.url = url;
    }


    public static Game create(SqlRowSet rs){
        Game game = new Game();
        game.setGameId(rs.getInt("gid"));
        game.setImage(rs.getString("image"));
        game.setName(rs.getString("name"));
        game.setRanking(rs.getInt("ranking"));
        game.setUrl(rs.getString("url"));
        game.setUsersRated(rs.getInt("users_rated"));
        game.setYear(rs.getInt("year"));

        return game;
    }

}

