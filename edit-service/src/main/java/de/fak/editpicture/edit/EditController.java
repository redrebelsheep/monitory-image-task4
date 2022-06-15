package de.fak.editpicture.edit;

import de.fak.editpicture.config.TraceBuilder;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    private Logger logger;

    @Autowired
    private TraceBuilder traceBuilder;

    @GetMapping("/view/{id}")
    public ResponseEntity<ImageSize> getImageSizeById(@PathVariable Long id) {
        logger.info("in ImageFileController called updateImage");
        traceBuilder.waitFor("EditController","getImageSizeById");
        Optional<ImageSize> optionalImageSize = editService.getImageSizeById(id);
        return ResponseEntity.ok(optionalImageSize.get());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> editImage(@PathVariable Long id) {
        logger.info("in ImageFileController called editImage");
        traceBuilder.waitFor("EditController","editImage");
        editService.resizeImage(id);
      //  return ResponseEntity.created(URI.create("http://Localhost:8082/view/" +id)).build();
        return ResponseEntity.accepted().build();
    }

}
