package fak.task4.service1.imageservicesavetracing.image;


import fak.task4.service1.imageservicesavetracing.config.TraceBuilder;
import lombok.AllArgsConstructor;
import okhttp3.*;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
public class ImageFileController {

    private ImageFileService imageFileService;
    private final OkHttpClient client;

    @Autowired
    private TraceBuilder traceBuilder;

    private Logger logger;

    @PostMapping("/image")
    public ResponseEntity<String> updateImage(@RequestParam MultipartFile file) throws IOException {
        traceBuilder.waitFor("ImageFileController","updateImage");
        logger.info("in ImageFileController called updateImage");
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
        traceBuilder.waitFor("ImageFileController","getResponse");
        logger.info("in ImageFileController called getResponse");
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
