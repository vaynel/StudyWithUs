
<!-- 대화 창 -->
<template>
  <div class="modal_mask">
    <slot name="character">
    </slot>
    <div class="container_message_modal">
      <slot name="contents">
      </slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MessageModal'
}
</script>