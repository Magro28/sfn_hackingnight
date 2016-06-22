package de.micromata.hackingnight.input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mario on 22.06.2016.
 */
@Controller
@RequestMapping("/input")
public class InputController {

    @RequestMapping(method =  RequestMethod.GET)
    public String inputForm(){

        //gibt das inputForm template zurück
        return "inputForm";
    }

    @RequestMapping(value="/send", method =  RequestMethod.POST)
    public String inputSend(@ModelAttribute InputModel inputModel, Model model){

        model.addAttribute("inputModel",inputModel);

        //gibt das inputResult template zurück
        return "inputResult";
    }

}
