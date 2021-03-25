package lab2.lab2.WebRestControllers;

import lab2.lab2.Model.Book;
import lab2.lab2.Model.Type;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryControllerREStAPI {


    @GetMapping
    private List<Type> findAll() {
        List<Type> categories= new ArrayList<>();
        categories.add(Type.BIOGRAPHY);
        categories.add(Type.CLASSICS);
        categories.add(Type.DRAMA);
        categories.add(Type.FANTASY);
        categories.add(Type.HISTORY);
        categories.add(Type.NOVEL);
        categories.add(Type.THRILER);


        return categories;

    }

}
