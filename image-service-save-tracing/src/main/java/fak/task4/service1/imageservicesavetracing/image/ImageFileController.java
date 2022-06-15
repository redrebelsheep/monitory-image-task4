package fak.task4.service1.imageservicesavetracing.image;


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

    @PostMapping("/image")
    public ResponseEntity<String> updateImage(@RequestParam MultipartFile file){
        imageFileService.saveImage(file);
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
