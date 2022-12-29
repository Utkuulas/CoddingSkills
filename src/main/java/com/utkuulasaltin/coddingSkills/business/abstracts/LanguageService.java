package com.utkuulasaltin.coddingSkills.business.abstracts;

import com.utkuulasaltin.coddingSkills.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    void add(Language language);

    void update(Language language);

    void delete(int id);

    List<Language> getAll();

    Language getById(int id);
}
