<template>
  <div class="memo-app">
    <memo-form v-on:addMemo="addMemo"/>
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
      }
    }
  }
</script>

<style scoped>

</style>
