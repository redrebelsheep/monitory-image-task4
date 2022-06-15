package de.fak.editpicture.edit;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class EditController {

    private EditService editService;

    @GetMapping("/view/{id}")
    public ResponseEntity<ImageSize> getImageSizeById(@PathVariable Long id) {
        Optional<ImageSize> optionalImageSize = editService.getImageSizeById(id);
        return ResponseEntity.ok(optionalImageSize.get());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> editImage(@PathVariable Long id) {
        editService.resizeImage(id);
      //  return ResponseEntity.created(URI.create("http://Localhost:8082/view/" +id)).build();
        return ResponseEntity.accepted().build();
    }

}
