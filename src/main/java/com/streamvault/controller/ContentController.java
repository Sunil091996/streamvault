package com.streamvault.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.streamvault.entity.Content;
import com.streamvault.service.ContentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

	private final ContentService contentService;

	@GetMapping
	public List<Content> getAllContents() {
		return contentService.getAllContents();
	}

	@GetMapping("/{id}")
	public Content getContentById(@PathVariable Long id) {
		return contentService.getContentById(id);
	}

	@PostMapping
	public Content createContent(@RequestBody Content content) {
		return contentService.createContent(content);
	}

	@PutMapping("/{id}")
	public Content updateContent(@PathVariable Long id, @RequestBody Content content) {
		return contentService.updateContent(id, content);
	}

	@DeleteMapping("/{id}")
	public void deleteContent(@PathVariable Long id) {
		contentService.deleteContent(id);
	}

}
