package com.utkuulasaltin.coddingSkills.dataAccess.concretes;

import com.utkuulasaltin.coddingSkills.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements com.utkuulasaltin.coddingSkills.dataAccess.abstracts.LanguageRepository {

    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void update(Language language) {
        languages.set(language.getId() - 1, language);
    }

    @Override
    public void delete(int id) {
        languages.remove(id - 1);
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        return languages.get(id - 1);
    }
}
