package kodlama.io.programmingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLanguages.business.abstracts.ILanguageService;
import kodlama.io.programmingLanguages.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private ILanguageService languageService;
	
	@Autowired
	public LanguagesController(ILanguageService languageService) {
		this.languageService=languageService;
	}

	@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getId/{id}")
	public Language getId( int id) {
		return languageService.getId(id);
	}
	
	@PostMapping("/addLanguage")
	public void add(Language language) {
		languageService.add(language);
	}
	
	@DeleteMapping("/deleteLanguage")
	public void delete(int id) {
		languageService.delete(id);
	}
	
	@PutMapping("/updateLanguage")
	public void update(Language language) {
		languageService.update(language);
	}
}
