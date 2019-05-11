<template>
  <div>
    <vue-q-art :config="config"></vue-q-art>
  </div>
</template>
<script>
  import VueQArt from 'vue-qart'

  export default {
    name: 'Article',
    components: {VueQArt},
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        config: {
          value: 'http://mirrorming.cn',
          imagePath: 'http://mirrorming.cn:8888/group1/M00/00/00/rBAbeFv6u5mAVtCvAAyfzMe4DUk282.png',
          filter: 'color'
        }
      }
    },
    methods: {},
    mounted() {
    },
  }
</script>

<style scoped>

</style>
