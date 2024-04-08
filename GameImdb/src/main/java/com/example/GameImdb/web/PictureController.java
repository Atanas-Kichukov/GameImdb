package com.example.GameImdb.web;

import com.example.GameImdb.model.binding.PictureBindingModel;
import com.example.GameImdb.model.entity.PictureEntity;
import com.example.GameImdb.model.view.PictureViewModel;
import com.example.GameImdb.repository.PictureRepository;
import com.example.GameImdb.service.CloudinaryService;

import com.example.GameImdb.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PictureController {
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;
    private final PictureService pictureService;

    //TODO delete the repo and initialise the methods there and in the service
    public PictureController(CloudinaryService cloudinaryService, PictureRepository pictureRepository, PictureService pictureService) {
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
        this.pictureService = pictureService;
    }

    @GetMapping("/pictures/add")
    public String addPicture() {

        return "add";
    }


    @PostMapping("/pictures/add")
    public String addPicture(PictureBindingModel pictureBindingModel) throws IOException {
        PictureEntity pictureEntity = pictureService.createPictureEntity(pictureBindingModel.getPicture());
        pictureRepository.save(pictureEntity);
        return "redirect:/pictures/all";
    }


    @GetMapping("/pictures/all")
    public String all(Model model) {
        List<PictureViewModel> pictures = pictureRepository.findAll().stream()
                .map(this::asViewModel).collect(Collectors.toList());
        model.addAttribute("pictures", pictures);
        return "all";
    }

    @Transactional
    @DeleteMapping("/pictures/delete")
    public String delete(@RequestParam(name = "public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            pictureRepository.deleteAllByPublicId(publicId);
        }
        return "redirect:/pictures/all";
    }


    private PictureViewModel asViewModel(PictureEntity picture) {
        return new PictureViewModel()
                .setPublicId(picture.getPublicId())
                .setUrl(picture.getUrl());
        //TODO do this with modelmapper
    }
}