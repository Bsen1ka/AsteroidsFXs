package dk.sdu.cbse.scoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
public class ScoringSystem {
    private int totalscore = 0;
    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }
    @GetMapping("/Score")
    public int score(@RequestParam (value = "point") int score) {
        totalscore += score;
        return totalscore;
    }
}
