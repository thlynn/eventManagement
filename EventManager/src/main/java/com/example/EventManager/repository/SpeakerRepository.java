package com.example.EventManager.repository;

import com.example.EventManager.models.speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<speaker,Integer> {
}
