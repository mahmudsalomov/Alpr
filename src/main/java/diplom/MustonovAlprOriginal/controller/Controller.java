package diplom.MustonovAlprOriginal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@CrossOrigin(origins = "https://api.platerecognizer.com/v1/plate-reader/")
public class Controller {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/v")
    public String v(){
        return "main";
    }
}
