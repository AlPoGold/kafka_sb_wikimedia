package org.example.springboot.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wikimedia_recentchange")
@Getter
@Setter
public class WikimediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;
}
