<template>
  <div id="back-top">
    <a-back-top>
      <div class="back-top-inner">
        <a-icon type="arrow-up"/>
        <div>{{this.percentage}}%</div>
      </div>
    </a-back-top>
  </div>
</template>

<script>

  export default {
    name: 'BackTop',
    components: {},
    props: ['percentage'],
    data() {
      return {}
    },
    methods: {}
  }
</script>
<style scoped>
  #back-top .ant-back-top {
    right: 20px;
    bottom: 18px;
  }

  #back-top .back-top-inner {
    height: 48px;
    width: 48px;
    border-radius: 50%;
    border: 1px solid rgba(245, 245, 245, 0.9);
    box-shadow: 1px 1px 1px 1px rgba(102, 102, 102, 0.1) !important;
    text-align: center;
    cursor: pointer;
  }
</style>
