package com.exercise.controller;

import com.exercise.model.Music;
import com.exercise.model.MusicForm;
import com.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showListMusic(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("musicForm", new MusicForm());
        return "create";
    }

    @PostMapping("/save")
    public ModelAndView addNewMusic(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusic().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music music = new Music(musicForm.getName(),
                musicForm.getSinger(), musicForm.getType(), fileName);
        iMusicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Thêm mới nhạc thành công !");
        return modelAndView;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        Music music = this.iMusicService.findById(id);
        MusicForm musicForm = new MusicForm(music.getId(), music.getName(), music.getSinger(), music.getType(), music.getLink());
        model.addAttribute("musicForm", musicForm);
        return "edit";
    }

    @PostMapping("/update")
    public String updateMusic(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getMusic();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusic().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music musicUpdate = new Music(musicForm.getId(), musicForm.getName(),
                musicForm.getSinger(), musicForm.getType(), fileName);
        if (musicUpdate.getLink().equals("")) {
            musicUpdate.setLink(musicForm.getLink());
        }
        iMusicService.update(musicUpdate);
        redirectAttributes.addFlashAttribute("message", "Đã chỉnh sửa");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteMusic(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iMusicService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Đã xoá bài hát");
        return "redirect:/";
    }
}
