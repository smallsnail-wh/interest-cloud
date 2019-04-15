package com.interest.blog.picture;

import com.interest.blog.picture.PictureService;
import com.interest.common.model.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/picture")
    public ResponseWrapper<String> uploadPicture(@RequestParam("picture") MultipartFile picture) {

        String pictureUrl = pictureService.saveImage(picture);

        return new ResponseWrapper<>(pictureUrl);
    }

}
