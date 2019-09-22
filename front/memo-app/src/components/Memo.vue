<template>
  <li class="memo-item">
    <strong>{{memo.title}}</strong>
    <p v-on:dblclick="editModeOn">
      <template v-if="!isEditing">{{memo.content}}</template>
      <input v-else
             type="text"
             ref="content"
             v-model="memo.content"
             v-on:blur="editModeOff"
             v-on:keydown.enter="updateMemo">
    </p>
    <button type="button" v-on:click="deleteMemo">
      <i class="fas fa-times"></i>
    </button>
  </li>
</template>

<script>
  /**
   * 메모를 보여주는 역할을 하는 컴포넌트, 메모 하나와 매칭된다.
   */
  export default {
    name: "Memo",
    props: {
      memo: {
        type: Object
      }
    },
    data() {
      return {
        isEditing: false
      }
    },
    beforeUpdate() {
      console.log("before update => ", this.$refs.content);
    },
    updated() {
      console.log("updated => ", this.$refs.content);
    },
    methods: {
      deleteMemo() {
        const id = this.memo.id;
        this.$emit('deleteMemo', id);
      },
      editModeOn() {
        this.isEditing = true;
        this.$nextTick(() => {
          this.$refs.content.focus();
        })
      },
      editModeOff() {
        this.isEditing = false;
      },
      updateMemo(e) {
        const id = this.memo.id;
        const content = e.target.value.trim();
        if (content.length <= 0) {
          return false
        }
        this.$emit('updateMemo', {id, content});
        this.isEditing = false;
      }
    },
  }
</script>

<style scoped>
  .memo-item {
    overflow: hidden;
    position: relative;
    margin-bottom: 20px;
    padding: 24px;
    box-shadow: 0 4px 10px -4px rgba(0, 0, 0, 0.2);
    background-color: #fff;
    list-style: none;
  }
  .memo-item button {
    background: none;
    position: absolute;
    right: 20px;
    top: 20px;
    font-size: 20px;
    color: #e5e5e5;
    border: 0;
  }
  .memo-item strong {
    display: block;
    margin-bottom: 12px;
    font-size: 18px;
    font-weight: normal;
    word-break: break-all;
  }
  .memo-item p {
    margin: 0;
    font-size: 14px;
    line-height: 22px;
    color: #666;
  }
  .memo-item p input[type="text"] {
    box-sizing: border-box;
    width: 100%;
    font-size: inherit;
    border: 1px solid #999;
  }
</style>
