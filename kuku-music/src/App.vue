<template>
  <div id="app">
    <navbar/>
    <router-view/>
    <BackTop></BackTop>
  </div>
</template>

<script>
  import Navbar from './pages/home/components/Navbar'

export default {
  name: 'App',
  components:{
    Navbar
  },
  methods: {

  }
}
</script>

<style>

</style>
