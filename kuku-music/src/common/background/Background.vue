<template>
  <div class="mirrorbg"
       :style="{backgroundImage : 'url('+ 'http://s.cn.bing.net' + this.images.url + ')', backgroundSize:'cover', backgroundPosition:'center center'}">
    <div class="mask-bg" :style="maskStyle"></div>
  </div>
</template>

<script>

  export default {
    name: 'Background',
    components: {},
    data() {
      return {
        maskStyle: {
          backgroundColor: this.$store.state.mirrorTheme === 'light' ? '#FFF' : '#000',
          opacity: this.$store.state.maskOpacity,
        },
        images: {},
      }
    },
    beforeMount() {
      this.getBgImg()
    },
    methods: {
      getBgImg() {
        this.$http.get('/img/bing')
          .then(res => {
              let data = res.data
              this.images = data.data.images[0]
            }
          )
      },
    }
  }
</script>
<style scoped>
  .mirrorbg {
    position: fixed;
    z-index: -3;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }

  .mask-bg {
    position: fixed;
    z-index: -2;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }

</style>
