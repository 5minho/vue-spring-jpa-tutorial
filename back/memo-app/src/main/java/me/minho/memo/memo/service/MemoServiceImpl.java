package me.minho.memo.memo.service;

import lombok.RequiredArgsConstructor;
import me.minho.memo.memo.controller.dto.MemoDto;
import me.minho.memo.memo.domain.Memo;
import me.minho.memo.memo.repository.MemoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */

@Primary
@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    @Override
    public void save(MemoDto.SaveReq memoSaveDto) {
        memoRepository.save(memoSaveDto.toEntity());
    }

    @Override
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
}
