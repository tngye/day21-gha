package sg.edu.nus.iss.day21.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.day21.model.Comment;
import sg.edu.nus.iss.day21.model.Game;
import sg.edu.nus.iss.day21.repositories.GameRepository;

@Controller
@RequestMapping("/game")
public class GameController {
    
@Autowired
public GameRepository gamerepo;

    @GetMapping("/{gid}")
    public String getGame(@PathVariable int gid, Model model){
        Optional<Game> opt = gamerepo.getGameByGid(gid);
        Game game = new Game();

        if(opt !=null){
            game = opt.get();
        }

        model.addAttribute("game", game);

        List<Comment> cmt = gamerepo.getCommentByGid(gid);
        model.addAttribute("comment", cmt);
        
        return "getGame";
    }
}
