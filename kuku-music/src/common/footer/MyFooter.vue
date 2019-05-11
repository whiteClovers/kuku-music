<template>
  <div class="footer">
    <div>
      <a-row>
        <a-col :xs="4" :sm="2" :md="2" :lg="2" :xl="2"></a-col>
        <a-col :xs="0" :sm="0" :md="0" :lg="0" :xl="8">
          <div class="siteInfo">
            <span id="busuanzi_container_site_pv">
              <icon-font class="flower" type="icon-meihua"/> 总访问量 <span id="busuanzi_value_site_pv"></span> 次 </span>
            <span id="busuanzi_container_site_uv">
            <icon-font class="flower" type="icon-meihua"/> 总访客数 <span id="busuanzi_value_site_uv"></span> 人 </span>
          </div>
        </a-col>
        <a-col :xs="6" :sm="6" :md="6" :lg="6" :xl="4"></a-col>
        <a-col :xs="0" :sm="0" :md="0" :lg="0" :xl="8">
          <div class="siteInfo">
            <icon-font class="flower" type="icon-meihua"/>
            <span>Crafted by mirror </span>
            <icon-font type="icon-aixin"/>
            <span> &copy; 2019 mirrorming <a href="http://www.miitbeian.gov.cn/">赣ICP备18012845号</a></span>
          </div>
        </a-col>
        <a-col :xs="4" :sm="4" :md="4" :lg="4" :xl="2"></a-col>
      </a-row>
    </div>
  </div>
</template>
<script>
  import {Icon} from 'ant-design-vue';

  let IconFont = Icon.createFromIconfontCN({
    scriptUrl: "//at.alicdn.com/t/font_1024067_yvdeoygj6dn.js",
  })
  export default {
    name: 'MyFooter',
    components: {IconFont},
    data() {
      return {

      }
    },
    methods: {}
  }
</script>
<style scoped>
  .footer {
    height: 66px;
    width: 100%;
    background-color: rgba(248, 248, 248, 0.31);
    box-shadow: 1px 1px 1px 1px rgba(102, 102, 102, 0.1) !important;
  }

  .siteInfo {
    margin: 0 auto;
    text-align: center;
    line-height: 66px;
    font-family: 'Ubuntu', sans-serif;
    font-size: 13px;
    font-weight: 600;
  }

  .flower {
    font-size: 16px;
    opacity: 50%;
    transition: 0.5s;
    animation: rotate 5s linear infinite;
  }

  @keyframes flower {
    0% {
      transform: rotate(0);
    }
    100% {
      transform: rotate(360deg);
    }
  }


</style>
