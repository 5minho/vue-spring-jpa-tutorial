<template>
  <div class="memo-app">
    <memo-form v-on:addMemo="addMemo"/>
    <ul class="memo-list">
      <memo v-for="memo in memos"
            :key="memo.id"
            :memo="memo"
            v-on:deleteMemo="deleteMemo"
            v-on:updateMemo="updateMemo"
            :editing-id="editingId"
            v-on:setEditingId="SET_EDITING_ID"
            v-on:resetEditingId="RESET_EDITING_ID"/>
    </ul>
    <memo/>
  </div>
</template>

<script>
  import MemoForm from "./MemoForm"
  import Memo from "./Memo"
  import {mapActions, mapMutations, mapState} from "vuex"
  import {RESET_EDITING_ID, SET_EDITING_ID} from "../store/mutations-types"

  /**
   * MemoApp 컴포넌트는 Memo 들의 상태 관리를 한다.
   */
  export default {
    name: "MemoApp",
    components: {Memo, MemoForm},
    // 초기화에 필요한 데이터를 created 훅에서 받아오자
    created() {
      this.fetchMemos();
    },
    computed: {
      ...mapState([
        'memos',
        'editingId'
      ])
    },
    methods: {
      ...mapActions([
        'fetchMemos',
        'addMemo',
        'deleteMemo',
        'updateMemo'
      ]),
      ...mapMutations([
        SET_EDITING_ID,
        RESET_EDITING_ID
      ])
    }
  }
</script>

<style scoped>
  .memo-list {
    padding: 20px 0;
    margin: 0;
  }
</style>
