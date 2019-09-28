package me.minho.memo.memo.controller;

import lombok.RequiredArgsConstructor;
import me.minho.memo.memo.domain.Memo;
import me.minho.memo.memo.dto.MemoDto;
import me.minho.memo.memo.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */

@RestController
@RequiredArgsConstructor
public class MemoApiController {

    private final MemoService memoService;

    @GetMapping("/api/memos")
    public ResponseEntity<MemoDto.Res> fetchMemos() {
        return ResponseEntity.ok(new MemoDto.Res(memoService.findAll()));
    }

    @PostMapping("/api/memos")
    public ResponseEntity<MemoDto.SaveRes> saveMemo(@RequestBody MemoDto.SaveReq saveReq) {
        Memo memo = memoService.save(saveReq);
        return new ResponseEntity<>(MemoDto.SaveRes.builder()
                .id(memo.getId())
                .content(memo.getContent())
                .title(memo.getTitle())
                .build(),
                HttpStatus.CREATED);
    }
}