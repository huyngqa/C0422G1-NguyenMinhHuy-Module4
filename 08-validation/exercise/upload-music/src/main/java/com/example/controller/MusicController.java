package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {
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
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String addNewMusic(@ModelAttribute @Valid MusicDto musicDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("messages", "Thêm mới thành công");
        return "redirect:";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam int id, Model model) {
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(iMusicService.findById(id), musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/update")
    public String updateMusic(@ModelAttribute @Valid MusicDto musicDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("messages", "Cập nhật thành công");
        return "redirect:";
    }

    @GetMapping("/delete")
    public String deleteMusic(@RequestParam int id, RedirectAttributes redirectAttributes) {
        iMusicService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "Đã xoá bài hát");
        return "redirect:/";
    }
}
