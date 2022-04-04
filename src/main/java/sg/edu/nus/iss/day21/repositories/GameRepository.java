package sg.edu.nus.iss.day21.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day21.model.Comment;
import sg.edu.nus.iss.day21.model.Game;

import static sg.edu.nus.iss.day21.repositories.Queries.*;

@Repository
public class GameRepository {


    

    @Autowired
    private JdbcTemplate template;

    public List<Comment> getCommentByGid(Integer gid){
        return getCommentByGid(gid, 0, Integer.MAX_VALUE);
    }

    public List<Comment> getCommentByGid(Integer gid, Integer limit, Integer offset) {
        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_COMMENT_BY_GID, gid, limit, offset);
        //never concatenate sql statement e.g. statement + gid 

        List<Comment> comments = new ArrayList<Comment>();

        while(result.next()){
            Comment comment = Comment.create(result);
            comments.add(comment);
        }

        return comments;
        
    }

    public Optional<Game> getGameByGid(Integer queryGid){
        final SqlRowSet result = template.queryForRowSet(SQL_SELECT_GAME_BY_GID, queryGid);
        //never concatenate sql statement e.g. statement + gid 

        if(!result.next()){
            return Optional.empty();
        }

        return Optional.of(Game.create(result));

    }
}
