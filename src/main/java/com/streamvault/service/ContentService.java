package com.streamvault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.streamvault.entity.Content;
import com.streamvault.repository.ContentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ContentService {

	private final ContentRepository contentRepository;

	public List<Content> getAllContents() {
		return contentRepository.findAll();
	}

	public Content getContentById(Long id) {
		return contentRepository.findById(id).orElseThrow(() -> new RuntimeException("Content was not found"));
	}

	public Content createContent(Content content) {
		return contentRepository.save(content);
	}

	public Content updateContent(Long id, Content content) {
		Content contentFromDB = getContentById(id);

		contentFromDB.setTitle(content.getTitle());
		contentFromDB.setType(content.getType());
		contentFromDB.setGenre(content.getGenre());
		contentFromDB.setLanguage(content.getLanguage());
		contentFromDB.setTier(content.getTier());
		contentFromDB.setReleaseDate(content.getReleaseDate());
		return contentRepository.save(contentFromDB);

	}

	public void deleteContent(Long id) {
		contentRepository.deleteById(id);
	}

}
