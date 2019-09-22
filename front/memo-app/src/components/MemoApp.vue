<template>
  <div class="memo-app">
    <memo-form v-on:addMemo="addMemo"/>
    <ul class="memo-list">
      <memo v-for="memo in memos"
            :key="memo.id"
            :memo="memo"
            v-on:deleteMemo="deleteMemo"
            v-on:updateMemo="updateMemo"/>
    </ul>
    <memo/>
  </div>
</template>

<script>
  import MemoForm from "./MemoForm"
  import Memo from "./Memo"

  /**
   * MemoApp 컴포넌트는 Memo 들의 상태 관리를 한다.
   */
  export default {
    name: "MemoApp",
    components: {Memo, MemoForm},
    data() {
      return {
        memos: []
      }
    },
    // 초기화에 필요한 데이터를 created 훅에서 받아오자
    created() {
      this.memos = localStorage.memos ? JSON.parse(localStorage.memos) : []
    },

    methods: {
      addMemo(payload) {
        this.memos.push(payload);
        this.storeMemo();
      },
      storeMemo() {
        const memosToString = JSON.stringify(this.memos);
        localStorage.setItem('memos', memosToString);
      },
      deleteMemo(id) {
        const targetIndex = this.memos.findIndex(v => v.id === id);
        this.memos.splice(targetIndex, 1);
        this.storeMemo();
      },
      updateMemo(payload) {
        const {id, content} = payload;
        const targetIndex = this.memos.findIndex(v => v.id === id);
        const targetMemo = this.memos[targetIndex];
        this.memos.splice(targetIndex, 1, {...targetMemo, content});
        this.storeMemo();
      }
    }
  }
</script>

<style scoped>
  .memo-list {
    padding: 20px 0;
    margin: 0;
  }
</style>
