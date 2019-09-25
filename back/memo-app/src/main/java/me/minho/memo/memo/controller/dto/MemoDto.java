package me.minho.memo.memo.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.minho.memo.memo.domain.Memo;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 25/09/2019.
 */
public class MemoDto {

    @Getter
    public static class Res {
        private List<Memo> memos;

        public Res(List<Memo> memos) {
            this.memos = memos;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SaveReq {
        private String title;
        private String content;

        public Memo toEntity() {
            return Memo.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
