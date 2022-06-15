package de.fak.editpicture.edit;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class EditController {

    private EditService editService;



    @PatchMapping("/edit/{id}")
    public ResponseEntity<String> editImage(@PathVariable Long id){

        editService.resizeImage(id);

        return ResponseEntity.ok("Bildbearbeitet");
    }

}
