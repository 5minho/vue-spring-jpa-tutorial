package me.minho.memo.memo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */

@Getter
@Entity
@NoArgsConstructor
public class Memo {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 300, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Builder
    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
