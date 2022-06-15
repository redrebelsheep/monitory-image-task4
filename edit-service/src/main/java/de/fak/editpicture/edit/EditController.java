package de.fak.editpicture.edit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
public class EditController {

    private EditService editService;

    public EditController(EditService editService) {
        this.editService = editService;
    }

    @PatchMapping("/edit/{id}")
    void editImage(@PathVariable Long id){


    }

}
