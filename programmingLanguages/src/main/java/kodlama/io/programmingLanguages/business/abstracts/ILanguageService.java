package kodlama.io.programmingLanguages.business.abstracts;

import java.util.List;

import kodlama.io.programmingLanguages.entities.concretes.Language;

public interface ILanguageService {
	List<Language> getAll();
	
	Language getId(int id);
	void add(Language language);
	void update(Language language);
	void delete(int id);
}
