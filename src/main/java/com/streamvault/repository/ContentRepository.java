package com.streamvault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.streamvault.entity.Content;

public interface ContentRepository extends JpaRepository<Content, Long>{

}
