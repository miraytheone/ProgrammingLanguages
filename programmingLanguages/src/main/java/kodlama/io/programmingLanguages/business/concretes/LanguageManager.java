package kodlama.io.programmingLanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLanguages.business.abstracts.ILanguageService;
import kodlama.io.programmingLanguages.dataAccess.abstracts.ILanguageRepository;
import kodlama.io.programmingLanguages.entities.concretes.Language;

@Service
public class LanguageManager implements ILanguageService{

	private ILanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(ILanguageRepository languageRepository) {
		this.languageRepository=languageRepository;
	}
	
	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}
	
	
	@Override
	public Language getId(int id) {
		return languageRepository.getId(id);
	}
	
	
	@Override
	public void add(Language language) {
		if(!language.getName().isEmpty()) {
			for(Language lng : languageRepository.getAll()) {
				if(lng.getName() == language.getName()) {
					System.out.println("This programmin language name is already in the database.");
				}else {
					languageRepository.add(language);
				}
			}
			
		}else {
			System.out.println("Name field cannot be empty");
		}
		
	}
	
	
	@Override
	public void update(Language language) {
		if(!language.getName().isEmpty()) {
			languageRepository.update(language);
		}else {
			System.out.println("Name field cannot be empty.");
		}
		
	}
	
	
	@Override
	public void delete(int id) {
		languageRepository.delete(id);
		
	}

}
