package com.utkuulasaltin.coddingSkills.dataAccess.abstracts;

import com.utkuulasaltin.coddingSkills.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    void add(Language language);
    void update(Language language);
    void delete(int id);
    List<Language> getAll();
    Language getById(int id);
}
