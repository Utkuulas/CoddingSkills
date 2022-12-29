package com.utkuulasaltin.coddingSkills.webApi.controllers;

import com.utkuulasaltin.coddingSkills.business.abstracts.LanguageService;
import com.utkuulasaltin.coddingSkills.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping("/create")
    public void add(@RequestBody Language language) {
        languageService.add(language);
    }

    @PutMapping("/update")
    public void update(@RequestBody Language language) {
        languageService.update(language);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }

}
