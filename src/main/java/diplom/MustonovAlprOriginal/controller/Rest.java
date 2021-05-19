package diplom.MustonovAlprOriginal.controller;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class Rest {


    public String generate(){
        SecureRandom random = new SecureRandom();
        return new BigInteger(30, random).toString(32).toUpperCase();
    }
    public String convert(MultipartFile file) throws IOException {
        File convFile = new File(generate()+Objects.requireNonNull(file.getOriginalFilename()));
        try(InputStream is = file.getInputStream()) {
            Files.copy(is, convFile.toPath());
        }
        return convFile.getName();
    }
    @PostMapping("upload")
    public HttpEntity<?> upload(@RequestBody MultipartFile[] upload) throws IOException {
//        String image=fileStorageService.save(multipartFile);
//        System.out.println(upload.length);
//        System.out.println(upload[0].getName());
//        System.out.println(upload[0].getOriginalFilename());
//        System.out.println(upload[0].getContentType());
//        System.out.println(upload[0].getInputStream());
        String resp="";
//        System.out.println(new File(convert(upload[0])));
        String token = "7e759aefd90e3262d59172c13092873a9cf0bdc5";
        try{
            File file=new File(convert(upload[0]));
            HttpResponse<String> response = Unirest.post("https://api.platerecognizer.com/v1/plate-reader/")
                    .header("Authorization", "Token " + token)
                    .field("upload", file)
                    .field("regions","gb")
//                    .contentType("multipart/form-data")
                    .asString();
//            System.out.println("Recognize:");
//            System.out.println(response.getBody().toString());
            resp=response.getBody();
            file.delete();
        }
        catch(Exception e){
            e.printStackTrace();
//            System.out.println(e);
        }

//        try{
//            HttpResponse<String> res = Unirest.get("https://api.platerecognizer.com/v1/statistics/")
//                    .header("Authorization", "Token " + token)
//                    .asString();
//            System.out.println("Usage:");
//            System.out.println(res.getBody().toString());
//        }
//        catch(Exception e){
//            e.printStackTrace();
////            System.out.println(e);
//        }
        return ResponseEntity.ok(resp);
    }
}
