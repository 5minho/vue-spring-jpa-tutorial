package me.minho.memo.memo.repository;

import me.minho.memo.memo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */
public interface MemoRepository extends JpaRepository<Memo, Long> {
}
