package me.minho.memo.memo.service;

import me.minho.memo.memo.controller.dto.MemoDto;
import me.minho.memo.memo.domain.Memo;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */
public interface MemoService {
    void save(MemoDto.SaveReq memoSaveDto);
    List<Memo> findAll();
}
