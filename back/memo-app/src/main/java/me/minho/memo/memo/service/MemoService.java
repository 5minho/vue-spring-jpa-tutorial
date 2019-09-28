package me.minho.memo.memo.service;

import me.minho.memo.memo.domain.Memo;
import me.minho.memo.memo.dto.MemoDto;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */
public interface MemoService {
    Memo save(MemoDto.SaveReq memoSaveDto);
    List<Memo> findAll();
}
