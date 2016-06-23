package de.micromata.hackingnight.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mgross on 23.06.16.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    /**
     * @return game template
     */
    @RequestMapping(method = RequestMethod.GET)
    String game() {

        return "game";
    }
}
