package sg.edu.nus.iss.day21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.edu.nus.iss.day21.model.Comment;
import sg.edu.nus.iss.day21.model.Game;
import sg.edu.nus.iss.day21.repositories.GameRepository;

@SpringBootTest
class Day21ApplicationTests {

	@Autowired 
	private GameRepository gameRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnAGame(){
		Optional<Game> opt = gameRepo.getGameByGid(10);
		assertTrue(opt.isPresent(), "gid = 10");
	}

	@Test
	void shouldReturnEmpty(){
		Optional<Game> opt = gameRepo.getGameByGid(10000);
		assertFalse(opt.isPresent(), "gid = 10000");
	}


	@Test
	void shouldReturnAComment(){
		List<Comment> opt = gameRepo.getCommentByGid(10);
		assertEquals(42, opt.size(), "number of comments for gid = 10 is 42");
	}

}
