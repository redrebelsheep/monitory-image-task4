package de.fak.editpicture.image;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@AllArgsConstructor
@RestController
public class ImageFileController {

    private ImageFileService imageFileService;

    @PostMapping("/image/{id}")
    public ResponseEntity<String> updateImage(@RequestParam MultipartFile file,@PathVariable Long id){
        imageFileService.saveImage(file,id);
        return ResponseEntity.ok("Okay");
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getImageByName(@PathVariable long id){
        Resource fileSystemResource = imageFileService.getImageById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileSystemResource);
    }


}
