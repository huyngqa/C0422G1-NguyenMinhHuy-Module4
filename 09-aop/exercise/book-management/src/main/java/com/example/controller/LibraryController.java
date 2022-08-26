package com.example.controller;

import com.example.model.Book;
import com.example.model.BookCard;
import com.example.service.IBookCardService;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBookCardService iBookCardService;

    @GetMapping(value = {"", "/list"})
    public String goHome(Model model) {
        model.addAttribute("books", iBookService.findAllBook());
        return "index";
    }

    @GetMapping("/details")
    public String showDetailsBook(@RequestParam String id, Model model) {
        Book book = iBookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookcard", new BookCard(book));
        return "details";
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute(name = "bookcard") BookCard bookCard,
                           RedirectAttributes redirectAttributes) {
        Book book = iBookService.findBookById(bookCard.getBook().getId());
        book.setAmount(book.getAmount() - 1);
        iBookService.saveBook(book);
        iBookCardService.saveBookCard(bookCard);
        redirectAttributes.addFlashAttribute("message", "Đã thuê sách: " + book.getName());
        return "redirect:/list";
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam int id,
                          RedirectAttributes redirectAttributes) throws Exception {
        BookCard bookCard = iBookCardService.getById(id);
        if(bookCard == null) {
            throw new Exception();
        }
        Book book = bookCard.getBook();
        book.setAmount(book.getAmount() + 1);
        iBookCardService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Đã trả sách");
        return "redirect:/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String goError() {
        return "error404";
    }
}
