<template>
  <div class="about">
    <div class="content">
      <h1><a id="mirrorblogspringbootvue_0"></a>mirror-blog-springboot-vue</h1>
      <p><img src="http://media.mirrorming.cn/BlogShow.png" alt=""/></p>
      <p><strong>mirror-blog-springboot-vue</strong> 一个基于SpringBoot、vue组件开发的前后端分离的博客项目，希望你能喜欢。欢迎提出建议、star、fork 给作者一些鼓励。
      </p>
      <p class="autoWidth"><a href="https://github.com/mirrormingzZ/mirror-blog-springboot-vue" target="_blank"><img
        src="https://img.shields.io/badge/SpringBoot-v2.0.5.RELEASE-green.svg" alt="License"/></a><br/> <a
        href="https://github.com/mirrormingzZ/mirror-blog-springboot-vue" target="_blank"><img
        src="https://img.shields.io/badge/Vue.js-v2.x-blue.svg" alt="License"/></a><br/> <a
        href="https://github.com/mirrormingzZ/mirror-blog-springboot-vue" target="_blank"><img
        src="https://img.shields.io/badge/Mysql-v5.7.22-blue.svg" alt="License"/></a><br/> <a
        href="https://github.com/mirrormingzZ/mirror-blog-springboot-vue" target="_blank"><img
        src="https://img.shields.io/badge/VueAdminTemplate-v1.0-green.svg" alt="License"/></a></p>

    </div>


  </div>

</template>
<script>

  export default {
    name: 'About',
    components: {},
    data() {
      return {}
    },
    methods: {},
    mounted() {
    },
  }
</script>

<style scoped>
  .about {
    margin-top: 50px;
    background-color: rgba(245, 245, 245, 0.31);
    width: 100%;
  }

  .about img {
    width: 100%;
  }

  .autoWidth img {
    width: auto;
  }

  .content {
    padding: 25px;
  }
</style>
