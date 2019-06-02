<template>
  <div id="app">
    <Navbar/>

    <router-view/>
    <BackTop></BackTop>

    <MyFooter/>
  </div>
</template>

<script>
  import Navbar from './pages/home/components/Navbar'
  import MyFooter from './pages/home/components/MyFooter'

export default {
  name: 'App',
  components:{
    Navbar,
    MyFooter,
  },
  methods: {

  }
}
</script>

<style>

</style>
