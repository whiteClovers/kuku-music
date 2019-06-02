<template>
  <div>
    <!--<navbar/>-->
    <!--轮播-->
    <carousel/>

    <!--热门歌曲-->

    <hot-music/>


  </div>
</template>
<script>
  import Navbar from './components/Navbar'
  import Carousel from './components/Carousel'
  import HotMusic from './components/HotMusic'
  import HotMusicList from './components/HotMusicList'
  import RecommentMusic from './components/RecommentMusic'
  import User from './components/User'
  import MyFooter from './components/MyFooter'

  export default {
    components: {
      Navbar,
      Carousel,
      HotMusic,
      HotMusicList,
      User,
      RecommentMusic,
      MyFooter
    },
    data() {
      return {}
    },
    methods: {
      handleSpinShow () {
        this.$Spin.show({
          render: (h) => {
            return h('div', [
              h('Icon', {
                'class': 'demo-spin-icon-load',
                props: {
                  type: 'ios-loading',
                  size: 22
                }
              }),
              h('div', '正在为您加载页面...')
            ])
          }
        });
        setTimeout(() => {
          this.$Spin.hide();
        }, 1200);
      },
    },
    created(){
      this.handleSpinShow();
    },
    mounted() {

    },
  }
</script>

<style scoped>

</style>
