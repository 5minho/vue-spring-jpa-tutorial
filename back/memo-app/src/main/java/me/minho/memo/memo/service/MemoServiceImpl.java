package me.minho.memo.memo.service;

import lombok.RequiredArgsConstructor;
import me.minho.memo.memo.domain.Memo;
import me.minho.memo.memo.dto.MemoDto;
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
    public Memo save(MemoDto.SaveReq memoSaveDto) {
        return memoRepository.save(memoSaveDto.toEntity());
    }

    @Override
    public void update(Long id, MemoDto.UpdateReq memoUpdateDto) {
        Memo memo = memoRepository.findById(id).orElseThrow();
        memo.update(memoUpdateDto.getContent());
        memoRepository.save(memo);
    }

    @Override
    public void deleteById(Long id) {
        memoRepository.deleteById(id);
    }

    @Override
    public List<Memo> findAll() {
        return memoRepository.findAll();
    }
}
