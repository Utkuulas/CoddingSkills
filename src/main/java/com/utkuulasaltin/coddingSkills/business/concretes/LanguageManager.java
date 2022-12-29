package com.utkuulasaltin.coddingSkills.business.concretes;

import com.utkuulasaltin.coddingSkills.business.abstracts.LanguageService;
import com.utkuulasaltin.coddingSkills.dataAccess.abstracts.LanguageRepository;
import com.utkuulasaltin.coddingSkills.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void add(Language language) {
        if (isValidLanguage(language)) {
            languageRepository.add(language);
        }
    }

    @Override
    public void update(Language language) {
        if (languageRepository.getById(language.getId()) != null && isValidLanguage(language)) {
            languageRepository.update(language);
        }
    }

    @Override
    public void delete(int id) {
        if (languageRepository.getById(id) != null) {
            languageRepository.delete(id);
        }
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    private boolean isValidLanguage(Language language) {
        if (language.getName().isBlank()) {
            return false;
        }

        for (Language languageItem : languageRepository.getAll()) {
            if (languageItem.getName().equalsIgnoreCase(language.getName())) {
                return false;
            }
        }

        return true;
    }
}
