<template>
  <div class="foot-head foot">
    <div class="content-a">
      <a>关于我们</a>
      <a>文章归档</a>
      <a>百度地图</a>
    </div>
    <div class="content-a">
      <a>kuku music</a>
      <a>Copyright2017-2018</a>
      <a>Email:15979033670@163.Com</a>
    </div>
  </div>

</template>
<script>
  export default {
    data() {
      return {
        value1: 0
      }
    },

  }
</script>

<style scoped>
  /*.foot-head{
    background-color: rgba(0,0,0,0.76);
    height: 100px;
    text-align: center;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
  }*/

  .foot {
    height: 100px;
    width: 100%;

    position: fixed;
    bottom: 0;
    left: 0;
    /*flex: 0 0 auto;*/

    text-align: center;
    background-color: rgba(0,0,0,0.76);
    box-shadow: 1px 1px 1px 1px rgba(102, 102, 102, 0.1) !important;
  }
  .content-a{
    padding-top: 20px;
  }

  a{
    margin-left: 20px;
    color: white;
  }

</style>
