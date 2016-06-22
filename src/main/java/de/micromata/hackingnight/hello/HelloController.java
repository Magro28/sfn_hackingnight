package de.micromata.hackingnight.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mario on 22.06.2016.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {


    /**
     *
     * Ein Beispiel für einen (optionalen) Request-Parameter
     * Z.B:
     * http://localhost:8080/hello?name=Mario
     *
     * @param name //der request parameter in der url
     * @param model //das Standard Thymeleafmodel
     * @return hello template
     */
    @RequestMapping(method = RequestMethod.GET)
    String helloRequestParam(@RequestParam(required=false) String name, Model model) {

        //wenn der request parameter nicht übergeben wurde benutze einen default wert
        if (name==null){
            name= "mysterious person";
        }
        model.addAttribute("name", name);

        return "hello";
    }

    /**
     *
     * Ein Beispiel für einen Pfad-Parameter
     * Z.B:
     * http://localhost:8080/hello/Mario
     *
     * @param name //der pfadparameter in der url
     * @param model //das standard Thymeleafmodel
     * @return hello template
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    String helloPath(@PathVariable String name, Model model) {

        model.addAttribute("name", name);
        return "hello";
    }




}
