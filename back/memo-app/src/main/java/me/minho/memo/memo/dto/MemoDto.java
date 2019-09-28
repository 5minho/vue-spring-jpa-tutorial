package me.minho.memo.memo.dto;

import lombok.*;
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
    public static class SaveRes {
        private Long id;
        private String title;
        private String content;

        @Builder
        public SaveRes(Long id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
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

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateReq {
        private String content;
    }
}
