package kodlama.io.programmingLanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.programmingLanguages.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.programmingLanguages.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements ILanguageRepository{
	
	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "Python"));
		languages.add(new Language(3, "C++"));
		languages.add(new Language(4, "Flutter"));
		languages.add(new Language(5, "C#"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getId(int id) {
		for(Language lng: languages) {
			if(lng.getId() ==id) {
				return lng;
			}
		}
		return null;
	}

	@Override
	public void add(Language language) {
		languages.add(language);
	}

	@Override
	public void update(Language language) {
		for(Language lng :languages) {
			if(language.getId() == lng.getId()) {
				lng.setId(language.getId());
				lng.setName(language.getName());
			}
		}
		
	}

	@Override
	public void delete(int id) {
		for(Language lng : languages) {
			if(lng.getId() ==id) {
				languages.remove(id);
			}
		}
	}

}
