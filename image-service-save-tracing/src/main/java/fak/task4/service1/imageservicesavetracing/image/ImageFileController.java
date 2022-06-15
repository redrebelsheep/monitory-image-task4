package fak.task4.service1.imageservicesavetracing.image;


import lombok.AllArgsConstructor;
import okhttp3.*;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;

@AllArgsConstructor
@RestController
public class ImageFileController {

    private ImageFileService imageFileService;
    private final OkHttpClient client;

    @PostMapping("/image")
    public ResponseEntity<String> updateImage(@RequestParam MultipartFile file) throws IOException {
       long id =  imageFileService.saveImage(file);
        Response response = getResponse(id);
        response.code();
        System.out.println(response.code());
        if(response.code() == 202){
            return ResponseEntity.accepted().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @NotNull
    private Response getResponse(Long id) throws IOException {
        HttpUrl route = HttpUrl.parse("http://localhost:8082/edit/" + id);
        RequestBody formBody = new FormBody.Builder()
                .add("id", String.valueOf(id))
                .build();

        Request request = new Request.Builder()
                .url(route)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        return response;
    }


//    @GetMapping("/image/{id}")
//    public ResponseEntity<Resource> getImageByName(@PathVariable long id){
//        Resource fileSystemResource = imageFileService.getImageById(id);
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG)
//                .body(fileSystemResource);
//    }


}
