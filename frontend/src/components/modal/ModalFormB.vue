
<!-- 짧은 모달 폼 -->
<template>
  <div class="modal_mask">
    <div>
      <div class="container_modal_form_B">
        <slot name="contents">
        </slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MessageModal'
}
</script>