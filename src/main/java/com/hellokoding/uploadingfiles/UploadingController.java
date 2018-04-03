package com.hellokoding.uploadingfiles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadingController {
    public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";
    final static String dirImage = "D:\\home\\sharejee-prepare-teach\\pdf4\\uploadingfiles-springboot\\src\\main\\resources\\";

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String uploading(Model model) {
        File file = new File(dirImage);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(dirImage + uploadedFile.getOriginalFilename());
            uploadedFile.transferTo(file);
        }

        return "redirect:/";
    }
}
